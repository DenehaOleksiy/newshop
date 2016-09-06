<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 05.09.2016
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<nav>
    <tiles:insertAttribute name="menu"/>
</nav>
<section>
    <tiles:insertAttribute name="body"/>
</section>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
