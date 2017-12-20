<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>Customer Information</center>
	<table border="1" width="600" align="center">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>orders</td>
		</tr>
		<s:iterator value="userInfo" var="l">
			<tr>
				<td><s:property value="#l.cid"/></td>
				<td><s:property value="#l.cname"/></td>
				<td>
					<button>delete</button>|
					<button>detail</button>
				</td>
			</tr>
		</s:iterator>
		
	</table>
</body>
</html>