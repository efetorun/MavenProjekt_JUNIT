package day11_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {
/*
1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
  Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
 */
protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){

        driver.quit();
    }

@Test
    public void implicitWaittest(){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
     */
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    driver.findElement(By.xpath("//button[text()='Remove']")).click();
    WebElement itsGone= driver.findElement(By.xpath("//p[@id='message']"));
    Assert.assertTrue(itsGone.isDisplayed());
    driver.findElement(By.xpath("//button[text()='Add']")).click();
    WebElement itsBack= driver.findElement(By.xpath("//p[@id='message']"));
    Assert.assertTrue(itsBack.isDisplayed());
}
    @Test
    public void explicitWaittest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //ExplicitlyWait icin once wait objesi olusturalim

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        // Bundan sonraki adimi belirlerken
        //islem yapmak istedigimiz elementin Locate edilebilir olup olmadigi önemlidir
        //Eger Locate edilebilirse once Locate edip sonra Wait objesi ile o web Element
        //Bekletilebilir

        //Locate edilemioyorsa wait objesine beklenme emri locater olarak verilebilir

        WebElement itsGone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //Locate ederken hemde Explicitlywait yapiyoruz
        //WebElement itsGone= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGone.isDisplayed());
      // 6. Add buttonuna basin
        //7. It’s back mesajinin gorundugunu test edin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        WebElement itsBackElemti=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackElemti.isDisplayed());
    }
}
