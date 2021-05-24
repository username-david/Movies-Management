<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/movieCard.css">

<table>
  <core:set var="id" value="${param.id}"/>
  <core:set var="name" value="${param.name}"/>
  <core:set var="image" value="${param.image}"/>
  <core:set var="rating" value="${param.rating}"/>
  
  <tr><td>
    <!-- <%-- For showing the movie's name and image. --%> -->
    <h3>${name}</h3>
    <img src="${image}">
    <br><br>
    
    <!-- <%-- For showing the movie's rating. --%> -->
    <core:forEach begin="1" end="5" varStatus="loop">
      <core:choose>
        <core:when test="${(rating - loop.count) >= 0}">
          <span class="fa fa-star checked"></span>
        </core:when>
        <core:otherwise>
          <span class="fa fa-star"></span>
        </core:otherwise>
      </core:choose>
    </core:forEach>

  </td></tr>

  <!-- <%-- For checking whether a user is in allowed roles. --%> -->
  <core:set var="req" value="${pageContext.request}"/>
  <core:set var="isValidUser" value="${req.isUserInRole('Admin') || req.isUserInRole('Member')}"/>

  <!-- <%-- For checking whether to show the buttons or not. --%> -->
  <core:if test="${isValidUser}">
    <tr><td id="td-btn">
      <button id="rate-btn">Rate</button>
      <button onclick="location.href='editForm.show?id=${id}'">Edit</button>
      <button id="delete-btn">Delete</button>
    </td></tr>
  </core:if>

</table>

