package com.seoyoung.controller;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class EmpSubListServlet
 */
@WebServlet("/employee/empSubList.do")
public class SubListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String emplogin = (String) session.getAttribute("emplogin");

		if (emplogin == null) {
			response.getWriter()
					.write("<script>alert('로그인이나 회원가입을 해주세요.'); window.location.href='../main.do';</script>");
		} else {

			EmpService eService = new EmpService();
			List<SubjectVO> subList = eService.selectSubjectVO();
			request.setAttribute("subList", subList);

			RequestDispatcher rd = request.getRequestDispatcher("subList.jsp");
			rd.forward(request, response);
		}

	}

}
