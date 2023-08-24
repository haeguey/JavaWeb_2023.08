<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/header.jspf" %>
	<style>
        th { text-align: center; width: 2%; background-color: dimgray; height: 50px; }
        td { height: 50px; text-align: center; }
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
            	<h3><strong>샘플</strong></h3>
                <hr>
			<!-- ==================== Main ==================== -->
        </div>
    </div>	
	<%@ include file="./common/bottom.jspf" %>
</body>
</html>