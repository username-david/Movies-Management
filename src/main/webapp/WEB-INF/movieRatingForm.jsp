<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
  </head>

  <body>
    <!-- <%-- Header and log in/out button. --%> -->
    <core:import url="/header.jsp">
      <core:param name="isValidUser" value='${isValidUser}'/>
    </core:import>

    <!-- <%-- Color bar. --%> -->
    <div style="height: 30px; background-color: darkcyan; "></div>
    
    <h1 class="page_name">Rate Movie</h1>
    <h1 class="page_name movie_name">${movieName}</h1>

    <form action="rate.do" method="post">
      <div class="selection_area">
        <input type="hidden" name="movieId" value="${movieId}">
        
        <core:forEach begin="1" end="5" varStatus="loop">
          <input class="selection" type="radio" 
            name="userRating" value="${loop.count}"
            required>${loop.count}<span class="fa fa-star checked"></span>
        </core:forEach>
      </div>
      <div class="button_area">
        <input class="button" type="button" value="cancel"
          onclick="location.href='movies'">
        <input id="save_btn" class="button" type="submit" value="save">
      </div>
    </form>
  </body>
</html>

<style>
  .page_name {
    text-align: center;
    font-family: cursive;
    font-size: 45px;
    margin-top: 20px;
    margin-bottom: 30px;
  }
  .movie_name {
    font-size: 35px;
  }
  .checked {
    color: orange;
  }
  .selection_area {
    font-family: cursive;
    text-align: center;
    margin-top: 40px;
    margin-bottom: 50px;
    font-size: 30px;
  }
  .selection {
    transform: scale(2);
    vertical-align: middle;
    margin-left: 30px;
    margin-right: 20px;
  }
  .button_area {
    text-align: center;
  }
  .button {
    font-family: cursive;
    font-size: 20px;
    margin-left: 15px;
    margin-right: 15px;
    width: 80px;
  }

  * {
  box-sizing: border-box;
  }
  body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
  }
  .header {
    overflow: hidden;
    background-color: #e5e2e2;
    padding-bottom: 10px;
  }
  .header a {
    float: left;
    color: black;
    text-align: center;
    padding: 10px 20px;
    text-decoration: none;
    font-size: 18px;
    line-height: 20px;
    border-radius: 4px;
    margin-top: 10px;
  }
  .header a.logo {
    font-size: 25px;
    font-weight: bold;
    padding: 0;
    margin: 0;
  }
  .favicon {
    width: auto;
    height: 50px;
    margin-left: 50px;
    margin-top: 10px;
    margin-bottom: 20px;
  }
  .header a.active {
    background-color: dodgerblue;
    color: white;
    margin-top: 20px;
    margin-right: 10px;
  }
  .header-right {
    float: right;
  }
  @media screen and (max-width: 500px) {
    .header a {
      float: none;
      display: block;
      text-align: left;
    }
    .header-right {
      float: none;
    }
  }
  .slogan {
    position: absolute;
    line-height: 1;
    top: 70px;
    font-size: 1.0em;
    font-style: italic;
    color: #111010;
    letter-spacing: 0px;
    margin-left: 50px;
  }
</style>

<script>
  $('#save_btn').click(function() {
    checked = $("[name=userRating]:checked").length;

    if (!checked) {
      alert("You must select an option!");
      return false;
    }
    
    return confirm('Please confirm: OK to continue, cancel to abort.')
  });
</script>