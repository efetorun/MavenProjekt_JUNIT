package day09_actions;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FormDoldurma extends TestBase {
@Test
    public void test01(){
    //facebook.com a git

    //iligili alanlari faker kutuphanesineden degerlerle doldur
    //kaydol butonunba basin
    //kayit olamadiginizi test et
    driver.get("https://www.facebook.com/");
  driver.findElement(By.xpath("//button[@class=\"_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy\"]")).click();
  //yeni hesap olustur
driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
//iligili yerleri faker dan dldur
    WebElement firstnameKutusu=driver.findElement(By.name("firstname"));
    Actions actions=new Actions(driver);
    Faker faker=new Faker();
    String mailAdresi=faker.internet().emailAddress();
    actions.click(firstnameKutusu)
            .sendKeys(faker.name().firstName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.name().lastName())
            .sendKeys(Keys.TAB)
            .sendKeys(mailAdresi)
            .sendKeys(Keys.TAB)
            .sendKeys(mailAdresi)
            .sendKeys(Keys.TAB)
            .sendKeys(faker.internet().password())
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys("23")
            .sendKeys(Keys.TAB)
            .sendKeys("Oct")
            .sendKeys(Keys.TAB)
            .sendKeys("1990")
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ARROW_RIGHT).perform();
    // kaydol butonuna basin
    WebElement signupButonu= driver.findElement(By.name("websubmit"));
    signupButonu.click();
    // Kayit olamadiginizi test edin
}
}
