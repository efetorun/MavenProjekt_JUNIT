package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_windowHandle {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
@Test
    public void test01() throws InterruptedException {
        /*
        ● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
         */
    driver.get("https://the-internet.herokuapp.com/windows");
    String expectedSayfaYazis="Opening a new window";
    String actuelSayfaYazisi=driver.findElement(By.tagName("h3")).getText();
    Assert.assertEquals(expectedSayfaYazis,actuelSayfaYazisi);
   // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String expectedsayfaTitle="The Internet";
    String actualSayfaTitle= driver.getTitle();

    Assert.assertEquals(expectedsayfaTitle,actualSayfaTitle);
    //● Click Here butonuna basın.

    driver.findElement(By.linkText("Click Here")).click();
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    String expectedNewSayfaYazis="New Window";
    String actuelNewSayfaYazisi=driver.getTitle();
    String ilkSayfaHandleDegeri=driver.getWindowHandle();
    System.out.println(actuelNewSayfaYazisi);
    Assert.assertEquals(expectedNewSayfaYazis,actuelNewSayfaYazisi);
    Thread.sleep(3000);

}


}
