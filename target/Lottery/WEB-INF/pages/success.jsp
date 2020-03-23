<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23 0023
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
success<br>
<c:forEach var="u" items="${users}" >
    <span>${u.account} : ${u.passWord}</span> <br>
</c:forEach>

</body>
</html>
