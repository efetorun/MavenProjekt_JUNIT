package day13_writeExcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JavaScriptExecutorClick extends TestBase {

@Test
    public void test01(){

    //amazon sayfaya gidin
    driver.get("https://www.amazon.com/");
    //sell linkine JS executor kullanarak click yapin
    WebElement sellLink= driver.findElement(By.xpath("//a[@data-csa-c-content-id=\"nav_cs_sell\"]"));
    //JavaScriptExecutor ile click yapmak icin
    JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
    jsExecutor.executeScript("arguments[0].click();",sellLink);



}



}
