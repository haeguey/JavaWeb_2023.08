<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/header.jspf" %>
	<style>
        th, td { text-align: center;}
    </style>
    <script>
    	function search(){
    		let field = document.getElementById('field').value;
    		let query = document.getElementById('query').value;
    		//console.log("search()", field, query);	// 브라우저 console 창에서 실행이 되는지 확인용 
    		location.href='/myProject/blog/list?f=' + field + '&q=' + query;
    	}
    </script>
</head>
<body>
	<%@ include file="../common/top.jspf" %>
	
    <div class="container" style="margin-top:80px">
        <div class="row">
        	<!-- ============== aside.jspf를 삽입 ============== -->
            <%@ include file="../common/aside.jspf" %>
            <!-- ==================== Main ==================== -->
			<div class="col-9">
			<table class="table table-sm table-borderless">
				<tr>
					<td style="width: 52%; text-align: left;">
						<h3>
		            		<strong>List of My Blog</strong>
		            			<span style="font-size: 0.6em;">
			            			<a href="/myProject/blog/write">
			            				<i class="ms-5 fa-regular fa-file-lines"></i> Write
			            			</a>
		            		</span>
	            		</h3>
					</td>
					<td style="width: 15%;">
						<select class="form-select" id="field">
							<option value="title" ${field eq 'title' ? 'selected' : ''}>title</option>
							<option value="content" ${field eq 'content' ? 'selected' : ''}>content</option>
							<option value="penName" ${field eq 'penName' ? 'selected' : ''}>author</option>
						</select>
					</td>
					<td style="width: 25%;">
						<input class="form-control" placeholder="search something..." id="query" value="${query}"
								onkeyup="if(window.event.keyCode==13) search()">
					</td>
					<td style="width: 8%;">
						<button class="btn btn-outline-primary" onclick="search()">Search</button>
					</td>
				</tr>
			</table>

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
							<td><a href="/myProject/blog/detail/${blog.blogId}">${blog.title}</a></td> <%-- 제목에 링크를 걸어 detail.jsp 페이지로 이동 --%>
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
	<%@ include file="../common/bottom.jspf" %>
</body>
</html>