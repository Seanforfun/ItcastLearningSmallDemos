<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	welcome! ${sessionScope.user.username }<br>
	<a href="${pageContext.request.contextPath }/Book_add">add book</a><br>
	<a href="${pageContext.request.contextPath }/Book_research">research book</a><br>
	<a href="${pageContext.request.contextPath }/Book_update">update book</a><br>
	<a href="${pageContext.request.contextPath }/Book_delete">delete book</a><br>
</body>
</html>