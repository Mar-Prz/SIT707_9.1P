package web.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class FunctionalTests {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\markd\\Desktop\\Rzeczy\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:9090");
      
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() {
        driver.get("http://localhost:9090/login");
        sleep(5);

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        WebElement dobField = driver.findElement(By.name("dob"));
        WebElement submit = driver.findElement(By.cssSelector("[type=submit]"));

        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");
        dobField.sendKeys("01-01-1990");

        submit.submit();
        sleep(5);
        // Check if login was successful
        assertTrue(driver.getCurrentUrl().contains("q1"));
        
    }

    @Test
    public void testQ1() {
        driver.get("http://localhost:9090/q1");

        WebElement number1 = driver.findElement(By.name("number1"));
        WebElement number2 = driver.findElement(By.name("number2"));
        WebElement result = driver.findElement(By.name("result"));
        WebElement submit = driver.findElement(By.cssSelector("[type=submit]"));

        number1.sendKeys("10");
        number2.sendKeys("5");
        result.sendKeys("15");

        submit.submit();
        sleep(5);
        // Verify the result
        assertTrue(driver.getCurrentUrl().contains("q2"));
       
    }

    @Test
    public void testQ2() {
        driver.get("http://localhost:9090/q2");

        WebElement number1 = driver.findElement(By.name("number1"));
        WebElement number2 = driver.findElement(By.name("number2"));
        WebElement result = driver.findElement(By.name("result"));
        WebElement submit = driver.findElement(By.cssSelector("[type=submit]"));

        number1.sendKeys("10");
        number2.sendKeys("5");
        result.sendKeys("5");

        submit.submit();
        sleep(5);
        // Verify the result
        assertTrue(driver.getCurrentUrl().contains("q3"));
        
    }

    @Test
    public void testQ3() {
        driver.get("http://localhost:9090/q3");

        WebElement number1 = driver.findElement(By.name("number1"));
        WebElement number2 = driver.findElement(By.name("number2"));
        WebElement result = driver.findElement(By.name("result"));
        WebElement submit = driver.findElement(By.cssSelector("[type=submit]"));

        number1.sendKeys("10");
        number2.sendKeys("5");
        result.sendKeys("50");

        submit.submit();
        sleep(5);
        // Verify the result
        assertTrue(driver.getCurrentUrl().contains("pass"));
        
    }
}