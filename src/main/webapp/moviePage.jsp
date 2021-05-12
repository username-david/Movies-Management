<html>
  <body>
    <%
      if (
          request.isUserInRole("Admin") ||
          request.isUserInRole("Member")
      ) {
        out.print("Show logout button and other hidden ones");
      } else { // un-authenticated
        out.print("<a href='login.do'>Login</a><br>");
      }
    %>

    This is an open movie page. <br>
  </body>
</html>



