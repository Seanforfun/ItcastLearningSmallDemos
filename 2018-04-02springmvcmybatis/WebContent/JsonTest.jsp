<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>responseJson</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function requestJson(){		
		$.ajax({
			url:"${pageContext.request.contextPath}/requestJson.action",
			type:"post",
			contentType:"application/json;charset=utf-8",
			data:'{"id":"1", "name":"test","price":"112.3","pic":"ssfsdfsdfsdf"}',
			success:function(data){
				alert(data.name);
			} 
		});
	}
	
	function responseJson(){
		$.ajax({
			url:"${pageContext.request.contextPath}/responseJson.action",
			type:"post",
//			contentType:"application/json;charset=utf-8",
			data:'id=1&name=test&price=112.3&pic=ssfsdfsdfsdf',
			success:function(data){
				alert(data.name);
			} 
		});
		
	}
	
</script>
</head>
<body>
	<input type="button" value="请求Json响应Json" onclick="requestJson()">
	<input type="button" value="请求KV响应Json" onclick="responseJson()">
</body>
</html>