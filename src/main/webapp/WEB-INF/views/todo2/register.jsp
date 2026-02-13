<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 26. 2. 13.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>임시 register 화면</h1>
<form action="/todo2/register" method="post">
    <div>
        Title: <input type="text" name="title" placeholder="todo 제목을 입력해주세요">
    </div>
    <div>
        DueDate: <input type="date" name="dueDate">
    </div>
    <div>
        Writer: <input type="text" name="writer">
    </div>
    <div>
        Finished: <input type="checkbox" name="finished">
    </div>
    <div>
        <button type="reset">초기화</button>
        <button type="submit">등록하기</button>
    </div>
</form>

</body>
</html>
