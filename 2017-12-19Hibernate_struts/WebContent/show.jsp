<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function createXMLHttpRequest() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;
	}
	
	function customerDetail(cid) {
		var btn = document.getElementById("btn" + cid);
		var tbl = document.getElementById("tbl" + cid);
		if(btn.value == "detail"){
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.onreadystatechange = function() {
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					var resp = xmlHttp.responseText;
					var jsondata = eval("("+resp+")");
					for(var i = 0; i < jsondata.length; i++){
						tbl.innerHTML += "<tr><td>"+jsondata[i].oid+"</td><td>"+jsondata[i].address+"</td></tr>";
					}
				}
			}
			
			xmlHttp.open("GET", "${pageContext.request.contextPath}/order_getOrdersById?cid="+cid +"&time=" + new Date().getTime(), true);
			xmlHttp.send(null);
			btn.value = "close";
		}else{
			btn.value = "detail";
			tbl.innerHTML = "";
		}
	}
</script>
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
					<a href="${pageContext.request.contextPath }/customer_delete?cid=<s:property value="#l.cid"/>">delete</a>
					|
					<input id="btn<s:property value="#l.cid"/>"type="button" value="detail" onclick="customerDetail(<s:property value="#l.cid"/>)">
					<table id="tbl<s:property value="#l.cid"/>"></table>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>