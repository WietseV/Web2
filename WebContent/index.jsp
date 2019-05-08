<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="domain.db.MovieDB" %>
<%@ page import="domain.model.Movie" %>
<%@ page import="java.util.*" %>
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
					<li><a href="index.jsp" class="active">Home</a></li>
					<li><a href="add.jsp">Add</a></li>
					<li><a href="watchlist">Overview</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<article>
			<h2>Home</h2>
				<%! MovieDB moviedb = new MovieDB(); %>
				<p>This months top 3 movies:  </p>
				<table>
				<%List<Movie> lijst = moviedb.getTopThree(); %>
				<%for (Movie movie: lijst){ %>
				<tr>
								<td><%=movie.getName() %></td>
								<td><%=movie.getDate() %></td>
								<td><%=movie.getGenre() %></td>
								<td><%=movie.getScore() %></td>
							</tr>
				<%} %>
				</table>
					  
			</article>

		</main>
		<footer>
			<p><a href="http://www.imdb.com/">ImDb</a></p>
		</footer>
	</body>
</html>
