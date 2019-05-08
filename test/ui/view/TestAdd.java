package ui.view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TestAdd {

	private WebDriver driver;
	
	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wiets\\Documents\\ucll TI_2017-2018\\Semester2\\Web2\\Labo3\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/1TX5_VandeputWietse/add.jsp");
	}
	
	@After
	public void clean(){
		driver.quit();
	}
	
	@Test
	public void afterAddingOverzichtShowsTheNewMovieAswell() {
		WebElement naam = driver.findElement(By.id("name"));
		naam.sendKeys("test");
		
		WebElement viewdate = driver.findElement(By.id("ViewDate"));
		viewdate.sendKeys("https://localhost:8080/1TX5_VandeputWietse");
		
		Select dropdownGenre = new Select(driver.findElement(By.id("Genre")));
		dropdownGenre.selectByValue("Fantasy");
		
		WebElement score = driver.findElement(By.id("Score"));
		score.sendKeys("5");
		
		WebElement button = driver.findElement(By.id("submit"));
		button.click();

		ArrayList<WebElement> td = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
		int teller=(td.size()-1)/4;
		if (td.size()>0) {
				assertEquals(td.get(teller*4).getText(), "test");
				assertEquals(td.get(teller*4+1).getText(), "Thu Aug 08 00:00:00 CET 15");
				assertEquals(td.get(teller*4+2).getText(), "Fantasy");
				assertEquals(Integer.parseInt(td.get(teller*4+3).getText()), 5);
				teller++;
		}
		else {
			fail("No element td found");
		}	
	}
}
	