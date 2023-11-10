package com.seoyoung.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoyoung.dto.StudentVO;
import com.seoyoung.model.StudentService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/student/loginCheck.do")
public class StuLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 로그인 form 보낼 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");
		String userType = request.getParameter("userType");
		/*
		 * System.out.println(userType);
		 * 
		 * System.out.println(email); System.out.println(pswd);
		 */
		StudentService sservice = new StudentService();
		// email, pswd를 기준으로 정보 받아오기
		StudentVO stu_login = sservice.loginCheck(email, pswd);

		System.out.println(stu_login);
		// Session 정보 저장

		// 로그인이 성공했는지 실패했는지
		if (userType.equals("student")) { // 학생일 때
			if (stu_login == null) {
				// 실패했다면
				session.setAttribute("loginResult", "아이디와 비밀번호를 다시 입력하세요.");
				response.getWriter().write(
						"<script>alert('로그인에 실패하였습니다. 아이디와 비밀번호를 다시 입력해주세요.'); window.location.href='../login/moveToLogin.do';</script>");
				// response.sendRedirect("../main.do"); // sendRedirect는 get!!
			} else {
				session.setAttribute("loginResult", "");
				session.setAttribute("stuInfo", stu_login); // 로그인 정보를 session에 저장
				response.getWriter().write("<script>alert('I am " + stu_login.getStu_name()
						+ "이예요~~'); window.location.href='stuMyPage.do';</script>");
				// response.sendRedirect("stuMyPage.jsp"); // 수강신청 메뉴 고르는 곳으로 이동
			}
		} else { // 교직원일 때
			if (!(email.equals("admin") && pswd.equals("1234"))) {
				session.setAttribute("loginResult", "아이디와 비밀번호를 다시 입력하세요.");
				response.getWriter().write(
						"<script>alert('로그인에 실패하였습니다. 아이디와 비밀번호를 다시 입력해주세요.'); window.location.href='../login/moveToLogin.do';</script>");
				// System.out.println("실패");
				// response.sendRedirect("../main.do");
			} else {
				session.setAttribute("loginResult", "");
				System.out.println("성공");
				session.setAttribute("emplogin", "직원로그인");
				response.getWriter().write(
						"<script>alert('I am 관리자예요~~'); window.location.href='../employee/empMyPage.do';</script>");
				// response.sendRedirect("empMyPage.jsp");
			}
		}

	}

}
