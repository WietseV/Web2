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
					<li><a href="index.jsp" >Home</a></li>
					<li><a href="add.jsp">Add</a></li>
					<li><a href="watchlist">Overview</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<article>
			<h2>Bijzondere Inwoner</h2>
				<p>U bent een bijzondere inwoner van deze straat want u woont op huisnummer <%= request.getAttribute("Huisnummer") %>.</p>
				
					  
			</article>

		</main>
		<footer>
			<p><a href="http://www.imdb.com/">ImDb</a></p>
		</footer>
	</body>
</html>
