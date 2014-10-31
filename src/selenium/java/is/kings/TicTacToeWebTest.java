package is.kings;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TicTacToeWebTest{

	static WebDriver driver;
  	static String baseUrl;
  	static boolean acceptNextAlert = true;
 	 static StringBuffer verificationErrors = new StringBuffer();

  	@Before
  	public void setUp() throws Exception {
    		driver = new FirefoxDriver();
    		baseUrl = "http://amazinggames.herokuapp.com/";
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	}

  	@Test
  	public void testSeleniumH1() throws Exception {
    		driver.get(baseUrl);
    		driver.findElement(By.linkText("New Game")).click();
    		assertEquals("Play the amazing Tic Tac Toe game", driver.findElement(By.cssSelector("h1")).getText());
  	}

	@Test
  	public void testSelenuimParagraph() throws Exception {
    		driver.get(baseUrl);
    		driver.findElement(By.linkText("New Game")).click();
    		assertEquals("Enter a number between 1-9", driver.findElement(By.cssSelector("p")).getText());
  	}

	@Test
        public void testSelenuimInputChar() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("New Game")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("a");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		assertEquals("Invalid move , try again", driver.findElement(By.xpath("//div[@id='results']/pre[2]")).getText());
	}

	@Test
        public void testSelenuimTooSmallNumber() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("New Game")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("0");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		assertEquals("Invalid move , try again", driver.findElement(By.xpath("//div[@id='results']/pre[2]")).getText());
	}

        @Test
        public void testSelenuimTooLargeNumber() throws Exception {
                driver.get(baseUrl);
                driver.findElement(By.linkText("New Game")).click();
                driver.findElement(By.id("number")).clear();
                driver.findElement(By.id("number")).sendKeys("10");
                driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
                assertEquals("Invalid move , try again", driver.findElement(By.xpath("//div[@id='results']/pre[2]")).getText());
	}

	@Test
        public void testSelenuimGameOver() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("New Game")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("1");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("2");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("3");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("4");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("5");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("6");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("7");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("8");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("9");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("1");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		assertEquals("GAME OVER", driver.findElement(By.xpath("//div[@id='results']/pre[2]")).getText());
	}

	@After
  	public void tearDown() throws Exception {
    		driver.quit();
    		String verificationErrorString = verificationErrors.toString();
    		if (!"".equals(verificationErrorString)) {
      			fail(verificationErrorString);
    		}
  	}

  	private boolean isElementPresent(By by) {
    		try {
      			driver.findElement(by);
      			return true;
    		} catch (NoSuchElementException e) {
      			return false;
    		}
  	}

  	private boolean isAlertPresent() {
    		try {
     			 driver.switchTo().alert();
      		return true;
   		 } catch (NoAlertPresentException e) {
      			return false;
    		}
  	}

 	 private String closeAlertAndGetItsText() {
    		try {
      			Alert alert = driver.switchTo().alert();
      			String alertText = alert.getText();
      			if (acceptNextAlert) {
        			alert.accept();
      			} else {
        			alert.dismiss();
      			}
     	 	return alertText;
   		 } finally {
      			acceptNextAlert = true;
    		}
  	}

}
