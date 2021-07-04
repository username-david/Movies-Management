<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
  <core:set var="isValidUser" value="${param.isValidUser}"/>
  <core:set var="id" value="${param.id}"/>
  <core:set var="name" value="${param.name}"/>
  <core:set var="image" value="${param.image}"/>
  <core:set var="rating" value="${param.rating}"/>
  
  <tr><td colspan="3">
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

  <!-- <%-- For checking whether to show the buttons or not. --%> -->
  <core:if test="${isValidUser}">
    <tr>
      <td id="td-btn">
        <form action="ratingForm.show" method="post">
          <input type="hidden" name="isValidUser" value="${isValidUser}">
          <input type="hidden" name="movieId" value="${id}">
          <input class="button rate_btn" type="submit" value="Rate">
        </form>
      </td>
      <td id="td-btn">
        <form action="editForm.show" method="post">
          <input type="hidden" name="isValidUser" value="${isValidUser}">
          <input type="hidden" name="movieId" value="${id}">
          <input class="button" type="submit" value="Edit">
        </form>
      </td>
      <td id="td-btn">
        <form action="delete.do" method="post">
          <input type="hidden" name="movieId" value="${id}">
          <input id="deleteBtn${id}" class="button" type="submit" value="Delete">
        </form>
      </td>
    </tr>
  </core:if>
</table>

<script>
  $('#deleteBtn${id}').click(function() {
    return confirm('Please confirm: OK to continue, cancel to abort.')
  });
</script>