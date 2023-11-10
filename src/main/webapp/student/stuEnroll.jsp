<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.seoyoung.dto.SubjectVO"%>
<%@page import="com.seoyoung.model.EmpService"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../static/css/stuEnroll.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="../static/js/stuEnrollList.js"></script>
<title>수강신청 페이지</title>
</head>
<body>
	<header id="header">
		<div id="top">
			<span id="mainPage">신한 아카데미</span>
			<div id="myPage">
				<a href="stuMyPage.do">마이페이지로 돌아가기</a>
				<h1>${stuInfo.stu_name}학생</h1>
				<a href="../login/logout.do">로그아웃</a>
			</div>
		</div>
	</header>
	<main id="main">
		<div id="container">
			<!--  
		<select id="professor_name" name="professor_name">
			
		</select> -->
			<input id="professor_name" name="professor_name" placeholder="교수이름">
			<button id="search_pro">교수님 찾기</button>
			<!-- <select id="major" name="major">
			
		</select> -->
			<input id="major" name="major" placeholder="전공명">
			<button id="search_major">전공 찾기</button>
			<!-- <select id="sub_name" name="sub_name">
			
		</select> -->
			<input id="sub_name" name="sub_name" placeholder="과목명">
			<button id="search_sub">과목 찾기</button>
		</div>
		<div id="subList">
			<h1>수강신청 전체 강의 목록</h1>
			<table id="subTable" border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>강의 번호</th>
						<th>전공</th>
						<th>강의 이름</th>
						<th>학점</th>
						<th>교수 이름</th>
						<th>강의실 위치</th>
						<th>강의 시간</th>
						<th>학생 수</th>
					</tr>
				</thead>
				<!-- 눈에는 안보이지만 속성으로 i 번호를 매겨줬다. -->
				<tbody>
					<c:forEach items="${subList}" var="sub" varStatus="status">
						<tr seq="${status.count }" id="subtr">
							<td class="aa">${status.count}</td>
							<td id="sub_id">${sub.sub_id}</td>
							<td>${sub.major}</td>
							<td>${sub.sub_name}</td>
							<td>${sub.sub_credit}</td>
							<td>${sub.professor_name}</td>
							<td>${sub.class_loc}</td>
							<td>${sub.class_time}</td>
							<td>${sub.count_stu}</td>
							<td>
								<button id="enrollAdd"
									onclick="location.href='stuSubInsert.do?sub_id=${sub.sub_id}'">신청</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<footer id="footer">
		<span>제작자 : @youngee<br></span> <span>이메일 :
			syy0411@naver.com<br>
		</span> <span>오시는 길 : 서울 마포구 월드컵북로4길 77</span>
	</footer>

	<script>
		// JavaScript function to show a confirmation dialog
		function confirmDelete() {
			if (confirm('강의를 정말 삭제하시겠습니까?')) {
				window.location.href = 'employee/stuSubTotalList.do';
			} else {
				window.location.href = 'employee/stuSubTotalList.do';
			}
		}
	</script>
	<script>
		/*
			$('#enrollAdd').on('submit',function(event) {
				event.preventDefault();
				$.ajax({
					url : "stuSubInsert.do",
					data : {sub_id : ${sub.sub_id}},
					type : "GET",
					success : function(response) {

						if (response === "수강 신청 완료") {
							System.out.println("성공이당");
							alert("success");
							location.href = "stuSubInsert.do";
						} else if(response === "수강 신청 실패"){
							alert("fail");
							location.href = "stuSubInsert.do";
						}
					}
				});
			});*/
	</script>
</body>



</html>