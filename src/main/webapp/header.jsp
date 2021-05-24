<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
  <a href="movies" class="logo"><img src="image/favicon.png" class="favicon"></a>
  <div class="slogan">Movies Management Website</div>
  <div class="header-right">
    <!-- <%-- For checking when to show in/out. --%> -->
    <core:set var="isValidUser" value="${param.isValidUser}"/>

    <!-- <%-- For checking when to show in/out. --%> -->
    <core:choose>
      <core:when test="${isValidUser}">
        <a onclick="location.href='logout.do'" class="active">Logout</a>
      </core:when>
      <core:otherwise>
        <a onclick="location.href='login.do'" class="active">Login</a>
      </core:otherwise>
    </core:choose>
  </div>
</div>