package day12_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {


@Test
    public void test01() throws IOException {
    //Dosya yolunu olusturalim
    String dosyaYolu="C:\\Users\\Asus\\Desktop\\ulkeler.xlsx";
    //File input Stream olusturup parametre olarak dosya yolunu yazalim
    FileInputStream fis=new FileInputStream(dosyaYolu);
    //Kod alanimizda excel in bir kopyasini olusturup
    //tum bilgileri ona kopyalayalim

    Workbook workBook= WorkbookFactory.create(fis);

    //Workbook icerisinde birden fazla sayfa olabilir
    //istedigimiz sayfaya gidelim


    Sheet sheet= workBook.getSheet("Sayfa1");

    //Angola yazdirmak istedigimiz icin besinci satira gidelim

    Row row=sheet.getRow(5);

    //5.satirdan 2.index deki datayi alalim

    Cell cell=row.getCell(2);

    System.out.println(cell);




}




}
