function ck() {

	let name = $("#n_name").val();
	let tel = $("#n_tel").val();

	$.ajax({
		type: "get",
		dataType: "text",
		url: "http://localhost:8090/p3/ajaxtest2",
		data: { "n_name": name, "n_tel": tel },
		success: function(data, textStatus) {
			if (data == null) {
				alert(data);
			} else {
				alert(data);
				location.href = '/p3/jsp/login/로그인.jsp'
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