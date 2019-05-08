<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.db.Genre" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title lang="en">The Watchlist</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<header>
			<h1>
			<a href="index.jsp">The WatchList</a>
			</h1>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="add.jsp" class="active">Add</a></li>
					<li><a href="watchlist">Overview</a></li>
				</ul>
			</nav>
		</header>
	<main>
		<article>
		<h2>Add</h2>
			  <form class="add" method="post" action="watchlist" novalidate>
			        <fieldset>
			          <p>
			            <label for="name">Name*:</label>
			            <input type="text" id="name" name="name" placeholder="" required>
			          </p>
			          <p>
			            <label for="ViewDate">Viewdate*:</label>
			            <input type="Date" id="ViewDate" name="ViewDate" required>
			          </p>
			          <p>
			            <label for="Genre">Genre*:</label>
			            <select id="Genre" name="Genre" required title="Genre" >
			              <option label="empty"  selected></option>
			              <%List<Genre> genres = Arrays.asList(Genre.values()); %>
			              <% for (Genre genre: genres ){ %>
			              	<option value="<%= genre%>"><%= genre%></option>
			              <%} %>
			            </select>
			          </p>
			          <p>
			            <label for="Score">Score*:</label>
			            <input type="number" min="0" max="10" id="Score" name="Score" placeholder="#" required>
			          </p>
			          <p>
			            <label for="Huisnummer">Huisnummer*:</label>
			            <input type="number" min="10" max="30" id="Huisnummer" name="Huisnummer" placeholder="#" required>
			          </p>
			        </fieldset>
		        <input type="submit" value="Add"  id ="submit" style="margin-left : 1em;">
		      </form>
		</article>
	</main>
	<footer>
		<p><a href="http://www.imdb.com/">ImDb</a></p>
	</footer>
</body>
</html>
