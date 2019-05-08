
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.db.MovieDB" %>
<%@ page import="domain.model.Movie" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
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
					<li><a href="add.jsp">Add</a></li>
					<li><a href="watchlist" class="active">Overview</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<article>
			<h2>Overview</h2>
				<p>A complete overview of all movies watched and a score to represent how good they are and the probability to watch again.</p>
				 <table>
					  <tr class="Header">
					    <th>Name</th>
					    <th>Viewdate</th>
					    <th>Genre</th>
					    <th>Score</th>
					    <th>Huisnummer</th>
					  </tr>
					  <% MovieDB movieDB = (MovieDB) request.getAttribute("movieDB"); %>	
					  	<% for (Movie movie: movieDB.getList()){ %>
							<tr>
								<td><%=movie.getName() %></td>
								<td><%=movie.getDate() %></td>
								<td><%=movie.getGenre() %></td>
								<td><%=movie.getScore() %></td>
								<td><%=movie.getHuisnummer() %></td>
							</tr>
						<% } %>
					</table>
					
					<p>De som van alle huisnummers is gelijk aan <%=movieDB.getSumOfAllHuisnummers() %>.</p>
			</article>

		</main>
		<footer>
			<p><a href="http://www.imdb.com/">ImDb</a></p>
		</footer>
	</body>
</html>
