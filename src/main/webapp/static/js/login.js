
/*
document.querySelector("#loginBtn").onclick = function() {
	location.href = "student/loginCheck.do";
};*/

document.querySelector("#findIdPswd").onclick = function() {
	location.href = "findIdPswd.do";
};

document.querySelector("#signIn").onclick = function() {
	location.href = "stuSignIn.do";
};



/*
document.querySelectorAll('input[type=radio]').forEach(function(radio) {
	radio.addEventListener('change', function() {
		
		var loginForm = document.getElementById('loginForm');
		 console.log("Change event triggered. Value: " + this.value);
		if (this.value === 'student') {
			console.log("Redirect to student");
            loginForm.action = 'student/loginCheck.do';
        } else if (this.value === 'employee') {
            loginForm.action = 'employee/empLoginCheck.do';
        }
	});
});



















/*
document.addEventListener("DOMContentLoaded", function() {
  // "로그인" 버튼을 클릭할 때의 이벤트 처리
  const loginBtn = document.getElementById("loginBtn");
  loginBtn.addEventListener("click", function() {
    // 선택된 사용자 유형 가져오기
    const userType = document.querySelector('input[name="userType"]:checked').value;
    
    // 페이지 이동을 처리
    if (userType === "student") {
      // 학생 페이지로 이동
      window.location.href = "student/loginCheck.do"; // 여기에 학생 페이지 경로를 넣어주세요.
    } else if (userType === "employee") {
      // 교직원 페이지로 이동
      window.location.href = "employee/empLoginCheck.do"; // 여기에 교직원 페이지 경로를 넣어주세요.
    }
  });
});*/


/*
	var message = "${loginResult}";
	if (message != "") alert(message);


/*
document.querySelectorAll('input[type=radio]').forEach(function(radio) {
	radio.addEventListener('change', function() {
		if (this.value == 'student') {
			document.getElementById('loginForm').onclick = function(){
				location.href ='student/loginCheck.do';
			}
		} else if(this.value == 'employee'){
			document.getElementById('loginForm').onclick = function(){
				location.href ='employee/empLoginCheck.do';
			}
		}
	});
});
document.querySelectorAll('input[type=radio]').forEach(function(radio) {
    radio.addEventListener('change', function() {
        if (this.value === 'student') {
            document.getElementById('loginForm').setAttribute('action', 'student/loginCheck.do');
        } else if (this.value === 'employee') {
            document.getElementById('loginForm').setAttribute('action', 'employee/empLoginCheck.do');
        }
    });
    document.getElementById('loginForm').submit();
});*/
/*
document.getElementById('loginBtn').addEventListener('click', function() {
	var userType = document.querySelector('input[name="userType"]:checked').value;
	if (userType === 'student') {
		location.href = 'student/loginCheck.do';
	} else if (userType === 'employee') {
		location.href = 'employee/empLoginCheck.do';
	}
});
*/





