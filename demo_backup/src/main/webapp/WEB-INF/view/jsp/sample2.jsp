<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/header.jspf" %>
	<style>
		th { background-color: #dddddd; height: 40px; }
        td { height: 25px; }
        table, th, td { border:1px solid black; border-collapse: collapse; text-align: center; padding: 6px;}
	</style>
		<meta charset="UTF-8">
		<title>JSTL</title>
</head>
<body>
	<%@ include file="./common/top.jspf" %>
	
    <div class="container" style="margin-top:80px">
        <div class="row">
        	<!-- ============== aside.jspf를 삽입 ============== -->
            <%@ include file="./common/aside.jspf" %>

            <!-- ================ Main section of sample2 ================ -->
            <div class="col-9">
			<table style="width:100%; border=1">
				<tr>
					<th>Index</th>
					<th>Count</th>
					<th>아이디</th>
					<th>이름</th>
					<th>주소</th>
				</tr>
				<c:forEach var="member" items="${memberList}" varStatus="loop">			
				<tr>
					<td>${loop.index}</td>
					<td>${loop.count}</td>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.addr}</td>
				</tr>
				</c:forEach>
			</table>
			</div>
			<!-- ==================== Main ==================== -->
        </div>
    </div>	
	<%@ include file="./common/bottom.jspf" %>
</body>
</html>