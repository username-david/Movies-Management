<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <link rel="stylesheet" href="css/movies.css">
  </head>

  <body>
    <!-- <%-- For checking whether a user is in allowed roles. --%> -->
    <core:set var="req" value="${pageContext.request}"/>
    <core:set var="isValidUser" value="${req.isUserInRole('Admin') || req.isUserInRole('Member')}"/>

    <!-- <%-- Title and log in/out button. --%> -->
    <div id="h-div">
      <h1 id="t-h2">Movies</h1>

      <!-- <%-- For checking when to show in/out. --%> -->
      <core:choose>
        <core:when test="${isValidUser}">
          <button id="r-btn" onclick="location.href='logout.do'">Logout</button>
        </core:when>
        <core:otherwise>
          <button id="r-btn" onclick="location.href='login.do'">Login</button>
        </core:otherwise>
      </core:choose>
    </div>

    <!-- <%-- Add movie button and genre selection. --%> -->
    <div id="btn-div">

      <!-- <%-- For checking whether to show the button or not. --%> -->
      <core:if test="${isValidUser}">
        <button id="l-btn" onclick="location.href='addingForm.show'">
          Add a movie
        </button>
      </core:if>

      <!-- <%-- Genre selection. --%> -->
      <form action="">
        <select name="genres" id="r-slc">
          <core:forEach var="genre" items="${genres}">
            <option value="${genre.name}">${genre.name}</option>
          </core:forEach>
        </select>
      </form>

    </div>

    <!-- <%-- Color bar. --%> -->
    <div id="b-div"></div>

    <table>
      <!-- <%-- For iterating the movies. --%> -->
      <core:forEach var="movie" items="${movies}" varStatus="movieLoopCount" >
        
        <!-- <%-- For getting the rating of a particular movie. --%> -->
        <core:set var="rating" value="${movie.avgRating}"/>

        <!-- <%-- For showing only four movies per row. --%> -->
        <core:if test="${movieLoopCount.count-1 % 4 == 0}">
          <tr>
        </core:if>

            <td id="td1">
              <!-- <%-- 
                For passing the current movie's information to a movie card and import it.
              --%> -->
              <core:import url="/movieCard.jsp">
                <core:param name="id" value='${movie.id}'/>
                <core:param name="name" value='${movie.name}'/>
                <core:param name="image" value='${movie.image}'/>
                <core:param name="rating" value='${rating}'/>
              </core:import>
            </td>
        
        <!-- <%-- For showing only four movies per row. --%> -->
        <core:if test="${movieLoopCount.count % 4 == 0}">
          </tr>
        </core:if>

      </core:forEach>

      <!-- <%-- For showing only four movies per row. --%> -->
      <core:if test="${fn:length(movies) % 4 != 0}">
          </tr>
      </core:if>

    </table>
  </body>
</html>



