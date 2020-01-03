<%--
  Created by IntelliJ IDEA.
  User: Tian-jiaojiao
  Date: 2019/12/25
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form>
        <table border="1s">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            <%--<c:forEach items="${user}" var="i">
            <tr>
                <td><input type="text" name="${i.userId}"/></td>
                <td><input type="text" name="${i.userName}"/></td>
                <td><input type="text" name="${i.password}"/></td>
            </tr>
            </c:forEach>--%>
        </table>
    </form>
</body>
</html>
