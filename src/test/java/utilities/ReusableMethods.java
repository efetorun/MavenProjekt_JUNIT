package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
public static void wait(int saniye){

    try {
        Thread.sleep(saniye*1000);
    } catch (InterruptedException e) {

    }


}

    public static void screenShot(WebDriver driver) throws IOException {
        // 1_ TakeScrennshot objesi olustur
        TakesScreenshot tss=(TakesScreenshot) driver;
        // 2_  resmi son olarak kaydedecegimiz dosyayi olustur
        // her resim cektiginde ustuste kaydetmemesi icin
        //resim dosya yoluna tarih ve saat iceren bir ek yapalim
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);
        String dosyaYolu="target\\ekranResimleri\\tumEkranSS" +tarih + ".jpeg";
        File tumSayfaShot=new File(dosyaYolu);
        //3_ tss objesi kullanarak ekran goruntusunun alip gecici dosya ya kaydet
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        //4_ gecici dosyayi ana dosyaya kopyala
        FileUtils.copyFile(geciciDosya,tumSayfaShot);



}

    public static void elementSS(WebElement element) throws IOException {
        //1- Elementi Locate et

        //2- kaydedecegimiz dosyayi olustur
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);
        File elementSS=new File("target//ekranResimleri//elementSS"+tarih+".jpeg");

        //3- gecici dosyayi olusturup , element uzerinden screenshot yapalim

        File gecici= element.getScreenshotAs(OutputType.FILE);

        ////4_ gecici dosyayi ana dosyaya kopyala
        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {

        }

FileUtils.copyFile(gecici,elementSS);


    }
}
