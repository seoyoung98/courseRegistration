package com.seoyoung.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/login/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 현재 요청의 세션을 가져옵니다. (세션이 없는 경우 새로 생성되지 않음)
		HttpSession session = request.getSession(false);

		if (session != null) {
			// 세션을 무효화하여 로그아웃을 수행합니다.
			session.invalidate();
		}

		// 로그아웃 후, 로그인 페이지로 리다이렉션합니다.
		response.sendRedirect("../main.do"); // 로그인 페이지로 리다이렉션할 경로를 수정하세요.
	}

}
