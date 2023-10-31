import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize(); //tam ekran

        driver.get("https://www.google.com"); //adress

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit(); //kapatma




        //TIMEOUT
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //sayfa yuklemeyi bekler
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //işlemleri bekler
        // Window
        driver.manage().window().maximize(); //pencereyi tam ekran yapar
        int X = driver.manage().window().getPosition().getX(); //pencerenin x konumunu verir
        int Y = driver.manage().window().getPosition().getY(); // pencerenin y konumu

        //URL
        driver.get("https://www.piworks.net"); //adress
        String CurrentURL = driver.getCurrentUrl();
        String Title = driver.getTitle(); //sayfa baslıgı
        String PageSource = driver.getPageSource(); //sayfa kaynak kodları

        //Navigate
        driver.navigate().back(); //geri gitmek
        driver.navigate().forward(); // ileri gitmek
        driver.navigate().refresh(); //sayfayı yenıler


             System.out.println(PageSource);




        driver.get("https://www.piworks.net/contact");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//div[@class='mobile-search show']//input[@id='search']"));
        WebElement search = driver.findElement(By.id(""));
        WebElement firstname = driver.findElement(By.cssSelector(""));
        WebElement element4 = driver.findElement(By.name(""));
        WebElement element5 = driver.findElement(By.linkText(""));
        WebElement searchicon = driver.findElement(By.className("icon-search"));

        search.click(); //tıklama işlemi
        search.sendKeys("Tamer");


        driver.get("https://piworks.net/");
        driver.manage().window().maximize();

        WebElement contactbutton = driver.findElement(By.className("btn-contact"));
        contactbutton.click();

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,800)", "");

        WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name *']"));
        firstname.click();
        firstname.sendKeys("Tamer");

        WebElement lastname = driver.findElement(By.cssSelector("input[placeholder='Last Name *']"));
        lastname.click();
        lastname.sendKeys("Pusat");

        WebElement businessemailadress = driver.findElement(By.xpath("//input[@placeholder='Business E-Mail Address *']"));
        businessemailadress.click();
        businessemailadress.sendKeys("tamer.pusat@hotmail.com");

        WebElement company = driver.findElement(By.xpath("//input[@placeholder='Company']"));
        company.click();
        company.sendKeys("PI");

        WebElement jobtitle = driver.findElement(By.xpath("//input[@placeholder='Job Title ']"));
        jobtitle.click();
        jobtitle.sendKeys("Software Engineer");

        WebElement businessphone = driver.findElement(By.xpath("//input[@placeholder='Business Phone']"));
        businessphone.click();
        businessphone.sendKeys("0 546 935 04 12");

        WebElement message = driver.findElement(By.xpath("//textarea[@placeholder='Message*']"));
        message.click();
        message.sendKeys("Message Test");












    }
}
