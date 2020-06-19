<%@ page contentType="text/html; charset=UTF-8"  language="java"%>
<html>
<head>
    <title>Open</title>
    <link href="/css/style.css" rel="stylesheet" />

</head>
<body>
    <header>
            <div class="title">
                ${post.title}
            </div>


    </header>

    <section>
        <div class="date">
            ${post.day}
        </div>
        <div class="about">
            ${post.content}
        </div>

    </section>

    <footer>
        ${post.writer}

    </footer>

</body>
</html>