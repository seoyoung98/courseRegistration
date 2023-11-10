package com.seoyoung.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seoyoung.dto.SubjectVO;
import com.seoyoung.model.EmpService;

/**
 * Servlet implementation class EmpSubDeleteServlet
 */
@WebServlet("/employee/subDelete.do")
public class SubDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 삭제버튼을 누르면 result가 올라가면 삭제하기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String subId = request.getParameter("sub_id");

		System.out.println(subId);
		EmpService eService = new EmpService();
		
		
		int result = eService.deleteSubject(subId);
		
		PrintWriter pw = response.getWriter();
		if (result > 0) {
			pw.write("삭제완료");
		} else if (result == 0) {
			pw.write("삭제실패");
		}

		// 삭제에 성공하면 성공 메세지
		// 삭제에 실패하면 실패 메세지
		// 후 sublist 페이지로 이동하기

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
