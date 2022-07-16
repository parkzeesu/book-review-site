<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("n_id");

	session.setAttribute("n_id", id);

	response.sendRedirect("http://localhost:8090/p3/mainbooklist");
%>
</body>
</html>