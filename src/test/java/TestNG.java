import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

    WebDriver driver;

    @BeforeTest
    public void Bfrtest(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://piworks.net/");
        driver.manage().window().maximize();

    }

    @Test
    public void ContactButtonPassTest(){

        WebElement contactbutton = driver.findElement(By.className("btn-contact"));
        contactbutton.click();

    }
    @Test
    public void SearchPassTest(){
        WebElement search = driver.findElement(By.xpath("//div[@class='top-menu']//input[@id='search']"));
        search.click();
        search.sendKeys("Our Values");
        search.submit();

    }

    @Test
    public void TitlePassTest(){

        String expectedtitle = "P.I. Works - Automation Now and Forever";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle, expectedtitle);

    }
    @Test
    public void TitleFailTest(){

        String expectedtitle = "Test";
        String actualtitle = driver.getTitle();
        Assert.assertFalse(actualtitle == expectedtitle);

    }

    @AfterTest
    public void AftrTest(){
        driver.quit();
    }


}
