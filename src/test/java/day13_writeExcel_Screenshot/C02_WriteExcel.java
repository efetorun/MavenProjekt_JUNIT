package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
@Test
    public void test01() throws IOException {

 // Excel dosyasindan kopyaladigimiz Workkbook objesi uzerinden degisiklik yapabiliriz
    //Bunun icin once WorkBook olusturalim
    String dosyaYolu="C:\\Users\\Asus\\Desktop\\ulkeler.xlsx";
    FileInputStream fis=new FileInputStream(dosyaYolu);
    Workbook workbook= WorkbookFactory.create(fis);

// 5.Sutun olarakNufus basligi ile bir sutun olusturalim
    workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
   // 3.Satirdaki nufus bilgisini 1500000 yapalim
   workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");
// 7. Satirdaki nufus bilgisinin 3000000 yapalim
    workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");
    //yaptigimiz degisiklikler kopya workbook uzerinde
    // bu degisiklikleri excel dosyasina kaydetmek icin
    // bunu icin FileOutputStream classs inin kullanmaliyiz

    FileOutputStream fos=new FileOutputStream(dosyaYolu);
    workbook.write(fos);
    workbook.close();
    fis.close();
    fos.close();
}










}
