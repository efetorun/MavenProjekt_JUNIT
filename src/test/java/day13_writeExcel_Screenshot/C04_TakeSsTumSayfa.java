package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C04_TakeSsTumSayfa extends TestBase {


    @Test
    public void  test01() throws IOException {


        //wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com/");
        //ana sayfaya gittigimizi test edin
        String expectedTitle="Wise Quarter";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //tum sayfa screenshot alin
        ReusableMethods.screenShot(driver);

    }
}
