package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_IstenenElementScreenshot extends TestBase {
@Test
    public void test01() throws IOException {
    driver.get("https://www.amazon.com/");
    // Nutella Aratin
    WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    //Arama sonuclarinin Nutella icerdigini test edin
    WebElement aramaSonuclariYazisi= driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
    String actualSonucYazisi=aramaSonuclariYazisi.getText();
    String expectedSonucYazisi="Nutella";
    Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
    //Sonuclar text elementinin  ScreenShot'ini alin

   ReusableMethods.elementSS(aramaSonuclariYazisi);



}


}
