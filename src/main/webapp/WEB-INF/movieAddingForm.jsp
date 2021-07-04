<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
  </head>

  <body>
    <!-- <%-- Header and log in/out button. --%> -->
    <core:import url="/header.jsp">
      <core:param name="isValidUser" value='${isValidUser}'/>
    </core:import>

    <h1 id="page_name">${formType} Movie</h1>
    <div id="whole">

      <core:choose>
        <core:when test="${formType == 'Add'}">
          <core:set var="resource" value="add.do"/>
        </core:when>
        <core:otherwise>
          <core:set var="resource" value="edit.do"/>
        </core:otherwise>
      </core:choose>

      <form action="${resource}" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="movieId" value="${movie.id}">
        
        <table>
          <tr>
            <td><label class="required">Name</label></td>
            <td>
              <input id="same_width" type="text" name="movieName" 
                value="${movie.name}" required>
            </td>
          </tr>
          <tr>
            <td id="top_left"><label>Description</label></td>
            <td>
              <textarea id="same_width" name="description" rows="6">${movie.description}</textarea>
            </td>
          </tr>
          <tr>
            <td id="top_left"><label class="required">Genre</label></td>
            <td>

              <core:set var="defaultGenres" value="${{
                'Action', 'Cartoon', 'Family', 
                'Horror', 'Adventure', 'Comedy'
              }}"/>

              <div id="type_div">
                <core:forEach var="defaultGenre" items="${defaultGenres}">
                  <core:choose>

                    <core:when test="${fn:contains(movie.genres, defaultGenre)}">
                      <input id="same_font" type="checkbox" name="genres" 
                        value="${defaultGenre}" checked> ${defaultGenre}<br>
                    </core:when>

                    <core:otherwise>
                      <input id="same_font" type="checkbox" name="genres" 
                        value="${defaultGenre}"> ${defaultGenre}<br>
                    </core:otherwise>

                  </core:choose>
                </core:forEach>
              </div>
            </td>
          </tr>
          <tr>
            <td><label>Year of manufacture</label></td>
            <td>
              <jsp:useBean id="now" class="java.util.Date"/>
              <fmt:formatDate var="currentYear" value="${now}" pattern="yyyy"/>
              
              <select id="same_font" name="manufactureYear">
                <core:forEach var="year" begin="1997" end="${currentYear}">
                  <core:set var="isSelected" value=""/>

                  <core:choose>
                    <core:when test="${movie.manufactureYear == 0}">
                      <option value="0" selected>--/--</option>
                    </core:when>
                    <core:otherwise>
                      <core:if test="${year == movie.manufactureYear}">
                        <core:set var="isSelected" value="selected"/>
                      </core:if>
                    </core:otherwise>
                  </core:choose>

                  <option value="${year}" ${isSelected}>${year}</option>
                </core:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td><label>Release date</label></td>
            <td>
              <input id="same_font" type="date" name="releaseDate" value="${movie.releaseDate}">
            </td>
          </tr>
          <tr>
            <td><label>Image</label></td>
            <td>
              <input id="same_font" type="file" name="image">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <input id="save_btn" type="submit" value="save">
              <input id="cancel_btn" type="button" value="cancel" 
                onclick="location.href='movies'">
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>

<style>
  .required::after {
    content: " *";
    color: red;
  }
  input {
    margin:10px 0;
  }
  #page_name {
    text-align: center;
    font-family: cursive;
    font-size: 45px;
    margin-top: 20px;
    margin-bottom: 20px;
  }
  label {
    font-size: larger; 
    font-family: cursive;
    padding-right: 30px;
  }
  #top_left{
    text-align: left; 
    vertical-align: top;
  }
  textarea {
    resize: none;
  }
  #type_div {
    column-count: 2;
    column-gap: 40px;
  }
  ul {
    line-height: 200%;
    list-style-type: none;
  }
  #save_btn, #cancel_btn {
    font-family: cursive;
    font-size: 20px;
    float: right; 
    margin-left: 30px;
  }
  form {
    align-content: center;
  }
  #whole {
    margin-left: 25%;
  }
  #same_width {
    font-family: cursive;
    width: 400px;
    font-size: 15px;
  }
  td {
    padding-top: 6px;
    padding-bottom: 6px;
  }
  #same_font {
    font-family: cursive;
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
    isNameFilled =  $("input[name='movieName']").val();

    if (!isNameFilled) {
      alert("You must enter the name!");
      return false;
    }
    
    checked = $("[name=genres]:checked").length;

    if (!checked) {
      alert("You must select at least one genre!");
      return false;
    }
    
    return confirm('Please confirm: OK to continue, cancel to abort.')
  });
</script>