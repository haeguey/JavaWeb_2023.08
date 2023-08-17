<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Expression Language (EL)</title>
	<style>td, th {padding: 3px;}</style>
</head>
<body style="margin: 40px;">
	<h1>Plain Old Java Object (POJO)</h1>
	<hr>
		<table border="1">
			<tr><th>표현식</th><th>결과</th></tr>
			<tr><td>\${mem1.id}</td><td>${mem1.id}</td></tr>
			<tr><td>\${mem1.name}</td><td>${mem1.name}</td></tr>
			<tr><td>\${mem1.addr}</td><td>${mem1.addr}</td></tr>
			<tr><td>\${mem2.id}</td><td>${mem2.id}</td></tr>
			<tr><td>\${mem2.name}</td><td>${mem2.name}</td></tr>
			<tr><td>\${mem2.addr.city}</td><td>${mem2.addr.city}</td></tr>
			<tr><td></td><td></td></tr>
			<tr><td>\${memberArray[0].id}</td><td>${memberArray[0].id}</td></tr>
			<tr><td>\${memberArray[0].name}</td><td>${memberArray[0].name}</td></tr>
			<tr><td>\${memberArray[0].addr}</td><td>${memberArray[0].addr}</td></tr>
			<tr><td></td><td></td></tr>
			<tr><td>\${memberArray[1].id}</td><td>${memberArray[1].id}</td></tr>
			<tr><td>\${memberArray[1].name}</td><td>${memberArray[1].name}</td></tr>
			<tr><td>\${memberArray[1].addr.city}</td><td>${memberArray[1].addr.city}</td></tr>
		</table>
</body>
</html>