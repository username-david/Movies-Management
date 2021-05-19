<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <link rel="stylesheet" href="css/moviePage.css">
  </head>

  <body>
    <core:set var="req" value="${pageContext.request}"/>
    <core:set var="isValidUser" value="${req.isUserInRole('Admin') || req.isUserInRole('Member')}"/>

    <div id="cDiv">
      <h2 id="tH2">Movies</h2>
      <button id="rBtn" onclick="location.href='login.do'">
        <core:choose>
          <core:when test="${isValidUser}">Logout</core:when>
          <core:otherwise>Login</core:otherwise>
        </core:choose>
      </button>
    </div>
    <div>
      <core:if test="${isValidUser}">
        <button id="lBtn">Add a movie</button>
      </core:if>
      <button id="rBtn">type</button>
    </div>
    <div id="bDiv"></div>

    <jsp:useBean id="mvHelper" class="com.example.management.MovieHelper"/>
    <core:set var="movies" value="${mvHelper.getMovies()}"/>

    <table>
      <core:forEach var="movie" items="${movies}" varStatus="movieLoopCount" >
        
        <core:set var="rating" value="${mvHelper.getRating(${movie.id})}"/>  

        <core:if test="${movieLoopCount.count-1 % 4 == 0}">
          <tr>
        </core:if>

            <td id="td1">
              <core:import url="/movieCard.jsp">
                <core:param name="name" value='${movie.name}'/>
                <core:param name="image" value='${movie.image}'/>
                <core:param name="rating" value='${rating}'/>
              </core:import>
            </td>

        <core:if test="${movieLoopCount.count % 4 == 0}">
          </tr>
        </core:if>

      </core:forEach>

      <core:if test="${fn:length(movies) % 4 != 0}">
          </tr>
      </core:if>
      
      <!-- <%--
      <% 
        for (int i = 0; i < 5; i++) {
            if (i % 4 == 0) {
                out.println("<tr>");
            } 

            out.print("<td id='td1'>");
      %>
      <%@ include file="/movieCard.jsp"%> 
      <%    
            out.print("</td>");


            if ((i + 1) % 4 == 0) {
                out.println("</tr>");
            }
        }

        if (5 % 4 != 0) {
            out.println("</tr>");
        }
      %>
      --%> -->
    </table>
  </body>
</html>



