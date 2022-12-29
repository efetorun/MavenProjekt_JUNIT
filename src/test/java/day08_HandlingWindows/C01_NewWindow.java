package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
/*
Selenium 4 ile windows konusunda yeni bir özellik geldi
// Test'in ilerleyen asamalarında yeniden amazon sayfasına dönmek gerekiyorsa
// amazon sayfasındayken bu window'un window handle degerını alıp kaydetmelıyız
osayfaya gecmek istendiginde driver.switchto().window(istenensayfanin window handle degeri)
kodu ile o sayfaya gecis yapilir

 */
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

        driver.get("https://www.amazon.com/");
Thread.sleep(3000);
String ilksayfaHandleDegeri= driver.getWindowHandle();

//yeni bir tab da wisequarter,com a gidin ve gittigimizi8 test edin
   driver.switchTo().newWindow(WindowType.TAB);

   driver.get("https://www.wisequarter.com/");
   String actualURL= driver.getCurrentUrl();
   String expectedKelime="wisequarter";
    Assert.assertTrue(actualURL.contains(expectedKelime));
    Thread.sleep(3000);

    driver.switchTo().window(ilksayfaHandleDegeri);



    }

}