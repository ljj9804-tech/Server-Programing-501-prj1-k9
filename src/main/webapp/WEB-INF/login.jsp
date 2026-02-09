<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 6.
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>임시 로그인 화면 </title>
</head>
<body>
<h1>임시 로그인 화면 </h1>
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러입니다.</h1>
</c:if>
<form action="/login_0209" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpw">
    <button type="submit">로그인</button>
</form>

</body>
</html>
