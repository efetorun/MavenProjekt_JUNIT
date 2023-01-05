package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

@Test
    public void test01() throws IOException {


    //Excel dosyalari bilogisayarimizda oldugu icin
    //Java dan FileInputStream class i yardimiyla ulasacagiz

    String dosyaYolu="C:\\Users\\Asus\\Desktop\\ulkeler.xlsx";

    FileInputStream fis= new FileInputStream(dosyaYolu);

    Workbook workbook= WorkbookFactory.create(fis);

    System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

    //Satir ve Sütun bilgisini parametere olarak alip
    // o hücredeki bilgiyi yazdiran bir method olusturun

    excelBilgiGetirmemethodu("Sayfa1",2,2);
}

    public void excelBilgiGetirmemethodu(String sayfa , int rowSatir, int cellSutun) throws IOException {
        String dosyaYolu="C:\\Users\\Asus\\Desktop\\ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet(sayfa).getRow(rowSatir).getCell(cellSutun));
    }

}
