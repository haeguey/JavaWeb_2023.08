<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("newline", "\n"); %>

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
            		<strong>Detail</strong>
            		<span style="font-size: 0.6em;">
            			<a href="/demo/blog/list">
            				<i class="ms-5 fa-solid fa-list"></i> List
            			</a>
            			<a href="/demo/blog/update/${blog.blogId}">
            				<i class="ms-3 fa-regular fa-pen-to-square"></i> Edit
            			</a>
            			<a href="/demo/blog/delete/${blog.blogId}">
            				<i class="ms-3 fa-solid fa-trash-can"></i> Delete
            			</a>
            		</span>
           		</h3>
                <hr>
                <div class="row">
                	<div class="col-8">
                		<h5>${blog.title}</h5>
                		<h6>ID: ${blog.blogId} | ${fn:replace(blog.modTime, 'T', ' ')}</h6>
                	</div>
                	<div class="col-4 text-end">
                		<h5>${blog.penName}</h5>
                		<h6>Views ${blog.viewCount}</h6>
                	</div>
               	</div>
               	<hr>
               	<div class="row">
               		<div class="col-1"></div>
					<div class="col-10">
						${fn:replace(blog.content, newline, '<br>')}
					</div>
					<div class="col-1"></div>               	
               	</div>
			</div>
			<!-- ==================== Main ==================== -->
        </div>
    </div>	
	<%@ include file="./common/bottom.jspf" %>
</body>
</html>