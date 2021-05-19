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
      <button id="r-btn" onclick="location.href='login.do'">
        
        <!-- <%-- For checking when to show in/out. --%> -->
        <core:choose>
          <core:when test="${isValidUser}">Logout</core:when>
          <core:otherwise>Login</core:otherwise>
        </core:choose>
        
      </button>
    </div>

    <!-- <%-- Add movie button and type selection. --%> -->
    <div id="btn-div">

      <!-- <%-- For checking whether to show the button or not. --%> -->
      <core:if test="${isValidUser}">
        <button id="l-btn">Add a movie</button>
      </core:if>

      <!-- <%-- Type selection. --%> -->
      <form action="">
        <select name="cars" id="r-slc">
          <option value="action">Action</option>
          <option value="cartoon">Cartoon</option>
          <option value="family">Family</option>
          <option value="horror">Horror</option>
          <option value="adventure">Adventure</option>
          <option value="comedy">Comedy</option>
        </select>
      </form>

    </div>

    <!-- <%-- Color bar. --%> -->
    <div id="b-div"></div>

    <table>
      <!-- <%-- For iterating the movies. --%> -->
      <core:forEach var="movie" items="${movies}" varStatus="movieLoopCount" >
        
        <!-- <%-- For getting the rating of a particular movie. --%> -->
        <core:set var="rating" value="${ratings[movie.id]}"/>  

        <!-- <%-- For showing only four movies per row. --%> -->
        <core:if test="${movieLoopCount.count-1 % 4 == 0}">
          <tr>
        </core:if>

            <td id="td1">
              <!-- <%-- 
                For passing the current movie's information to a movie card and import it.
              --%> -->
              <core:import url="/movieCard.jsp">
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



