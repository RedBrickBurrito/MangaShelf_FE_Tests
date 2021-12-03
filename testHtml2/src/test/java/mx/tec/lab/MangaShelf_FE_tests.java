package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MangaShelf_FE_tests {

	private static WebDriver driver;
	
	@BeforeEach
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Scyruz\\Downloads\\Programs\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void givenAClient_WhenEnteringCorrectCredentials_ThenPageTitleIsCorrect() throws Exception{
		
		//When
		driver.get ( "https://manga-shelf-fe.herokuapp.com/" ) ; 
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/input"));
		usernameField.sendKeys("Scyruz3");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[3]/div/input"));
		passwordField.sendKeys("scyruz3");
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/button"));
		submitButton.click();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/p"));	
		
		//Then
		assertEquals("recent reviews", pageTitle.getText());
		}
	
	@Test
	public void givenHomeReviewsPage_WhenClickingInAReviews_ThenReviewsDetailPageisDisplayed() throws Exception{
		
		//When
		driver.get ( "https://manga-shelf-fe.herokuapp.com/" ) ; 
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/input"));
		usernameField.sendKeys("Scyruz3");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[3]/div/input"));
		passwordField.sendKeys("scyruz3");
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/button"));
		submitButton.click();	
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		WebElement mangaTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/a/div/p[1]"));		
		WebElement reviewCard = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/a"));
		reviewCard.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/p[1]"));

		//Then
		
		assertEquals("Review "+mangaTitle.getText(), pageTitle.getText());
		}
	
	@Test
	public void givenaClient_WhenClickingInBookmarkIcon_ThenMangasQueuePageIsDisplayed() throws Exception{
		
		//When
		driver.get ( "https://manga-shelf-fe.herokuapp.com/" ) ; 
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/input"));
		usernameField.sendKeys("Scyruz3");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[3]/div/input"));
		passwordField.sendKeys("scyruz3");
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/button"));
		submitButton.click();	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement bookmark = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/button/span[1]/svg/path"));		
		bookmark.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement pageTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/p"));

		
		//Then
		assertEquals("Your mangas to read later", pageTitle.getText());
	}
}