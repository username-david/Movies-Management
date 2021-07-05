<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/movies.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/movieCard.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
  </head>

  <body>
    <!-- <%-- For checking whether a user is in allowed roles. --%> -->
    <core:set var="req" value="${pageContext.request}"/>
    <core:set var="isValidUser" value="${req.isUserInRole('Admin') || req.isUserInRole('Member')}"/>

    <!-- <%-- Header and log in/out button. --%> -->
    <core:import url="/header.jsp">
      <core:param name="isValidUser" value='${isValidUser}'/>
    </core:import>

    <!-- <%-- Title. --%> -->
    <div id="h-div">
      <h1 id="t-h2">Movies</h1>
    </div>

    <!-- <%-- Add movie button and genre selection. --%> -->
    <div id="btn-div">
      <!-- <%-- For checking whether to show the button or not. --%> -->
      <core:if test="${isValidUser}">
        <form action="addingForm.show" method="post">
          <input type="hidden" name="isValidUser" value="${isValidUser}">
          <input id="l-btn" type="submit" value="Add a movie">
        </form>
      </core:if>

      <!-- <%-- Genre selection. --%> -->
      <form action="movies" method="get">
        <input class="filter_btn" type="submit" value="filter">

        <select id="r-slc" name="genreSelection">
          <core:choose>
            <core:when test="${selectedGenre == All}">
              <option value="All" selected>--All--</option>
              <core:forEach var="usedGenre" items="${usedGenres}">
                <core:set var="genreName" value="${usedGenre.name}"/>
                <option value="${genreName}">${genreName}</option>
              </core:forEach>
            </core:when>
            <core:otherwise>
              <option value="All">--All--</option>
              <core:forEach var="usedGenre" items="${usedGenres}">
                <core:set var="genreName" value="${usedGenre.name}"/>
                <core:choose>
                  <core:when test="${selectedGenre == genreName}">
                    <option value="${genreName}" selected>${genreName}</option>
                  </core:when>
                  <core:otherwise>
                    <option value="${genreName}">${genreName}</option>
                  </core:otherwise>
                </core:choose>
              </core:forEach>
            </core:otherwise>
          </core:choose>
        </select>
      </form>
    </div>

    <!-- <%-- Color bar. --%> -->
    <div id="b-div"></div>
    
    <core:set var="movieListSize" value="${fn:length(movies)}"/>
    <table class="align-text">
      <core:choose>
        <core:when test="${movieListSize == 0}">
          <h1 class="page_notification">No movies currently.</h1>
        </core:when>
        <core:otherwise>
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
                <core:param name="isValidUser" value='${isValidUser}'/>
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
          <core:if test="${movieListSize % 4 != 0}">
            </tr>
          </core:if>
        </core:otherwise>
      </core:choose>
    </table>
  </body>
</html>