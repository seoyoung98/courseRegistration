package com.seoyoung.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoyoung.dto.StudentVO;
import com.seoyoung.dto.SubjectVO;
import com.seoyoung.model.EmpService;

// 강의 추가하기
// 강의 수정이랑 비슷하게 하면 될 듯
@WebServlet("/employee/subInsert.do")
public class SubInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 삽입하는 창으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String emplogin = (String) session.getAttribute("emplogin");
		System.out.println(emplogin);;
		if (emplogin == null) {
			response.getWriter()
					.write("<script>alert('로그인이나 회원가입을 해주세요.'); window.location.href='../main.do';</script>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("subInsert.jsp");
			rd.forward(request, response);
		}
	}

	// 삽입하기 버튼 누르긴
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		EmpService eService = new EmpService();
		String sub_id = request.getParameter("sub_id");
		String major = request.getParameter("major");
		String sub_name = request.getParameter("sub_name");
		String professor_name = request.getParameter("professor_name");
		int sub_credit = Integer.parseInt(request.getParameter("sub_credit"));
		String class_loc = request.getParameter("class_loc");
		int class_time = Integer.parseInt(request.getParameter("class_time"));
		SubjectVO subject = new SubjectVO(sub_id, major, sub_name, sub_credit, professor_name, class_loc, class_time);
		int result = eService.insertSubject(subject);
		// PrintWriter pw = response.getWriter();

		if (result > 0) {
			response.getWriter()
					.write("<script>alert('강의 추가에 성공하였습니다.'); window.location.href='empSubList.do';</script>");
		} else {
			response.getWriter().write(
					"<script>alert('강의 추가에 실패하였습니다. 다시 입력해주세요.'); window.location.href='subInsert.do';</script>");
		}
	}

}
