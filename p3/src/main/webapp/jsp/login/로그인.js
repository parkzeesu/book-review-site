function login() {
	let frm = document.frm;
	let n_id = frm.n_id;  // 폼의 아이디 태그
	let n_pw = frm.n_pw;

	if (n_id.value == "") {
		alert("아이디를 입력하세요");
		n_id.focus();
	} else if (n_pw.value == "") {
		alert("비밀번호 입력하세요");
		n_pw.focus();
	} else {
		let id = $("#n_id").val();
		let pw = $("#n_pw").val();
	
	$.ajax({
		type: "get",
		dataType: "text",
		url: "http://localhost:8090/p3/ajaxtest4",
		data: { "n_id": id , "n_pw": pw  }  ,
		success: function(data, textStatus) {
			if (data == 1) {
				alert(id +"님 환영합니다~!^^");
				
			} else {
				alert("없는 계정 입니다 다시 확인해 주세요");
			}

		},
		error: function(data, textStatus) {
			alert("서버통신 에러")
		},
		complete: function(data, textStatus) {
			// alert("작업완료");

		}
	});
	}
}

function search_id() {

	alert("아이디 찾기 페이지로 넘어 갑니다");
	location.href = '/p3/html/findid/아이디찾기.html'


}

function search_pw() {

	alert("비밀번호 찾기 페이지로 넘어 갑니다");
	location.href = '/p3/html/findpw/비밀번호찾기.html'
}

function go_register() {

	alert("회원가입 화면으로 넘어 갑니다");
	location.href = '/p3/html/Register/회원가입.html'

}
