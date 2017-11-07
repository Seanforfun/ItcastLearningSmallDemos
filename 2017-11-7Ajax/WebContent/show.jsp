<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show products</title>
</head>
<body>
	<a href="javascript:void(0)" id="p">show products information</a>
	<div id="divId"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/my.js"></script>
<script type="text/javascript">
	var p = document.getElementById("p");

	p.onclick = function() {
		var xmlHttp = getXmlHttpResquest();
		if(null != xmlHttp)
		{
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
				{
					var div = document.getElementById("divId");
					div.innerHTML = xmlHttp.responseText;
				}
			}
			
			xmlHttp.open("POST","${pageContext.request.contextPath}/ajax2");
			xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			xmlHttp.send(null);
		}
	}
</script>
</html>