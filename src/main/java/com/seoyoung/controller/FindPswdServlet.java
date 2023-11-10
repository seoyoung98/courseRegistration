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

// 비밀번호 찾기
@WebServlet("/login/findPswd.do")
public class FindPswdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String stuEmail = request.getParameter("stuEmail");
		StudentService sservice = new StudentService();
		String findPswd = sservice.findPassword(stuEmail);

		PrintWriter pw = response.getWriter();
		if (findPswd == null) {
			pw.print("학생 번호가 존재하지 않습니다.");
			response.getWriter().write(
					"<script>alert('학생 번호가 존재하지 않습니다. 다시 입력하세요.'); window.location.href='findIdPswd.do';</script>");
		} else if (findPswd != null) {
			request.setAttribute("findEmail", findPswd);
			response.getWriter().write("<script>alert('" + stuEmail + "의 비밀번호는 " + findPswd
					+ " 입니다.'); window.location.href='../main.do';</script>");

		}
	}

}
