package ui.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import domain.db.MovieDB;
import domain.model.Movie;


public class TestIndex {

	private WebDriver driver;
	private MovieDB movieDB = new MovieDB();
	private List<Movie> topThree = movieDB.getTopThree();
	
	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wiets\\Documents\\ucll TI_2017-2018\\Semester2\\Web2\\Labo3\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/1TX5_VandeputWietse");
	}
	
	@After
	public void clean(){
		driver.quit();
	}
	
	@Test
	public void indexShowsTopThree() {
		ArrayList<WebElement> td = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
		int teller=0;
		if (td.size()>0) {
			for (Movie movie:topThree) {
				assertEquals(movie.getName(), td.get(teller*4).getText());
				assertEquals(movie.getDate().toString(), (td.get(teller*4+1).getText()));
				assertEquals(movie.getGenre(), td.get(teller*4+2).getText());
				assertEquals(movie.getScore(), Integer.parseInt(td.get(teller*4+3).getText()));
				teller++;
			}
		}
		else {
			fail("No element td found");
		}	
	}
}
	
