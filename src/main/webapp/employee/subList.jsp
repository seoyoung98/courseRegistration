<%@page import="com.seoyoung.model.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.seoyoung.dto.SubjectVO"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 목록</title>
<link rel="stylesheet" href="../static/css/empSubList.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="../static/js/empSubList.js"></script>
</head>
<body>
	<header id="header">
		<div id="top">
			<span id="mainPage">신한 아카데미</span>
			<div id="myPage">
				<a href="empMyPage.do">마이페이지로 돌아가기</a>
				<h1>관리자</h1>
				<a href="../login/logout.do">로그아웃</a>
			</div>
		</div>
	</header>
	<main id="main">
		<!-- 로그아웃 페이지 디렉티브 태그 만들기 -->
		<div id="container">
			<!--  
		<select id="professor_name" name="professor_name">
			
		</select> -->
			<input id="professor_name" name="professor_name" placeholder="교수이름">
			<button class="search" id="search_pro">교수님 찾기</button>
			<!-- <select id="major" name="major">
			
		</select> -->
			<input id="major" name="major" placeholder="전공명">
			<button class="search" id="search_major">전공 찾기</button>
			<!-- <select id="sub_name" name="sub_name">
			
		</select> -->
			<input id="sub_name" name="sub_name" placeholder="과목명">
			<button class="search" id="search_sub">과목 찾기</button>
		</div>
		<br>
		<div id="insertDiv">
			<button id="subInsert" name="subInsert">과목 추가하기</button>
		</div>

		<div id="subList">
			<h1>강의 목록</h1>
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
					<tr id="no_results" style="display: none;">
						<td colspan="9">해당하는 강의가 없습니다.</td>
					</tr>
					<c:if test="${empty subList}">
						<tr>
							<td colspan="9" id="emptyrent">해당하는 강의가 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:if test="${not empty subList}">
						<c:forEach items="${subList}" var="sub" varStatus="status">
							<tr seq="${status.count }" id="subtr">
								<td class="aa">${status.count}</td>
								<td id="subId">${sub.sub_id}</td>
								<td>${sub.major}</td>
								<td>${sub.sub_name}</td>
								<td>${sub.sub_credit}</td>
								<td>${sub.professor_name}</td>
								<td>${sub.class_loc}</td>
								<td>${sub.class_time}</td>
								<td>${sub.count_stu}</td>
								<td>
									<button
										onclick="location.href='subModify.do?sub_id=${sub.sub_id}'">
										상세보기</button>
								</td>
								<td>
									<button id="subDelete" name="subDelete" value="${sub.sub_id }">강의
										삭제</button>
								</td>
							</tr>
						</c:forEach>
					</c:if>
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
		$('table button[name="subDelete"]').on('click', function() {
			if (confirm("정말 삭제하시겠습니까?")) {
				$.ajax({
					url : "subDelete.do",
					data : {
						sub_id : $(this).val()
					},
					type : "get",
					success : function(response) {
						alert(response);

						if (response === "삭제완료") {
							alert("강의 삭제에 성공하였습니다.");
							location.href = "empSubList.do";
						} else {
							alert("강의 삭제에 실패하였습니다.");
							location.href = "empSubList.do";
						}
					}
				});
			} else {
				alert("강의를 삭제하지 않았습니다.");
				location.href = "empSubList.do";
			}
		});
	</script>
</body>
</html>