<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NEW_DIARY</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
            crossorigin="anonymous"
    />
    <link href="/css/updataStyle.css" rel="stylesheet" />
</head>
<body>
<form class="form-horizontal">
    <div class="form-group">
        <div id="titleText">Title</div>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="inputEmail3" placeholder="title">
        </div>
    </div>
    <div class="form-group">
        <div id="contentText">내용</div>
        <textarea class="form-control" rows="5"></textarea>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>
</body>
</html>
