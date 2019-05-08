package ui.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.MovieDB;
import domain.model.Movie;

/**
 * Servlet implementation class watchlist
 */
@WebServlet("/watchlist")
public class Watchlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDB movieDB = new MovieDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Watchlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("movieDB", movieDB);
		RequestDispatcher view = request.getRequestDispatcher("overview.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination;
		try {
		String nameFromForm = request.getParameter("name");
		String dateFromForm = request.getParameter("ViewDate");
		String genreFromForm = request.getParameter("Genre");
		int HuisnummerFromForm = Integer.parseInt(request.getParameter("Huisnummer"));
		int scoreFromForm = Integer.parseInt(request.getParameter("Score"));

		Date date = null;
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = df.parse(dateFromForm);
		} catch (ParseException e) {
			System.out.println("Date formatting was unsuccesfull.");
		}
		
		if (10 <= HuisnummerFromForm && HuisnummerFromForm <= 30 ) {
			Movie movie = new Movie(nameFromForm, date, genreFromForm, scoreFromForm, HuisnummerFromForm);
			movieDB.addToDB(movie);
			
			request.setAttribute("movieDB", movieDB);
			destination = "overview.jsp";
		}
		else {
			request.setAttribute("Huisnummer", HuisnummerFromForm);
			destination = "bijzondereInwoners.jsp";
		}
		}catch (Exception e) {
			destination = "add.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
		
	}

}
