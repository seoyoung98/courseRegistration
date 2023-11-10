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

import com.seoyoung.dto.EnrollListVO;
import com.seoyoung.dto.StudentVO;
import com.seoyoung.model.StudentService;

// 수강신청 내역 조회
@WebServlet("/student/stuEnrollList.do")
public class StuSugangListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		StudentVO stuInfo = (StudentVO) session.getAttribute("stuInfo");

		if (stuInfo == null) {
			response.getWriter()
					.write("<script>alert('로그인이나 회원가입을 해주세요.'); window.location.href='../main.do';</script>");
		} else {
			StudentService sservice = new StudentService();
			List<EnrollListVO> stuSubList = sservice.enroll_list(stuInfo.getStu_id());
			request.setAttribute("stuSubList", stuSubList);

			RequestDispatcher rd = request.getRequestDispatcher("stuEnrollList.jsp");
			rd.forward(request, response);
		}

	}
}
