<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.ArrayList" %>
    <%@ page import ="main.Genre" %>
    <%@ page import ="main.Book" %>
    <%@ page import ="main.Review" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book:Link</title>
<link rel="stylesheet" href="/p3/html/darkmode/toggle_style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/bookSelect/bookSelect.css">

<script type="text/javascript">

	function search(){
		let sbook = document.getElementById("search_input");
		
		let bname = sbook.value;
		
		if(bname == ""){
			alert("제목을 입력해주세요!");
		}else{
			alert("검색중입니다!");
			window.location.href ="searchbook?b_name="+bname;
		}
	}

</script>

</head>

<body>

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
    
    <header>
        <div id="logo_area">
            <h1 class="logo"><a class="logo" href="/p3/mainbooklist">Book:Link</a>&nbsp;<span>책에 대한 모든 것!</span> </h1>
        </div>
		<div id="search_area">
			<div id="search_wrap">
				<input id="search_input" type="text" placeholder="궁금한 도서를 입력하세요!">
				<div id="search_icon" onclick="search();"></div>
			</div>
		</div>
		<div id="login_area">
            <div id="login">
            
                <%
				String id = (String) session.getAttribute("n_id");
				%>
				<%
				if (id != null) {
				%>
				<span><%=id%>님 환영합니다~!!</span>
				<a href="/p3/jsp/login/세션로그아웃.jsp">로그아웃</a>
				<%
				} else {
				%>
				<a href="/p3/jsp/login/로그인.jsp">로그인</a> <span>|</span> <a href="/p3/html/Register/회원가입.html">회원가입</a>
				<% } %>
				
            </div>
        </div>
    </header>

    <nav>
        <div>
        	<ul id="menu_wrap">
            <% ArrayList<Genre> Glist = (ArrayList<Genre>)request.getAttribute("Glist"); %>
            <% for(int i=0; i<Glist.size(); i++){
            		Genre g = (Genre)Glist.get(i);
                 %>
                <li class="menu_area">
                    <a class="menu" href="getpagebooks?page=1&code=<%= g.getG_code() %>&st=0"><%= g.getG_name() %></a>
                </li>
                <% }%>
            </ul>
        </div>
    </nav>

	<main>
		<div id="book_null">
			<p class="bookinfotitle">
				찾으시는 도서는 없습니다. <br>	
				다른 도서를 검색해 주세요. :)
			</p>
		</div>  
	</main>
	
    <footer>
        <div class="footer_link_area">
            <div>
                <ul class="footer_link">
                    <li>
                        <a class="f_links" href="">회사소개</a>  
                    </li>
                    <li class="f_text">|</li>
                    <li>
                        <a class="f_links" href="">이용약관</a>
                    </li>
                    <li class="f_text">|</li>
                    <li>
                        <a class="f_links" href="">개인정보이용방침</a>
                    </li>
                    <li class="f_text">|</li>
                    <li>
                        <a class="f_links" href="">고객센터</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="footer_info">
            <p class="footer_text">
                ㈜ 북링크 BookLink  |  서울시 마포구 양화로 122 <br>
                대표전화 : 02-1234-5678 &nbsp; 사업자 등록번호 : 12347-58712-596 <br>
                <span>COPYRIGHT(C) BOOKLINK ALL RIGHTS RESERVED.</span> 
            </p>
        </div>
    </footer>
</body>
</html>