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

import org.apache.catalina.connector.Response;

import com.seoyoung.dto.StudentVO;
import com.seoyoung.dto.SubjectVO;
import com.seoyoung.model.EmpService;

/**
 * Servlet implementation class SubModifyServlet
 */
@WebServlet("/employee/subModify.do")
public class SubModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 상세보기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String emplogin = (String) session.getAttribute("emplogin");

		if (emplogin == null) {
			response.getWriter()
					.write("<script>alert('로그인이나 회원가입을 해주세요.'); window.location.href='../main.do';</script>");
		} if(emplogin.equals("직원로그인")){
			String subId = request.getParameter("sub_id");

			EmpService eService = new EmpService();
			SubjectVO subject = eService.selectSubInfo(subId);

			request.setAttribute("subject", subject);

			RequestDispatcher rd = request.getRequestDispatcher("subDetail.jsp");
			rd.forward(request, response);
		}
	}

	// 수정
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		HttpSession session = req.getSession();
		StudentVO stuInfo = (StudentVO) session.getAttribute("stuInfo");
		String emplogin = (String) session.getAttribute("emplogin");
		if (emplogin == null) {
			resp.getWriter()
					.write("<script>alert('로그인이나 회원가입을 해주세요.'); window.location.href='../main.do';</script>");
		} else {
			// req.setCharacterEncoding("utf-8");
			EmpService eService = new EmpService();
			String sub_id = req.getParameter("sub_id");
			String major = req.getParameter("major");
			String sub_name = req.getParameter("sub_name");
			String professor_name = req.getParameter("professor_name");
			int sub_credit = Integer.parseInt(req.getParameter("sub_credit"));
			String class_loc = req.getParameter("class_loc");
			int class_time = Integer.parseInt(req.getParameter("class_time"));
			SubjectVO subject = new SubjectVO(sub_id, major, sub_name, sub_credit, professor_name, class_loc,
					class_time);
			int result = eService.updateSubject(subject);
			System.out.println(result);

			// 감사감사
			resp.setContentType("text/plain; charset=utf-8");
			PrintWriter pw = resp.getWriter();

			if (result > 0) {
				pw.print("수정완료");
				return;
			} else {
				pw.print("수정실패");
			}

			/*
			 * ajax 쓰면 없어도 됨 RequestDispatcher rd =
			 * req.getRequestDispatcher("empMyPage.jsp"); rd.forward(req, resp);
			 */
		}
	}

}
