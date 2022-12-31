package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

@Test
    public void test01() throws FileNotFoundException {
    String dosyaYolu="C:\\Users\\Asus\\Desktop\\MerhabaJava.docx";
    FileInputStream fis=new FileInputStream(dosyaYolu);
    /*
    File testlerinde ngenellikle downloads a indirelecek dosyanin indirildigini test etmek
    veya masaustundeki bir dosyanin web e yuklenebioldigini test etmek isteriz

    Ancak herkesin bilgisayarinin ismi kullanici isimleri gibi farkliliklar
    olacagininndan testler tek bir bilgisayarda calisacak gibi yazilmak zorunda kalinir

    Bu karisikligin önüne gecebilmek icin Java iki basit kod blogu sunmus

     */
    System.out.println(System.getProperty("user.dir"));
    System.out.println(System.getProperty("user.home"));
    //kullanicinin temel path ini veriri.
    //

    //Masaustune gitmek istersek
    //C:\Users\Asus\Desktop\Java Projelerin devami\com.Team105JUnit+\Desktop eklememiz yeterlidir

    //Downloads a gitmek istersek
    // C:\Users\Asus\Desktop\Java Projelerin devami\com.Team105JUnit+\Downloads eklememiz yeterlidir

    //Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
    //kullanici adi gibi detaylara  takilmamasi icin
    //File testlerinde kullanilacak dosya yolunun
    //user.home.. temel path i calistigi bilkgisayardan alacak sekilde
    //olustururuz

    //dosyaYolu="C:\\Users\\Asus\\Desktop\\MerhabaJava.docx";
    String dinamikDosyaYolu=System.getProperty("user.home") + "C:\\Users\\Asus\\Desktop\\MerhabaJava.docx";




}


}
