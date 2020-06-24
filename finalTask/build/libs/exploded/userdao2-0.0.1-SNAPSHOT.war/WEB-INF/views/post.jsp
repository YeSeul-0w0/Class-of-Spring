<%@ page import="kr.ac.jejunu.user.DTO.Post" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Open</title>
    <link href="/css/style.css?after" type="text/css" rel="stylesheet"/>

</head>
<body>
<header>
    <div class="title">
        ${post.title}
    </div>


</header>

<section>
    <div class="date_writer">
        <div class="date">
            날짜 : ${post.day}
        </div>
        <div class="writer">
            작성자 : ${post.writer}
        </div>
    </div>
    <div class="about">
        ${post.content}

    </div>
    <div class="btn">
        <button type="button" class="modify_delete" value="id"  onclick="location.href='http://localhost:8080/modify?id=${post.id}'"/>MODIFY</button>
        <button type="button" class="modify_delete" value="id">DELETE</button>
    </div>
</section>

<footer>
    <div class="btn">
        <%
            Post post = (Post) request.getAttribute("post");
            int prev = post.getId()-1;
            if (prev <= 0) {
                prev=1;
            }
        %>
        <button type="button" class=btn2 value="id"
                onclick="location.href='http://localhost:8080/post?id=<%= prev %>'">NEXT DIARY
        </button>
        <button type="button" class=btn2 onclick="location.href='http://localhost:8080/upload'">NEW DIARY SUBMIT
        </button>
        <button type="button" class=btn2 value="id"
                onclick="location.href='http://localhost:8080/post?id=${post.id+1}'">NEXT DIARY
        </button>
    </div>

</footer>

</body>
</html>