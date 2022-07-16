<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.ArrayList" %>
    <%@ page import ="main.Genre" %>
    <%@ page import ="main.Book" %>
    <%@ page import ="main.Review" %>
    <%@ page import ="main.MainDao" %>
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

	function createreview() {
		
		let user = '<%=(String)session.getAttribute("n_id")%>';
	    
		// 한줄평 id 태그 불러오기
	    let reviewcontent = document.getElementById("reviewcontent");
	    
	    // 도서코드 id 불러오기
	    let bookcode = document.getElementById("bookcode");
	    let bcode = bookcode.value;
	    // alert(bcode);

	    // 날짜 넣기
	    let date1 = new Date();
	    let y = date1.getFullYear() + ".";
	    let m = date1.getMonth() + 1 + ".";
	    let d = date1.getDate();
	    
	    if(reviewcontent.value==""){
	        alert("한줄평을 입력해주세요!");
	        reviewcontent.focus();
	    } else if (user == "null") {
	    	alert("로그인이 필요한 서비스입니다.");
	    	window.location.href="/p3/jsp/login/로그인.jsp";
	    }else{
	        alert("한줄평이 등록되었습니다.");
	        
	        // 한줄평
	        let review = reviewcontent.value;
	        
	        // date
	        let date = y+m+d;
	        
	        //alert(bcode);
	        //alert(user);
	        //alert(review);
	        //alert(date);
	    
	        window.location.href="reviewInsert?id="+user+"&bcode="+bcode+"&content="+review+"&date="+date;
	        //window.location.href="reviewInsert?num="+rNum.innerHTML+"&id="+user.innerHTML+"&bcode="+bcode+"&content="+reviewcontent.value+"&date="+date.innerHTML;

	    }  
	}
	
	function deleteReview(r_num){
		let dr = confirm("삭제하시겠습니까?"); // true, false
		
		let bookcode = document.getElementById("bookcode");
	    let bcode = bookcode.value;
        
        if(dr){
            alert("삭제했습니다.");
            //alert(r_num);
            window.location.href="reviewdelete?bcode="+bcode+"&r_num="+r_num;
        }else{
            alert("취소했습니다.");
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

    <aside id="left-sidebar">
    
    	<% Book b = (Book)request.getAttribute("book"); %>
        <img id="bookimg" src="<%= b.getImg() %>" alt="">
        
		<input type="hidden" id="bookcode" value="<%= b.getB_code() %>">
		
        <section id="contents">
            <h3 class="bookinfotitle"> 도서정보 </h3>
            <form>
                <table class="selectbookinfo">
        			
                    <tr class="selectbookinfotd">
                        <td class="bookinfotd">도서명</td>
                        <td ><%= b.getB_name() %></td>
                    </tr>

                    <tr class="selectbookinfotd">
                        <td class="bookinfotd">저자</td>
                        <td ><%= b.getAuthor() %></td>
                    </tr>

                    <tr class="selectbookinfotd">
                        <td class="bookinfotd">출판사</td>
                        <td ><%= b.getPublisher() %></td>
                    </tr>

                    <tr class="selectbookinfotd">
                        <td class="bookinfotd">출판일</td>
                        <td ><%= b.getPublication_date() %></td>
                    </tr>

                    <tr class="selectbookinfotd">
                        <td colspan="2"> 줄거리</td>
                    </tr>

                    <tr>
                        <td colspan="2" class="selectbookinfotd2">
                    	<%= b.getB_summary() %>
                        </td>
                    </tr>
                </table>
            </form>
        </section>
    </aside>    

    <section id= "container2">
        <span>한줄평 등록 &nbsp;</span>
         <input type = "text" id="reviewcontent" placeholder="한줄평을 입력해주세요." name="content">
    
         <button id="btn" onclick="createreview();">등록</button>
   </section>
   
   <div>
   		
       <ul id="wrap">
       <hr>
       <% ArrayList<Review> Rlist = (ArrayList<Review>)request.getAttribute("Rlist"); 
       
          HttpSession sesssion  = request.getSession();
          String  id2  =(String) session.getAttribute("id");
          
          for(int i=0; i<Rlist.size(); i++){
        	  Review r = (Review)Rlist.get(i);
       %>
       		<li>
       			<p><%= r.getN_id() %></p>
       			<p><%= r.getContent() %></p>
       			<p><%= r.getR_date() %></p>
       			
       			<% if( r.getN_id().equals(id2) )  {%>
       			<button id="<%= r.getR_num() %>" onclick="deleteReview(this.id);" >X</button>
       			<%} %>       			
       		</li>
       		<hr>
       <% } %>
       
       </ul>
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