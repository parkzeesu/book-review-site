function ck() {
	
	let id = $("#n_id").val();
	

	$.ajax({
		type: "get",
		dataType: "text",
		url: "http://localhost:8090/p3/ajaxtest",
		data: { "n_id": id },
		success: function(data, textStatus) {
			if (data == 1) {
				alert("아이디 중복 되었습니다");
			} else {
				alert("사용가능합니다.")
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