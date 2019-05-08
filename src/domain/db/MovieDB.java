package domain.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.model.Movie;

public class MovieDB {

	private List<Movie> overviewList = new ArrayList<Movie>();
	
	public MovieDB() {
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
		Date date = null;
		try {
			date = format.parse("1/1/1753");
		} catch (ParseException e) {
			System.out.println("date formatting was unsuccesfull.");
		}
		Movie movie1 = new Movie("The Lord of the rings: The fellowship of the ring", date, "Fantasy", 5, 11); 
		Movie movie2 = new Movie("The Lord of the rings: Two towers", date, "Fantasy", 8, 15  ); 
		Movie movie3 = new Movie("The Lord of the rings: The return of the king", date, "Fantasy", 10, 19); 
		addToDB(movie1); 
		addToDB(movie2); 
		addToDB(movie3); 
	}
	public  void addToDB(Movie movie) {
		overviewList.add(movie);
	}
	
	public Movie getFromDB() {
		return null;
	}
	
	public  List<Movie> getList() {
		return overviewList;
	}
	
	public String getTopGenre() {
		int score = -1;
		String genre = "Horror";
		for (Movie movie: overviewList) {
			if (movie.getScore() > score) {
				score = movie.getScore();
				genre = movie.getGenre();
			}
		}
		return genre;
	}
	
	@SuppressWarnings("deprecation")
	public List<Movie> getTopThree(){
//		List<Genre> genres = Arrays.asList(Genre.values()); 
		List<Movie> top3 = new ArrayList<Movie>();
		Date now = new Date();
		top3.add(0,getList().get(0));
		top3.add(1,getList().get(1));
		top3.add(2,getList().get(2));
		for (Movie movie: getList()) {
			if(movie.getDate().getMonth() == now.getMonth()) {
				if(movie.getScore() > top3.get(0).getScore()) {
					top3.set(2, top3.get(1));
					top3.set(1, top3.get(0));
					top3.set(0, movie);
				}
				else if(movie.getScore() >= top3.get(1).getScore() && movie.getScore() < top3.get(0).getScore()) {
					top3.set(2, top3.get(1));
					top3.set(1, movie);
				}
				else if(movie.getScore() >= top3.get(2).getScore() && movie.getScore() < top3.get(1).getScore()) {
					top3.set(2, movie);
				}
			}
		}
		
		return top3;
	}
	
	public int getSumOfAllHuisnummers() {
		int sum = 0;
		for(Movie movie: this.getList()) {
			sum += movie.getHuisnummer();
		}
		return sum;
	}
}
