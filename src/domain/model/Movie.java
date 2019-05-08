package domain.model;

import java.util.Date;

public class Movie {
	
	private String name;
	private Date date;
	private String genre;
	private int Score;
	private int Huisnummer;
	
	public Movie(String name, Date date, String genre, int score, int Huisnummer) {
		setName(name);
		setDate(date);
		setGenre(genre);
		setScore(score);
		setHuisnummer(Huisnummer);
		
	}
	
	public int getHuisnummer() {
		return Huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		if (name.isEmpty() || name == null) throw new IllegalArgumentException("Insert valid huisnummer");
		Huisnummer = huisnummer;
	}

	public void setName(String name) {
		if (name.isEmpty() || name == null) throw new IllegalArgumentException("Insert valid name");
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDate(Date date) {
		if (date == null) throw new IllegalArgumentException("Insert valid date");
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setGenre(String genre) {
		if (genre.isEmpty() || genre == null) throw new IllegalArgumentException("Insert valid genre");
		this.genre = genre;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setScore(int score) throws IllegalArgumentException{
		if (score < 0 || score > 10) throw new IllegalArgumentException("Insert valid score");
		this.Score = score;
	}
	
	public int getScore() {
		return this.Score;
	}
	
}
