<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 삽입</title>
<link rel="stylesheet" href="../static/css/empModify.css">
</head>
<body>
	<header id="header">
		<div id="top">
			<span id="mainPage">신한 아카데미</span>
			<div id="myPage">
				<a href="empMyPage.do">관리자 페이지로 돌아가기</a>
				<h1>관리자</h1>
				<a href="../login/logout.do">로그아웃</a>
			</div>
		</div>
	</header>
	<main id="main">
		<div id="subList">
			<form action="subInsert.do" id="sapip" method="post">
				<div>
					과목 번호 : <input value="${subject.sub_id }" name="sub_id" id="sub_id"
						placeholder="영어대문자, 숫자 10자(중복 불가능)" />
				</div>
				<div>
					전공 : <input value="${subject.major }" name="major" id="major"
						placeholder="전공">
				</div>
				<div>
					강의명 : <input value="${subject.sub_name }" name="sub_name"
						id="sub_name" placeholder="강의명">
				</div>
				<div>
					교수명 : <input value="${subject.professor_name}"
						name="professor_name" id="professor_name" placeholder="교수명">
				</div>
				<div>
					학점 : <input value="${subject.sub_credit}" name="sub_credit"
						id="sub_credit" placeholder="최대 3학점">
				</div>
				<div>
					강의실 위치 : <input value="${subject.class_loc}" name="class_loc"
						id="class_loc" placeholder="영어대문자, 숫자 5자">
				</div>
				<div>
					수업 시간 : <input value="${subject.class_time}" name="class_time"
						id="class_time" placeholder="강의 시간 1~7">
				</div>
				<button type="submit">강의 추가 합시다.</button>
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
	$('#sapip').on('submit', function(event) {
		event.preventDefault();
		var param = { // object 생성
			sub_id : $('#sub_id').val(),
			major : $('#major').val(),
			sub_name : $('#sub_name').val(),
			professor_name : $('#professor_name').val(),
			sub_credit : $('#sub_credit').val(),
			class_loc : $('#class_loc').val(),
			class_time : $('#class_time').val()

		}
		$.ajax({
			url : "subInsert.do",
			data : param,
			type : "post",
			success : function(response) {
				alert(response);

				if (response === "삽입완료") {
					alert("success");
					location.href = "empSubList.do";
				} else {
					alert("fail");
				}
			}
		});
	});
</script>
</html>