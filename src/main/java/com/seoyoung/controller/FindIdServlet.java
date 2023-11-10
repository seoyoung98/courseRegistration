package com.seoyoung.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoyoung.model.StudentService;

// 이메일 찾기
@WebServlet("/login/findId.do")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		HttpSession session = request.getSession();
		int stuId = Integer.parseInt(request.getParameter("stuId"));

		StudentService sservice = new StudentService();
		String findEmail = sservice.findEmail(stuId);
		System.out.println(findEmail);
		
		PrintWriter pw = response.getWriter();
		
		if (findEmail == null) {
			pw.print("학생 번호가 존재하지 않습니다.");
			response.getWriter().write(
					"<script>alert('학생 번호가 존재하지 않습니다. 다시 입력하세요.'); window.location.href='findIdPswd.do';</script>");
		} else if (findEmail != null) {
			request.setAttribute("findEmail", findEmail);
			pw.print("이메일을 찾았다.");
			response.getWriter().write(
					"<script>alert('"+stuId+"님의 이메일은" + findEmail +" 입니다.'); window.location.href='moveToLogin.do';</script>");

		}

	}

}
