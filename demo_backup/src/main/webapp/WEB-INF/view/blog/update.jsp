<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/header.jspf" %>
	<style>
        th, td { text-align: right;}
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
            	<h3><strong>Edit</strong></h3>
                <hr>
                <div class="row">
                	<div class="col-1"></div>
                	<div class="col-10">
                		<form action="/demo/blog/update" method="post">
							<input type="hidden" name="blogId" value="${blog.blogId}">
								<table class="table table-borderless">
	                			<tr>
	                				<td style="width: 10%;"><label class="col-form-label">Name</label></td>
	                				<td style="width: 90%;"><input class="form-control" type="text" name="penName" value="${blog.penName}"></td>
	                			</tr>
	                			<tr>
	                				<td><label class="col-form-label">Title</label></td>
	                				<td><input class="form-control" type="text" name="title" value="${blog.title}"></td>
	                			</tr>
	                			<tr>
	                				<td><label class="col-form-label">Content</label></td>
	                				<td><textarea class="form-control" rows="10" name="content">${blog.content}</textarea></td>
	                			</tr>
	                			<tr>
	                				<td colspan="2" style="text-align: center;">
	                					<input class="btn btn-primary" type="submit" value="Submit">
	                					<input class="btn btn-secondary" type="reset" value="Undo">
	                					<input class="btn btn-secondary" onclick="location.href='/demo/blog/detail/${blogId}?option=DNI'" type="reset" value="Cancel">
	                				</td>
	                			</tr>
	                		</table>
						</form>
                 	</div>
               		<div class="col-1"></div>
               	</div>
				<!-- ==================== Main ==================== -->
			</div>
        </div>
    </div>	
	<%@ include file="./common/bottom.jspf" %>
</body>
</html>