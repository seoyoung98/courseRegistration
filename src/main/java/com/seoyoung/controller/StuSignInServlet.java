package com.seoyoung.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoyoung.dto.StudentVO;
import com.seoyoung.model.StudentService;


// 학생 회원가입
@WebServlet("/login/stuSignIn.do")
public class StuSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String stu_name = request.getParameter("stu_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone_num");
		
		StudentService sservice = new StudentService();
		StudentVO sVo = new StudentVO(stu_name,password,address,phone,email);
		int result = sservice.insertStudent(sVo);
		
		if(result > 0) {
			response.getWriter().write(
					"<script>alert('회원가입에 성공하였습니다.'); window.location.href='../main.do';</script>");
		}else {
			response.getWriter().write(
					"<script>alert('회원가입에 실패하였습니다. 다시 입력해주세요.'); window.location.href='stuSignIn.do';</script>");
		}
		
	}
	
	// 메인 화면에서 버튼을 눌렀을 때
	// 회원가입하는 창으로 이동하기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signIn.jsp");
		rd.forward(request, response);
		
	}
}
