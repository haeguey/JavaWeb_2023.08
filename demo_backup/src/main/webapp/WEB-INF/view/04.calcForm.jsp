<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
</head>
<body style="margin: 50px;">
	<h3>Simple calculator</h3>
	<hr>
	<!-- <form action="/demo/calc" method="post">  -->
	<form method="get" action="/demo/getParam">
		<input type="text" name="a" placeholder="Enter an integer for a">
		<select name="op">
			<option value="add" selected>+</option>
		    <option value="sub">-</option>
		    <option value="mul">*</option>
		    <option value="div">/</option>
		</select>
		<input type="text" name="b" placeholder="Enter an integer for b">
		<input type="submit" value="=">
	</form>

</body>
</html>