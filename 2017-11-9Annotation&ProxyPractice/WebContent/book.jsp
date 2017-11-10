<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	current user: ${user.username }<br>
	<a href="${pageContext.request.contextPath }/book?method=add">book add</a><br>
	<a href="${pageContext.request.contextPath }/book?method=update">book update</a><br>
	<a href="${pageContext.request.contextPath }/book?method=delete">book delete</a><br>
	<a href="${pageContext.request.contextPath }/book?method=search">book search</a>
</body>
</html>