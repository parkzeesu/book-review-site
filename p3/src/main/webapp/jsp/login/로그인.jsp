<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" href="/p3/html/darkmode/toggle_style.css">
<link rel="stylesheet" href="로그인.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="로그인.js"></script>

</head>
<body>

	<form name =frm method="post" action="세션로그인.jsp" >
	<label class="switch">
			<input id="switch_btn" type="checkbox" checked>
			<span class="icon_box">
				<ion-icon name="bulb-outline"></ion-icon>
			</span>
		</label>
		<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
		<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
		<script src="/p3/html/darkmode/toggle.js"></script>
		<script src="/p3/html/darkmode/change.js"></script>
		<table>
			<tbody>
			<caption>로그인</caption>
			<tr>
				<td><input type="text" name="n_id" id="n_id" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input type="password" name="n_pw" id="n_pw" placeholder="비밀번호"></td>
			</tr>
			</tbody>
		</table>
		<div id="btn_td">
		
		<button type= 'submit' onclick="login();">로그인</button>
		<button type= 'button' onclick="search_id();">아이디 찾기</button>
		<button type= 'button' onclick="search_pw();">비밀번호 찾기</button>
		<button type= 'button' onclick="go_register();">회원가입</button>
	</div>
	</form>
</html>