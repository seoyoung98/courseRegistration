<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일/비밀번호 찾기</title>
<link rel="stylesheet" href="../static/css/findInfo.css">
</head>
<body>
	<!-- 
이메일 찾기 - 학생 번호를 기준으로 찾기
비밀번호 수정 - 이메일을 알고 있을 때 비밀번호 그냥 수정하기
2개 입력받아서 일치하면 바꾸기		
-->
	<header id="header">
		<a href="moveToLogin.do"><span id="mainPage">신한 아카데미</span></a>
	</header>
	<main id="main">
		<div id="search">
			<h3>이메일 찾기</h3>
			<div>
				<form name="findEmail" action="findId.do" method="post">
					<div>
						<p>학생 번호를 입력하세요.</p>
						<input name="stuId" placeholder="ex) 20230001">
						<button id="findEmail" type="submit">이메일 찾기</button>
					</div>
				</form>
			</div>
			<br>
			<h3>비밀번호 찾기</h3>
			<div>
				<form name="changePswd" action="findPswd.do" method="post">
					<div>
						<p>이메일을 입력하세요.</p>
						<input name="stuEmail" placeholder="ex) aaaa@naver.com">
						<button id="findPswd" type="submit">비밀번호 찾기</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<footer id="footer">
		<span>제작자 : @youngee<br></span> <span>이메일 :
			syy0411@naver.com<br>
		</span> <span>오시는 길 : 서울 마포구 월드컵북로4길 77</span>
	</footer>
</body>
<script src="../static/js/findInfo.js"></script>
</html>