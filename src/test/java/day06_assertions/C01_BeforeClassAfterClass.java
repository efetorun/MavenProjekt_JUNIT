package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {
//3 ayri test methodu olusturun
    //1.Method amazon a gidip amazona gittigimizi test edin
    //2.method da amazonda nutella aratip sonuclarin nutella icerdiginin test edin
    //3.method da nutella arama sonuc sayisinin 50 den fazla oldugunun test edin
   static WebDriver driver;
   @BeforeClass
   //@Beforeclass ve @Afterclass notasyonu kullanan methodlar static olmak zorundadir
    public static void setup(){
       WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

   @AfterClass
   public static void  teardown(){
       driver.close();
   }


    @Test
    public  void test1(){
        //1.Method amazon a gidip amazona gittigimizi test edin
       driver.navigate().to("https://www.amazon.com/");
       String expectedKelime="Amazon";
       String aktuellTitle= driver.getTitle();

       if (aktuellTitle.contains(expectedKelime)){
           System.out.println("Amazon gidis testi PASSED");
       }else {
           System.out.println("Amazon gidis testi FAILED");
       }


    }

    @Test
    public void test2(){
        //2.method da amazonda nutella aratip sonuclarin nutella icerdiginin test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedKelime="Nutella";
      WebElement  sonucYazisi=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
  String sonucYazisiStr=sonucYazisi.getText();
  if (sonucYazisiStr.contains(expectedKelime)){
      System.out.println("Test PASSED");
  }else {
      System.out.println("Test FAILED");
  }
    }

    @Test
    public  void test3(){
        // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        String sonucYazisiStr=sonucYaziElementi.getText();
        String[] sonucYazisiArr= sonucYazisiStr.split(" ");
        String sonucAdediStr=sonucYazisiArr[2]; // "74"
        int actualSonucAdediInt= Integer.parseInt(sonucAdediStr);

        int expectedAramaSonucusayisi= 50;
        if (actualSonucAdediInt>expectedAramaSonucusayisi){
            System.out.println("Nutella arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Nutella arama sonuc sayisi testi FAILED");
        }
    }


}
