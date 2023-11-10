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
import com.seoyoung.model.StudentService;

// 수강신청버튼을 누르면 신청이 되도록 만들기
@WebServlet("/student/stuSubInsert.do")
public class StuSubInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인을 해서 session에서 로그인 값을 가져와야함
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		HttpSession session = request.getSession();
		StudentVO stuInfo = (StudentVO) session.getAttribute("stuInfo");

		if (stuInfo == null) {
			response.getWriter()
					.write("<script>alert('로그인이나 회원가입을 해주세요.'); window.location.href='../main.do';</script>");
		} else {
			String subId = request.getParameter("sub_id");

			StudentService sservice = new StudentService();
			int result = sservice.insertEnroll(stuInfo.getStu_id(), subId);

			response.setContentType("text/html; charset=utf-8");


			if (result > 0) {
				response.getWriter().write("<script>alert('수강신청 완료'); window.location.href='stuSubTotalList.do';</script>");

			} else if (result == 0) {
				response.getWriter()
						.write("<script>alert('이미 수강신청한 과목입니다.'); window.location.href='stuSubTotalList.do';</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("stuEnroll.jsp");
		rd.forward(request, response);
	}

}
