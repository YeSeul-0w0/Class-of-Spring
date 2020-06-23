<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<html>
<head>
    <title>Open</title>
    <link href="/css/style.css?after" type="text/css" rel="stylesheet" />

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

    </section>

    <footer>
       <div class="btn">
          <button type="button" class=btn2 onclick="location.href='http://localhost:8080/upload'">NEW DIARY SUBMIT</button>
       </div>

    </footer>

</body>
</html>