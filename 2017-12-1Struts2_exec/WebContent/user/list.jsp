<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "${pageContext.request.contextPath}/user/add.jsp";
			}
		</script>
	</HEAD>
	<body>
		<s:debug/>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>User information</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										Username:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<input type="text" name="userName" size="15" value="" id="Form1_userName" class="bg"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										Sex:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										
										<select name="sex" id="sex">
										    <option value="">--Please select a sex--</option>
										    <option value="male">male</option>
										    <option value="female">female</option>
										
										
										</select>

									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										Education：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										
										<select name="education" id="education">
										    <option value="">--Please select the education level--</option>
										    <option value="phd">phd</option>
										    <option value="master">master</option>
										    <option value="undergraduate">undergraduate</option>
										    <option value="college">college</option>
										    <option value="highschool">high school</option>
										
										
										</select>

									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										resume upload
									</td>
									<td class="ta_01" bgColor="#ffffff">
										
										<select name="isUpload" id="isUpload">
										    <option value="">--Please select--</option>
										    <option value="1">yes</option>
										    <option value="2">no</option>
										
										
										</select>

									</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font  color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" name="search" value="Search" class="button_view">
Search
</button>

										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" name="reset" value="Reset" class="button_view"/>

									</td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>User list</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="Add" class="button_add" onclick="addUser()">
Add
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										Login Name
									</td>
									<td align="center" width="17%">
										Username
									</td>
									<td align="center" width="8%">
										Sex
									</td>
									<td align="center" width="23%">
										Phone number
									</td>
									<td width="11%" align="center">
										Education
									</td>
									<td width="7%" align="center">
										Modify
									</td>
									<td width="7%" align="center">
										Search
									</td>
									<td width="7%" align="center">
										Delete
									</td>
								</tr>
								
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												admin
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												&#36229;&#32423;&#31649;&#29702;&#21592;
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="23%">
												
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/edit.jsp?userID=15">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/view.jsp?userID=15">
													<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/list.jsp?userID=15">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												caocao
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												&#26361;&#25805;
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												&#22899;
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="23%">
												12312121
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												&#30740;&#31350;&#29983;
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/edit.jsp?userID=15">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/view.jsp?userID=15">
													<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/user/list.jsp?userID=15">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

