package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownTest extends TestBase {

@Test
    public void test01(){
   /*
   1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
2. https://the-internet.herokuapp.com/download adresine gidelim.
3. logo.png dosyasını indirelim
    4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    */
driver.get("https://the-internet.herokuapp.com/download");
driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();
    ReusableMethods.wait(3000);
//4. Dosyanın başarıyla indirilip indirilmediğini test edelim

    //oncelikle dinamik dosyayolöu olusturmaliyiz

    String dosyaYolu=System.getProperty("user.home") + "\\Downloads\\Facebookd.png";
    //Bir dosyanin bilgisayarimizda var oldugunu yani exist test etmek icin 'Java daki Files
    //Classs indan yardim alacagiz

    Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

}
@Test
    public void  test02(){
    //Masaustunde "MerhabaJava.docx dosyasi oldugunu test edin

    String dinamikDosyaYolu=System.getProperty("user.home") + "\\Desktop\\MerhabaJava.docx";
    Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
}
}
