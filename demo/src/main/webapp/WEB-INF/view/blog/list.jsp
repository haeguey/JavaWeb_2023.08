<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/header.jspf" %>
	<style>
        th, td { text-align: center;}
    </style>
</head>
<body>
	<%@ include file="./common/top.jspf" %>
	
    <div class="container" style="margin-top:80px">
        <div class="row">
        	<!-- ============== aside.jspf를 삽입 ============== -->
            <%@ include file="./common/aside.jspf" %>
            <!-- ==================== Main ==================== -->
			<div class="col-9">
            	<h3>
            		<strong>List of My Blog</strong>
            		<span style="font-size: 0.6em;">
            			<a href="/demo/blog/write">
            				<i class="ms-5 fa-regular fa-file-lines"></i> Write
            			</a>
            		</span>
            	</h3>
                <hr>
				<table class="table">
					<tr class="table-secondary">
						<th style="width: 8%;">ID</th>
						<th style="width: 14%;">Writer</th>
						<th style="width: 48%;">Title</th>
						<th style="width: 20%;">Written on</th>
						<th style="width: 10%;">Visitors</th>
					</tr>
					<c:forEach var="blog" items="${blogList}">
						<tr>
							<td>${blog.blogId}</td>
							<td>${blog.penName}</td>
							<td><a href="/demo/blog/detail/${blog.blogId}">${blog.title}</a></td> <%-- 제목에 링크를 걸어 detail.jsp 페이지로 이동 --%>
							<%-- <td>${blog.modTime}</td> --%>
							<td>${fn:replace(fn:substring(blog.modTime, 2, 16), 'T', ' ')}</td>
							<td>${blog.viewCount}</td>
							
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