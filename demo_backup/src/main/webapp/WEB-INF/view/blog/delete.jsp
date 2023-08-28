<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/header.jspf" %>
	<style>
        th, td { text-align: center; }
	</style>
</head>
<body>
	<%@ include file="./common/top.jspf" %>
	
    <div class="container" style="margin-top: 80px;">
        <div class="row">
        	<%@ include file="./common/aside.jspf" %>
        	<!-- ======================== main ======================== -->
			<div class="col-sm-9">
        		<h3><strong>Delete Blog</strong></h3>
        		<hr>
        		<div class="row">
        			<div class="col-3"></div>	<%-- 왼쪽에서 3칸 --%>
        			<div class="col-6">
        				<div class="card border-warning">
        					<div class="card-body">
        						<strong class="card-title">Do you really want to delete this blog?</strong>
        						<br>
        						<p class="card-text text-center mt-4">
        							<button class="btn btn-primary" onclick="location.href='/demo/blog/deleteConfirm/${blogId}'">Delete</button>
        							<button class="btn btn-secondary" onclick="location.href='/demo/blog/detail/${blogId}?option=DNI'">Cancel</button>
        						</p>
        					</div>
        				</div>
        			</div>
        			<div class="col-3"></div>
        		</div>
        	</div>
        </div>
	</div>
	
	<%@ include file="./common/bottom.jspf" %>
</body>
</html>