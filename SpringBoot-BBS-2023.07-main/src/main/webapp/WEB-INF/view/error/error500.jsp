<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div class="container-fluid">
            <a href="/sbbs/board/list?p=1&f=&q=">
            	<img src="/sbbs/img/ck-logo.png" alt="Logo" style="height:60px;" class="rounded-3 mx-2">
            </a>
            <div class="p-2 bg-dark justify-content-center rounded">
                <img src="https://picsum.photos/1500/200" width="100%">
            </div>
        </div>
    </nav>
    <div class="container" style="margin-top: 300px;">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <h3>
                    <strong>에러 페이지</strong>
                </h3>
                <hr>
                <h1>죄송합니다.</h1>
                <h1>서비스 실행중 오류가 발생하였습니다.</h1>
                <h1>잠시후 다시 시도해 보세요.</h1>
                <h3>${code}</h3>
                <h3>${msg}</h3>
                <h3>${timestamp}</h3>
            </div>
            <div class="col-3"></div>
        </div>
    </div>

	<%@ include file="../common/bottom.jspf" %>
</body>
</html>