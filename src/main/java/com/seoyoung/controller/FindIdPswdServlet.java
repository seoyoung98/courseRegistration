package com.seoyoung.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seoyoung.model.StudentService;

// 이메일 찾기, 비밀번호 찾기 페이지로 이동하는 서블릿
@WebServlet("/login/findIdPswd.do")
public class FindIdPswdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 이동, 그냥 이동만 하는 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("findInfo.jsp");
		rd.forward(request, response);

	}


}
