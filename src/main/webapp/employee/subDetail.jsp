<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 상세 보기</title>
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
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
			<form action="subModify.do" id="sujeong" method="post">
				<div>
					과목 번호 : <input value="${subject.sub_id }" name="sub_id" id="sub_id"
						readonly="readonly" />
				</div>
				<div>
					전공 : <input value="${subject.major }" name="major" id="major">
				</div>
				<div>
					강의명 : <input value="${subject.sub_name }" name="sub_name"
						id="sub_name">
				</div>
				<div>
					교수명 : <input value="${subject.professor_name}"
						name="professor_name" id="professor_name">
				</div>
				<div>
					학점 : <input value="${subject.sub_credit}" name="sub_credit"
						id="sub_credit">
				</div>
				<div>
					강의실 위치 : <input value="${subject.class_loc}" name="class_loc"
						id="class_loc">
				</div>
				<div>
					수업 시간 : <input value="${subject.class_time}" name="class_time"
						id="class_time">
				</div>
				<button id="submit" type="submit">수정하세요.</button>
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
	$('#sujeong').on('submit', function(event) {
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
			url : "subModify.do",
			data : param,
			type : "post",
			success : function(response) {

				if (response === "수정완료") {
					alert("수정 완료");
					location.href = "empSubList.do";
				} else {
					alert("수정 실패");
				}
			}
		});
	});
</script>
</html>