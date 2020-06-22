<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<html>
<head>
    <title>Open</title>
    <link href="/css/style.css?after" type="text/css" rel="stylesheet" />

    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
            crossorigin="anonymous"
    />

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
          <button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='http://localhost:8080/upload'">NEW DIARY SUBMIT</button>
       </div>

    </footer>

</body>
</html>