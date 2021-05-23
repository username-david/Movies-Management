<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <link rel="stylesheet" href="css/movieAddingPage.css">
  </head>
  <body>
    <h1 id="page_name">Add Movie</h1>
    <div id="whole">
      <form action="">
        <table>
          <tr>
            <td><label>Name</label></td>
            <td><input id="same_width" type="text" name="movieName"></td>
          </tr>
          <tr>
            <td id="top_left"><label>Description</label></td>
            <td>
              <textarea id="same_width" name="description" rows="8"></textarea>
            </td>
          </tr>
          <tr>
            <td id="top_left"><label>Type</label></td>
            <td>
              <div id="type_div">
                  <input type="checkbox" name="action" value="Action"> Action<br>
                  <input type="checkbox" name="cartoon" value="Cartoon"> Cartoon<br>
                  <input type="checkbox" name="family" value="Family"> Family<br>
                  <input type="checkbox" name="horror" value="Horror"> Horror<br>
                  <input type="checkbox" name="adventure" value="Adventure"> Adventure<br>
                  <input type="checkbox" name="comedy" value="Comedy"> Comedy<br>
              </div>
            </td>
          </tr>
          <tr>
            <td><label>Year of manufacture</label></td>
            <td>
              <jsp:useBean id="now" class="java.util.Date"/>
              <fmt:formatDate var="year" value="${now}" pattern="yyyy"/>

              <select name="year">
                <core:forEach var="year" begin="1997" end="${year}">
                  <option value="${year}">${year}</option>
                </core:forEach>
              </select>
            </td>
          </tr>
          <tr>
            <td><label>Release date</label></td>
            <td>
              <input type="date" name="date">
            </td>
          </tr>
          <tr>
            <td><label>Image</label></td>
            <td>
              <input type="file" name="image">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <input id="input_btn" type="submit" value="save">
              <input id="input_btn" type="button" value="cancel">
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>