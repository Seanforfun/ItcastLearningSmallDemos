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
		<br>
		<s:debug/>
		<s:form id="Form1" name="Form1" action="User_search" method="post" namespace="/">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>User information</strong>
						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<s:fielderror/>
							<s:actionerror/>
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
										<s:textfield name="username" size="15" value="" id="Form1_userName" cssClass="bg"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										Sex:
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'male','female'}" id="sex" name="sex" headerKey="" headerValue="--Please select a sex--"/>
									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										Education：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'phd','master','undergraduate','college','highschool'}" name="education" id="education" headerKey="" headerValue="--Please select the education level--"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										resume upload
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select list="{'yes','no'}" name="isUpload" value="isUpload" headerKey="" headerValue="--Please select--"/>
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
										<s:submit  id="search" name="search" value="Search" cssClass="button_view"/>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:reset name="reset" value="Reset" cssClass="button_view"/>
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
								<s:iterator value="%{list}" var="u">
									</tr>
											<tr onmouseover="this.style.backgroundColor = 'white'"
												onmouseout="this.style.backgroundColor = '#F5FAFE';">
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="18%">
													<s:property value="#u.loginName"/>
												</td>
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="17%">
													<s:property value="#u.username"/>
												</td>
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="8%">
													<s:property value="#u.sex"/>
												</td>
												<td style="CURSOR: hand; HEIGHT: 22px" align="center"
													width="23%">
													<s:property value="#u.telephone"/>
												</td>
												<td style="CURSOR: hand; HEIGHT: 22px" align="center">
													<s:property value="#u.education"/>
												</td>
												<td align="center" style="HEIGHT: 22px">
													<s:a namespace="/" action="User_editShow">
														<s:param name="userID" value="%{#u.userID}"/>
														<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
													</s:a>
												</td>
												<td align="center" style="HEIGHT: 22px">
													<s:a namespace="/" action="User_findUserById">
														<s:param name="userID" value="%{#u.userID}"/>
														<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
													</s:a>
												</td>
												<td align="center" style="HEIGHT: 22px">
													<s:a namespace="/" action="User_delete">
														<s:param name="userID" value="%{#u.userID}"/>
														<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
													</s:a>
												</td>
											</tr>
										</s:iterator>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

