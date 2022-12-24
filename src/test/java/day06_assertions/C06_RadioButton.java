package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {
/*
Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
 a. Verilen web sayfasına gidin.
     https://facebook.com
 b. Cookies’i kabul edin
 c. Create an account buton’una basin
 d. Radio button elementlerini locate edin ve size uygun olani secin
 */
    WebDriver driver;
@Before
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    System.out.println("setup calisti");
}

    @After
    public void tearDown(){
        driver.close();
        System.out.println("teardown calisti");
    }
  @Test
  public void test01() throws InterruptedException {
    driver.get("https://www.facebook.com/");
    driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();

    driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath(" //*[@id=\"day\"]/option[26]")).click();
  }

}
