<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.seoyoung.model.StudentService"%>
<%@ page import="com.seoyoung.dto.EnrollListVO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청 내역</title>
<link rel="stylesheet" href="../static/css/stuEnroll.css">
</head>
<body>
	<header id="header">
		<div id="top">
			<span id="mainPage">신한 아카데미</span>
			<div id="myPage">
				<a href="stuMyPage.do">마이페이지로 돌아가기</a><br> <a href="../login/logout.do">로그아웃</a>
			</div>
		</div>
	</header>
	<main id="main2">
		<div id="subList">
			<h1>${stuInfo.stu_name}님의수강신청내역입니다.</h1>
			<table border="1">
				<thead>
					<tr>
						<th>수강 신청 번호</th>
						<th>강의 번호</th>
						<th>강의명</th>
						<th>교수 이름</th>
						<th>강의실 위치</th>
						<th>강의 시간</th>
						<th>학점</th>
					</tr>
				</thead>
				<!-- 눈에는 안보이지만 속성으로 i 번호를 매겨줬다. -->
				<tbody>
					<c:forEach items="${stuSubList}" var="enrollList"
						varStatus="status">
						<tr>
							<td id="enroll_num">${enrollList.enroll_num}</td>
							<td>${enrollList.sub_id}</td>
							<td>${enrollList.sub_name}</td>
							<td>${enrollList.sub_credit}</td>
							<td>${enrollList.class_loc}</td>
							<td>${enrollList.class_time}</td>
							<td>${enrollList.sub_credit}</td>
							<td><button
									onclick="location.href='stuSugangDelete.do?enroll_num=${enrollList.enroll_num}'">
									수강 취소</button></td>
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
</body>
</html>