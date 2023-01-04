package day12_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
@Test
    public void test01(){
    //1. “https://demoqa.com/webtables” sayfasina gidin
    driver.get("https://demoqa.com/webtables");
    // 2. Headers da bulunan basliklari yazdirin
    WebElement headerElementi=driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
    System.out.println(headerElementi.getText());
    // 3. 3.sutunun basligini yazdirin
    List<WebElement> ilkSatirlarListesi=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
    System.out.println("///////////////////////////////");
    System.out.println(ilkSatirlarListesi.get(2).getText());
    // 4. Tablodaki tum datalari yazdirin
   WebElement tumData=driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]"));
    System.out.println(tumData.getText());
    System.out.println("====================");
    List<WebElement>tumDataList=driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]"));
    for (WebElement eachList:tumDataList
         ) {
        System.out.println(eachList.getText());

    }
    // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    int sirano=1;
    List<WebElement>tumDatalar=driver.findElements(By.xpath("//div[@class=\"rt-td\"]"));
    for (WebElement eachList:tumDatalar
    ) { if (!(eachList.getText().equals("")||eachList.getText().equals(" "))){
        System.out.println(sirano + "- "+eachList.getText());
        sirano++;}
    }
    // 6. Tablodaki satir sayisini yazdirin
  List<WebElement>satirElementleriListesi=driver.findElements(By.xpath("//div[@class=\"rt-tr-group\"]"));
    System.out.println("Satir sayisi : " + satirElementleriListesi.size());
    // 7. Tablodaki sutun sayisini yazdirin
    System.out.println("Sutun Sayisi : " + ilkSatirlarListesi.size());
    // 8. Tablodaki 3.kolonu yazdirin

    // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin


}
}
