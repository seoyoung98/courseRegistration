<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link rel="stylesheet" href="../static/css/studentPage.css">
</head>
<body>
	<!-- 로그인한 학생의 마이페이지
	input으로 메뉴 선택
	1. 수강신청
	2. 수강신청 목록 조회
	3. 비밀번호 수정
	로그아웃 -> 모든 페이지에 들어가게끔 만들기
	-->
	<header id="header">
		<span id="mainPage">신한 아카데미</span>
		<div id="myPage">
			<h3>${stuInfo.stu_name} 학생</h3>
			<a href="../login/logout.do">로그아웃</a>
		</div>
	</header>
	<main id="main">
		
		<h1>메뉴를 선택해주세요.</h1>
		<div>
			<button type="button" id="enrollInsert">수강 신청</button>
			<button type="button" id="enrollList">수강 신청 내역 조회</button>
		</div>
	</main>
	<footer id="footer">
		<span>제작자 : @youngee<br></span> <span>이메일 :
			syy0411@naver.com<br>
		</span> <span>오시는 길 : 서울 마포구 월드컵북로4길 77</span>
	</footer>
	<script src="../static/js/student.js"></script>
</body>
</html>