<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 5/18/2021
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie Page</title>
</head>
<body>
<c:forEach var="i" items="1,2,3">
    Items:<c:out value="${i}"/>
</c:forEach>

</body>
</html>
