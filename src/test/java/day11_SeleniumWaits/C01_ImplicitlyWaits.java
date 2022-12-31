package day11_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWaits {

@Test
    public void test01(){

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //Selenium $ e kadar 15 saniye yi belirtmek icin
    //Timeouts class indan 15 saniye tanimliyorduk
    //Selenium 4 ile birlikte zaman belirleme class i Duration oldu
}

}
