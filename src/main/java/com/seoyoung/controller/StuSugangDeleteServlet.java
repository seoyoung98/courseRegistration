package com.seoyoung.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoyoung.model.StudentService;

/**
 * Servlet implementation class StuSugangDeleteServlet
 */
@WebServlet("/student/stuSugangDelete.do")
public class StuSugangDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int enroll_num = Integer.parseInt(request.getParameter("enroll_num"));
		StudentService sservice = new StudentService();
		int result = sservice.deleteEnroll(enroll_num);


		PrintWriter pw = response.getWriter();

		if (result > 0) {
			pw.print("수강 취소 성공");
			response.getWriter().write("<script>alert('수강 취소 성공'); window.location.href='stuEnrollList.do';</script>");
			
		} else if(result == 0) {
			pw.print("수강 취소 실패");
			response.getWriter().write("<script>alert('수강 취소에 실패하였습니다. 다시 시도해주세요.'); window.location.href='stuEnrollList.do';</script>");
		}

	}

}
