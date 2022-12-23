package day05_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    // 3 farkli test methodu olusturun
    //her bir methodun basinda driver i olusturup
    //1- amazon.com
    //2-wiseQuarter.com
    //3-Youtube.com a gidip
    //title lari yazdirin ve methoddan sonra driver i kapatin
WebDriver driver;
@Before
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    System.out.println("setup calisti");
}

@After
    public void tearDown(){
    driver.close();
    System.out.println("teardown calisti");
    }

    @Test
    public void test1() throws InterruptedException {
    driver.navigate().to("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }
    @Test
    public void test2() throws InterruptedException {
driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }



}
