<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<s:fielderror/>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>username:</td>
				<td>
					<input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td>password:</td>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="login">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>