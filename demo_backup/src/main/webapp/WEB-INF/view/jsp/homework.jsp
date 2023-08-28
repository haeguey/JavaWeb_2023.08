<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/header.jspf" %>
	<style>td, th { text-align: center; }</style>
</head>
<body>
	<%@ include file="./common/top.jspf" %>

    <div class="container" style="margin-top:80px">
        <div class="row">
        
        	<!-- ============== aside.jspf를 삽입 ============== -->
            <%@ include file="./common/aside.jspf" %>
            
            <!-- ================ Main section of homework ================ -->
            <div class="col-9">
            	<h3><strong>Member List</strong></h3>
            	<hr>
            	<div class="row">
            		<div class="col-1"></div>
            		<div class="col-10">
            			<table class="table table-striped">
            				<tr>
            					<th>번호</th>
            					<th>아이디</th>
            					<th>이름</th>
            					<th>Zip Code</th>
            					<th>도시</th>
            					<th>국가</th>
            				</tr>
            			<c:forEach var="member" items="${memberList}" varStatus="loop">
            				<tr>
								<td>${loop.count}</td>
								<td>${member.id}</td>
								<td>${member.name}</td>
								<td>${member.addr.zipCode}</td>
								<td>${member.addr.city}</td>
								<td>${member.addr.country}</td>
	            			</tr>
	            		</c:forEach>
            			</table>
            		</div>
            		<div class="col-1"></div>
            	</div>
            </div>
            <!-- ================ Main section of homework ================ -->
		</div>
	</div>

		<%@ include file="./common/bottom.jspf" %>
</body>
</html>