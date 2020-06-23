<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>NEW_DIARY</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
            crossorigin="anonymous"
    />
    <link href="/css/updataStyle.css?after" rel="stylesheet" />
</head>
<body>
<div id="title"> 새로운 일기를 작성해봐요! </div>
<form class="form-horizontal" action="/update" method="post"  accept-charset="utf-8">
    <div class="form-group">
        <div class="titleText">Title</div>
            <input type="text" name = "title" class="form-control" placeholder="제목" value="${post.title}">
            <div class="blank"></div>
            <div class="NameText">Name & DAY</div>
            <div class="form-inline">
                <div class="name_day">
                    <input type="text" name="writer" class="form-control" placeholder="이름" value="${post.writer}"></div>
                <div class="name_day">
                    <input type="date" name="day" class="form-control" placeholder="날짜" value="${post.day}"></div>
            </div>
    <div class="blank"></div>

    <div class="form-group">
        <div id="contentText">CONTENT</div>
        <input type="text" name="content" class="form-control" placeholder="일기내용" value="${post.content}" aria-rowspan="5">
    </div>
    <div class="form-group">
            <div id="btn">
            <button type="submit" class="btn btn-info">등록</button>
            </div>
    </div>
    </div>
</form>
</body>
</html>
