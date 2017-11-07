<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table>
	<tr>
		<td>Product id</td>
		<td>Product name</td>
		<td>Product price</td>
	</tr>
	<c:forEach var="p" items="${products }">
		<tr>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>${p.price }</td>
		</tr>
	</c:forEach>
<table>
