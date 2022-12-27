package day07_dropdown_JavaScriptAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JavaScriptAlerts {
    //gerekli ayarlamalardan sonra
    //https://the-internet.herokuapp.con/javascript_alerts
    //adresine gidin
    //3 adet method u olusturup her method da bir JsAlert e basin
    //ilgili methodlari kullanini
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
@AfterClass
    public static void tearDown(){
        driver.close();
}
@Test
    public void Test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1.Alert e tiklayalim
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        //aler t teki yazininin "I am a JS alert" oldugunun test edelim

String actuelAlertYazisi=driver.switchTo().alert().getText();
String expectedAlert="I am a JS Alert";
    //Ok tusuna basip alert i kapatalim
    Assert.assertEquals(expectedAlert,actuelAlertYazisi);
    driver.switchTo().alert().accept();
    }

@Test
    public void test02(){
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
    // cancel e basip cikan sonuc yazisiniin " You clicked Cancel" oldugunu test edin
    driver.switchTo().alert().dismiss();
    String actulaSonucYazisi=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
    String expectedSonucYazisi="You clicked: Cancel";
Assert.assertEquals(expectedSonucYazisi,actulaSonucYazisi);
    }

    @Test
    public void Test03() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        //3 . alert e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        //cikan prompt ekranina "Abdullah" yazdiralim ve Ok tusuna basarak alert i kapatalim

        driver.switchTo().alert().sendKeys("Efe");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
     String actualSonucYazisi=driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        System.out.println(actualSonucYazisi);
       String expectedKelime="Efe";
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
      /*  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']"))
                .getText();
        String expectedKelime= "Abdullah";
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));*/
    }
}
