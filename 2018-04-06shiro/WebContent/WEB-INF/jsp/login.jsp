<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function login(){
		var usercode = $("input[name='usercode']").val();
		var password = $("input[name='password']").val();
		var url = $("form").attr("action") + usercode + "/" + password;
		if(usercode == "" || password == ""){
			return;
		}
		/* else{
			$.ajax({
				url:url
			});
		} */
		$("form").attr("action",url);
		$("form").submit();
	}
</script>
<title>login page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/" method="post">
		<table>
			<tr>
				<td>usercode: <input type="text" name="usercode"></td>
			</tr>
			<tr>
				<td>password: <input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="button" onclick="login()" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>