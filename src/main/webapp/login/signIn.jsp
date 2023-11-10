<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="../static/css/signin.css">
<title>회원가입 창 입니다.</title>
</head>
<body>
	<header id="header">
		<a href="moveToLogin.do"><span id="mainPage">신한 아카데미</span></a>
	</header>
	<main id="main">
		<div class="signin">
			<h3>학생 정보를 입력하세요.</h3>
			<form name="stusignin" id="stusignin" action="stuSignIn.do"
				method="post">
				<div>
					학생 이름 : <input name="stu_name" id="stu_name" />
				</div>
				<div>
					이메일 : <input name="email" id="email" type="text"
						placeholder="aaaaa@google.com" />
				</div>
				<div>
					비밀번호 : <input type="text" id="password" name="password" />
				</div>
				<div>
					주소 : <input type="text" id="address" name="address"
						placeholder="서울, 경기도, 전라도, 경상도, 강원도, 충청도, 제주도">
				</div>
				<div>
					전화번호 : <input type="text" id="phone_num" name="phone_num"
						placeholder="###-###-####" />
				</div>
				<button id="stuInfo" type="submit">등록</button>
			</form>
		</div>
	</main>
	<footer id="footer">
		<span>제작자 : @youngee<br></span> <span>이메일 :
			syy0411@naver.com<br>
		</span> <span>오시는 길 : 서울 마포구 월드컵북로4길 77</span>
	</footer>
</body>
<script>
	$('#stuInfo').on('submit', function(event) {
		event.preventDefault();
		var param = { // object 생성
			stu_name : $('#stu_name').val(),
			email : $('#email').val(),
			password : $('#password').val(),
			address : $('#address').val(),
			phone_num : $('#phone_num').val()
		}
		$.ajax({
			url : "findIdPswd.do",
			data : param,
			type : "post",
			success : function(response) {
				alert(response);

				if (response === "등록 완료!") {
					alert("success");
					location.href = "main.do";
				} else {
					alert("fail");
				}
			}
		});
	});
</script>
</html>