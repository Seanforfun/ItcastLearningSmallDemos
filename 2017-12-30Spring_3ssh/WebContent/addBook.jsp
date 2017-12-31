<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<h1>Add Book</h1>
	<s:form action="Book_add" namespace="/" method="post" theme="simple">
		name :<s:textfield name="name"/><br/>
		price  :<s:textfield name="price"/><br/>
		<s:submit/>
	</s:form>
</body>
</html>