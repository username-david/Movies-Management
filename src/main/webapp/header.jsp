<!DOCTYPE html>
<html xmlns:width="http://www.w3.org/1999/xhtml" xmlns:hight="http://www.w3.org/1999/xhtml">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/header.css">
</head>
<body>

<div class="header">
    <a href="#default" class="logo"><img src="image/favicon.png" class="favicon"></a>
    <div class="slogan">Movies Management Website</div>
    <div class="header-right">
        <core:set var="req" value="${pageContext.request}"/>
        <core:set var="isValidUser" value="${req.isUserInRole('Admin') || req.isUserInRole('Member')}"/>

        <!-- <%-- Title and log in/out button. --%> -->
        <a onclick="location.href='login.do'" class="active">

            <!-- <%-- For checking when to show in/out. --%> -->
            <core:choose>
                <core:when test="${isValidUser}">Logout</core:when>
                <core:otherwise>Login</core:otherwise>
            </core:choose>
        </a>
    </div>
</div>
</body>
</html>
