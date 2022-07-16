<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="main.Book" %>
    <%@ page import ="main.Genre" %>
    <%@ page import ="main.MainDao" %>
    <%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book:Link</title>
<link rel="stylesheet" href="/p3/html/darkmode/toggle_style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/main/GetPageBooks.css">

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
	function showChange(a){
		//alert("call");
	    let ss = document.getElementById("show_select");
	
	    let index = a.selectedIndex;
	    
	    let ovalue = ss.options[index].value;
	    let gcode =  document.getElementById("gcode").value;
	    
	    if(ovalue == "asc"){
	    	window.location.href ="ascgetpagebooks?page=1&code="+ gcode +"&st=1";
	    }else if(ovalue == "desc"){
	    	window.location.href ="descgetpagebooks?page=1&code="+ gcode +"&st=2";
	    }else {
	    	window.location.href ="getpagebooks?page=1&code="+ gcode +"&st=0";
	    }
	}
	
	
	window.addEventListener("load" , function(){
		//alert("djfjfjf");
		let ss = document.getElementById("show_select");
		//alert(ss);
		let st =  document.getElementById("st").value;
		let gcode =  document.getElementById("gcode").value;
		let page =  document.getElementById("page").value;
		//alert(st);
		if( st=="1"){	
			ss.options[1].selected = true;
		}else if( st=="2"){
			ss.options[2].selected = true;
		}else{
			ss.options[0].selected = true;
		}	
	});
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
        <div class="main_top">
        <% Genre g = (Genre)request.getAttribute("genre"); %>
        	<h2 > <%= g.getG_name() %> </h2>
        	<input type="hidden"  id="gcode"  value=<%=request.getParameter("code") %> >
        	
            <select id="show_select" onchange="showChange(this);">
                <option value="basic">전체보기</option>
                <option value="asc">오름차순</option>
                <option value="desc">내림차순</option>
            </select>
        </div>
        <% ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list"); 
        	for(Book b : list){
        	//for(int i=0; i<list.size(); i++){
        		//Book b = (Book)list.get(i);
        %>
        <div class="main_select_book_wrap">
            <div class="main_select_book">
                <a href="bookselect?b_code=<%= b.getB_code() %>"><img class="main_select_book_img" src="<%= b.getImg() %>" alt="img"></a>
                <div class="main_select_book_info_wrap">
                    <ul class="main_select_book_info">
                        <li class="bookname"><a href="bookselect?b_code=<%= b.getB_code() %>"><h3><%= b.getB_name() %></h3></a></li>
                        <li class="bookinfo"><%= b.getAuthor() %> 지음 | <%= b.getPublisher() %> | <%= b.getPublication_date() %></li>
                        <li class="bookstory"><%= b.getB_summary() %></li>
                    </ul>
                </div>
            </div>
            <hr class="line">
        </div>
        <%  }%>
        <div class="main_page_btn">
        	<%
        	int st = (Integer)request.getAttribute("st");
        	int code = (Integer)request.getAttribute("code");
        	int currentPage = (Integer)request.getAttribute("page");  // 현재페이지
        	int totalRecords = (Integer)request.getAttribute("totalCnt");   // 총레코드 수 
        	
        	int pageSize = 3;
        	int totalPage = 0;
        	
        	if(totalRecords % pageSize == 0) {
        		totalPage = totalRecords / pageSize;	
        	} else{
        		totalPage = totalRecords / pageSize+1;
        	}
        	
        	int grpSize = 5; // 그룹의 사이즈 결정 [1][2][3][4][5]
        	int currentGrp = 0;
        	
        	if(currentPage % grpSize ==0){
        		currentGrp = currentPage / grpSize;    // 5/5 => 1그룹
        	}else {
        		currentGrp = currentPage / grpSize+1;  // 6/5 => 1+1 2그룹
        	}
        	
			 int grpStartPage = ( currentGrp -1 ) * grpSize +1 ;  // 그룹의 시작번호   현재그룹 1 => 1  , 현재그룹 2 -> 6
			 int grpEndPage = currentGrp * grpSize;               // 그룹의 끝번호    1-> 5  , 2-> 10
			 	 
			 if( grpEndPage > totalPage){
				 grpEndPage = totalPage;    // 그룹의 끝번호   10 -> 9로 변경 , 그룹의 끝번호가 마지막페이지번호 크다면
			 }
			 
			 int index = grpStartPage;
			 
			 if(currentGrp >1){
			%>
			<a href="descgetpagebooks?page=<%= index-1 %>&code=<%=code%>&st=<%= st%>">[이전]</a>
			<%
					}	 
			 while( index <= grpEndPage){
			 
			 %>
				 <a href= "descgetpagebooks?page=<%=index%>&code=<%=code%>&st=<%= st%>">[ <%=index %> ]</a> 
		        <%
				  index ++;
			 }
			 
			 if( index <= totalPage){%>
				  <a href="descgetpagebooks?page=<%=index%>&code=<%=code%>&st=<%= st%>">[다음>]</a>  
			<% } %>
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
                        <a class="f_links" href=""> 이용약관</a>
                    </li>
                    <li class="f_text">|</li>
                    <li>
                        <a class="f_links" href=""> 개인정보이용방침</a>
                    </li>
                    <li class="f_text">|</li>
                    <li>
                        <a class="f_links" href=""> 고객센터</a>
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
    <input type="hidden"  id="st"  value=<%=request.getParameter("st") %> ><input type="hidden"  id="page"  value=<%=request.getParameter("page") %> >
</body>
</html>