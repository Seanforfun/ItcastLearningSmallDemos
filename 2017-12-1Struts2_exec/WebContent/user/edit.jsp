<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	<body>
		<s:form id="userAction_save_do" name="Form1" namespace="/" action="User_edit" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<s:hidden name="userID" value="%{model.userID}" id="userID"/>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>Edit user</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<s:actionerror/>
					<s:fielderror />
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						Login name:
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="loginName" value="%{model.loginName}" id="userAction_save_do_logonName" cssClass="bg" />
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 Password:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:password name="loginPwd" value="%{model.loginPwd}" id="logonPwd" disabled="false"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Username:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="username" value="%{model.username}" id="userAction_save_do_userName" cssClass="bg"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Sex:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:radio list="{'male','female'}" name="sex" value="%{model.sex}"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Education:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select list="{'Phd', 'Master', 'Undergraduate','College','HighSchool'}" value="%{model.education}" name="education" id="education"  headerKey="" headerValue="----Please select education----"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Date of birth
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="birthday" size="20" value="%{model.birthday}" readonly="readonly" id="birthday"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Telephone:
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="telephone" value="%{model.telephone}" id="telephone"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Hobbies:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:checkboxlist list="{'Watch movie','Tourism','Workout','Shopping','Sleeping'}" value="%{model.interest}" name="interest"/> 
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						Resume:
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:file name="upload" size="30" value="" id="userAction_save_do_upload"/>
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						Remark:
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="remark" cols="30" rows="3" id="userAction_save_do_remark" style="WIDTH: 96%" value="%{model.remark}"/>
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<s:submit id="userAction_save_do_submit" name="submit" value="Submit" cssClass="button_ok"/>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">Reset</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="Return"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>




	</body>
</HTML>