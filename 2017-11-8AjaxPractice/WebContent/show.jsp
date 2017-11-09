<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<select id="p" onchange="fillCity()">
		<option>----Please select a province----</option>
	</select><br>
	<select id="c">
		<option>----Please select a city----</option>
	</select>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/JsUtils.js"></script>
<script type="text/javascript">
	var provinces;
	window.onload = function(){
		var xmlHttp = getMyXmlHttpRequest();
		
		if(null != xmlHttp)
		{
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
				{
					provinces = xmlHttp.responseXML;
					var p = provinces.getElementsByTagName("provinces");
					var select = document.getElementById("p");
					for(var i = 0; i < p.length; i++)
					{
						var nameProvince = p[i].getElementsByTagName("name")[0];
						var pName = nameProvince.innerHTML;
						var option = document.createElement("option");
						option.text = pName;
						select.add(option);
					}
				}
			}
		}
		
		xmlHttp.open("POST","${pageContext.request.contextPath}/province");
		xmlHttp.send(null);
	}
	
	function fillCity(){
		var selectP = document.getElementById("p");
		var selectC = document.getElementById("c");
		
		var pName = selectP.options[selectP.selectedIndex].text;
		var p = provinces.getElementsByTagName("provinces");
		
		for(var i = 0; i < p.length; i++)
		{
			var pName1 = p[i].getElementsByTagName("name")[0].innerHTML;
			
			if(pName1 == pName)
			{
				var cities = p[i].getElementsByTagName("Cities");
				for(var j = 0; j < cities.length; j++)
				{
					var cname = cities[j].getElementsByTagName("name")[0].innerHTML;
					var option = document.createElement("option");
					option.text = cname;
					c.add(option);
				}
			}
		}
	}
</script>
</html>