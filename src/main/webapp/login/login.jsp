<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아카데미 수강신청</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!--<script src="index.js"></script>-->

<link rel="stylesheet" href="../static/css/login.css">
</head>
<body>
	<header id="header">
		<a href="../main.do"><span id="mainPage">신한 아카데미</span></a>
	</header>
	<main id="main">
		<div class="container">
			<form name="roleselect" action="../student/loginCheck.do" id="loginForm"
				method="post">
				<div id="raioSelect">
					학생 : <input type="radio" name="userType" value="student" checked>
					교직원 : <input type="radio" name="userType" value="employee">
				</div>
				<br>
				<div class="login">
					<h3 class="inputInfo">아이디(이메일)</h3>
					<div class="inputInfo">
						<input type="text" name="email" placeholder="아이디를 입력하세요.">
					</div>
					<h3 class="inputInfo">비밀번호</h3>
					<div class="inputInfo">
						<input type="password" name="pswd"
							placeholder="비밀번호를 입력하세요.(문자 9 ~ 16자리)">
					</div>
				</div>
				<button type="submit" id="loginBtn">로그인</button>
			</form>

			<input id="findIdPswd" type="button" value="아이디/비밀번호 찾기"><input
				id="signIn" type="button" value="회원가입">
		</div>
	</main>
	<footer id="footer">
		<span>제작자 : @youngee<br></span> <span>이메일 :
			syy0411@naver.com<br>
		</span> <span>오시는 길 : 서울 마포구 월드컵북로4길 77</span>
	</footer>
	<script src="../static/js/login.js"></script>

</body>
<script>
	/*
	 $("form").on("submit", function(e) {
	 e.preventDefault();
	 alert($("form input[type=radio]:checked").val());
	
	 })*/
</script>
</html>