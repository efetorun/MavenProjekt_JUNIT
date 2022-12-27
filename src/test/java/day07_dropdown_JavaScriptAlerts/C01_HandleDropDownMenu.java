package day07_dropdown_JavaScriptAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropDownMenu {
WebDriver driver;
    @Test
    public void Test01() throws InterruptedException {
    //ilgili ayarlöari yapipi amzon ana sayfaya gidin
    //arama kutusu yanindaki drop down menuden book secin
    //arama kutusuna java yazdirip aramayi yapin
    //title in book ve java icerdiginin test edin
     driver.get("https://www.amazon.com/");
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]"));


     Select select=new Select(dropdownElementi);
     select.selectByValue("search-alias=stripbooks-intl-ship");
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        String expectedkelime="Java";
        Assert.assertTrue(driver.getTitle().contains(expectedkelime));
       dropdownElementi=driver.findElement(By.xpath("//select[@aria-describedby=\"searchDropdownDescription\"]"));
         select=new Select(dropdownElementi);
        select.selectByValue("search-alias=stripbooks-intl-ship");
        String actualSecilenOption=select.getFirstSelectedOption().getText();
        String expectedSecilenOption="Books";
        Assert.assertEquals(expectedSecilenOption,actualSecilenOption);

        //Dropdown menudeki secenek sayisinin 28 oldugunu test edin

        List<WebElement> optionsWebElementListesi=select.getOptions();
        int actualOptionSayisi=optionsWebElementListesi.size();
        Assert.assertTrue(actualOptionSayisi==28);

}
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
@After
    public void tearDown(){
        driver.close();
}
}
