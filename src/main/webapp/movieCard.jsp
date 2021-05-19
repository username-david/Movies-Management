<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/movieCard.css">

<table>
  <core:set var="name" value="${param.name}"/>
  <core:set var="image" value="${param.image}"/>

  <tr><td>
    <h3>${name}</h3>
    <img src="${image}">
    <br><br>

    
    <!-- ******************* -->
    <span class="fa fa-star checked"></span>
    <span class="fa fa-star checked"></span>
    <span class="fa fa-star checked"></span>
    <span class="fa fa-star"></span>
    <span class="fa fa-star"></span>
    <!-- ****************** -->

  </td></tr>

  <core:set var="req" value="${pageContext.request}"/>
  <core:set var="isValidUser" value="${req.isUserInRole('Admin') || req.isUserInRole('Member')}"/>

  <core:if test="${isValidUser}">
    <tr><td id="tdBtn">
      <button id="rateBtn">Rate</button><button id="editBtn">Edit</button><button id="deleteBtn">Delete</button>
    </td></tr>
  </core:if>

</table>

