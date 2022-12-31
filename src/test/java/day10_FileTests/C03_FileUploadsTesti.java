package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadsTesti extends TestBase {
@Test
    public void test01(){


   // 1.https://the-internet.herokuapp.com/upload adresine gidelim
    driver.get("https://the-internet.herokuapp.com/upload");
  //  2.chooseFile butonuna basalim
    WebElement chooseFileButonu=driver.findElement(By.xpath("//*[@id='file-upload']"));
    String dosyaYolu=System.getProperty("user.home") +"\\Desktop\\MerhabaJava.docx";
    chooseFileButonu.sendKeys(dosyaYolu);
    ReusableMethods.wait(8000);

    /*
    Bu görevi yapabilmek micin
    Choose file butonuna basildiginda
    bilgisayarimizdaki file dosyalarinin click yapabilmemiz gerekir
    ancak selenium bilgisayarimizdaki dosayalari click yapamaz

    bunun yerine soyle bir cozum uretilmistir

    1 Choose file buitonunu locate edin
    2 Upload edilecek dosyanin dosya yolunu olusturun
    3. chooseFile butonuna SendKeys ile dosyayolunu gönderin
     */
//3.Yuklemek istediginiz dosyayi secelim.
//4.Upload butonuna basalim.
    driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
//5.“File Uploaded!” textinin goruntulendigini test edelim.
WebElement fileUploadedElementi=driver.findElement(By.tagName("h3"));
    Assert.assertTrue(fileUploadedElementi.isDisplayed());



}



}
