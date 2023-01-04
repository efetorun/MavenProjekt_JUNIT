package day12_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {
@Test
    public void test01() throws IOException {
    //ulkeler excelindeki sayfa 1 e gidecek sekilde ayarlar yapalim

    String dosyaYolu="C:\\Users\\Asus\\Desktop\\ulkeler.xlsx";

    FileInputStream fis=new FileInputStream(dosyaYolu);

    Workbook workbook= WorkbookFactory.create(fis);
    Sheet sheet=workbook.getSheet("Sayfa1");

    //       - 1.satirdaki 2.hucreye gidelim ve yazdiralim
    System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));
    //       - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    String isteneHucreStr=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
    System.out.println(isteneHucreStr);
    //       - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
    String actualBaskent=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
    String expectedBaskent="Kabil";
    Assert.assertEquals(expectedBaskent,actualBaskent);
    //       - Satir sayisini bulalim
    System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);
    //       - Fiziki olarak kullanilan satir sayisini bulun
    //Bunuun icin sayfa 2 deki son satir indexinin ve fiziki kullanilan satir sayisini yazalim
    System.out.println("2. sayfa son satir index i : " + workbook.getSheet("Sayfa2").getLastRowNum());
    System.out.println("2.sayfa fiziki kullanilan satir sayisi : "+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
    //       - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    // Ulke isimi ingilizce Key geriye kalan 3 bilgi ise birlestirilerek value olsunb

    Map<String,String> ulkelerMap=new TreeMap<>();
    int sonsatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
    String key="";
    String value="";
    for (int i = 0; i <=sonsatirIndexi ; i++) {
        key=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "+
            workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "+
            workbook.getSheet("Sayfa1").getRow(i).getCell(3)  .toString();
        ulkelerMap.put(key,value);
    }
    System.out.println(ulkelerMap);


}


}
