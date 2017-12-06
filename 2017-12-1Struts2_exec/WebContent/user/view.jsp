<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function downloadFile(userID, filename){
				location.href="{$pageContext.request.contextPath}/User_download?userID=" + userID + "&filename="+filename;
			};
		</script>
	</HEAD>
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/user/userAction_save.do" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>User Information</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Loginname:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="#info.loginName"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Username:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="#info.username"/>
					</td>
				</tr>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Sex:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="#info.sex"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Education:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="#info.education"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Date of birth:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="#info.birthday"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Telephone:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:property value="#info.telephone"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Hobbies:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="#info.interest"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Resume:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<a href="javascript:void(0)"  onclick="downloadFile('<s:property value="#info.userID"/>','<s:property value="#info.filename"/>')" class="cl_01" >
						    <s:property value="#info.filename"/>
						</a>
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						Remark:
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:property value="#info.remark"/>
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<TR>
					<td class="ta_01" style="WIDTH: 100%" align="right" bgColor="#f5fafe" colSpan="4">
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="return"/>
						<span id="Label1"></span>
					</td>
				</TR>
			</table>
		</form>
	</body>
</HTML>