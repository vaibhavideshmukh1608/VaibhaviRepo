package demo;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Wrapper;
import java.time.Instant;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
//import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        WebElement inputBox1=driver.findElement(By.xpath("//div[@class='Xb9hP']/input[@type='text']"));
        Wrappers.enterText(inputBox1, "Crio Learner");
        
    }

    @Test
    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        WebElement textareaInputBox=driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        String content="I want to be the best QA Engineer!";
        long currentEpochTimeMs = Instant.now().getEpochSecond();
        Wrappers.enterText(textareaInputBox, content+""+currentEpochTimeMs);
        Thread.sleep(3000);

    }

    @Test
    public void testCase03() throws InterruptedException{
        String text=Wrappers.radioTextFun("0 - 2");
        WebElement radioButton=driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//span[contains(text(),'"+text+"')]"));
        radioButton.click();
        Thread.sleep(3000);

    }

    @Test
    public void testCase04() throws InterruptedException{
        List<WebElement> checkboxText=driver.findElements(By.xpath("//div[@class='Y6Myld']//span"));
        for(WebElement valcheck : checkboxText){
            System.out.println(valcheck.getText());
        }
        Wrappers.checkBoxClick(checkboxText, "Java");
        Wrappers.checkBoxClick(checkboxText, "Selenium");
        Thread.sleep(3000);

    }

    @Test
    public void testCase05() throws InterruptedException{
        WebElement dropDownSelect=driver.findElement(By.xpath("//span[text()='Choose']"));
        dropDownSelect.click();
        Thread.sleep(3000);
        List<WebElement> dropdownList=driver.findElements(By.xpath("//div[contains(@class,'OA0qNb ncFHed QXL7Te')]//span[not(contains(text(),'Choose'))]"));
        Wrappers.dropdownClick(dropdownList, "Ms");
        Thread.sleep(3000);
    }

    @Test
    public void testCase06() throws InterruptedException{
        WebElement dateSelect=driver.findElement(By.xpath("//input[@type='date']"));
        String sevenDaysbefore=Wrappers.getLocalDate();
        Wrappers.enterText(dateSelect, sevenDaysbefore);
        Thread.sleep(3000);
        
    }

    @Test
    public void testCase07() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement hour=driver.findElement(By.xpath("//input[@aria-label='Hour']"));
       WebElement min=driver.findElement(By.xpath("//input[@aria-label='Minute']"));
       WebElement subbutton=driver.findElement(By.xpath("//div[@role='button']//span[text()='Submit']"));

       Wrappers.enterText(hour, "07");
       Wrappers.enterText(min, "30");
       subbutton.click();
       Thread.sleep(3000);
       
    WebElement successmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vHW8K']")));

    
    String actualMsg = successmsg.getText().trim();
    System.out.println("Success message: " + actualMsg);

    
    String expectedMsg = "Thanks for your response, Automation Wizard!";

    // Assert that the success message matches the expected message
    Assert.assertEquals(actualMsg, expectedMsg, "The success message does not match the expected value.");
       
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}