package Parktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
/*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//button[@id=\"W0wltc\"]")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Brave Heart"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@ id=\"result-stats\"]")).getText());
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
      //  driver.findElement(By.xpath("//button[@id=\"W0wltc\"]")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("The Lord of the Rings"+Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@ id=\"result-stats\"]")).getText());
    }
    @Test
    public void test03() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(2000);
      //  driver.findElement(By.xpath("//button[@id=\"W0wltc\"]")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Harry Potter"+Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@ id=\"result-stats\"]")).getText());
    }



}
