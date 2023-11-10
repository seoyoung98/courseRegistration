<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../static/css/empPage.css">
<title>직원 마이페이지</title>
</head>
<body>
	<!-- 로그인한 직원의 마이페이지
	input으로 메뉴 선택
	1. 강의 조회
	2. 강의 추가
	3. 강의 삭제
	4. 강의 수정
	로그아웃 -> 모든 페이지에 들어가게끔 만들기
 	-->
	<header id="header">
		<span id="mainPage">신한 아카데미</span>
		<div id="myPage">
			<h1>관리자</h1>
			<a href="../login/logout.do">로그아웃</a>
		</div>
	</header>
	<main id="main">
		<h1>메뉴를 선택해주세요.</h1>
		<div>
			<button type="button" id="subList">강의 조회</button>
			<button type="button" id="subInsert">강의 추가</button>
		</div>
	</main>
	<footer id="footer">
		<span>제작자 : @youngee<br></span> <span>이메일 :
			syy0411@naver.com<br>
		</span> <span>오시는 길 : 서울 마포구 월드컵북로4길 77</span>
	</footer>
	<script src="../static/js/employee.js"></script>
</body>
</html>