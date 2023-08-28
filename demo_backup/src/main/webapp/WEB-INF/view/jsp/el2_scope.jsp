<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "페이지 스코프");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Expression Language (EL)</title>
	<style>td, th {padding: 3px;}</style>
</head>
<body style="margin: 40px;">
	<h1>Scope(객체 범위)</h1>
	<hr>
	<table border="1">
		<tr><th>표현식</th><th>결과</th></tr>
		<tr><td>\${sessionScope.sName}</td><td>${sessionScope.sName}</td></tr>
		<tr><td>\${requestScope.mName}</td><td>${requestScope.mName}</td></tr>
		<tr><td>\${sName}</td><td>${sName}</td></tr>
		<tr><td>\${mName}</td><td>${mName}</td></tr>
		<tr><th></th><th></th></tr>
		<tr><td>\${sessionScope.name}</td><td>${sessionScope.name}</td></tr>
		<tr><td>\${requestScope.name}</td><td>${requestScope.name}</td></tr>
		<tr><td>\${pageScope.name}</td><td>${pageScope.name}</td></tr>		<!-- 현실은 이렇게 안씀 -->
		<tr><td>\${name}</td><td>${name}</td></tr>
		<tr><th>내장 객체</th><th>결과</th></tr>
		<tr><td>\${cookie.JSESSIONID.name}</td><td>${cookie.JSESSIONID.name}</td></tr>
		<tr><td>\${cookie.JSESSIONID.value}</td><td>${cookie.JSESSIONID.value}</td></tr>		
	</table>
</body>
</html>