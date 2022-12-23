package day05_JUnitFrameWork;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

    @Test
    public void test01(){
        System.out.println("Test01 calisti");
        //test notasyonu sayesinde her bbir test methodu
        //bagimsiz olarak calisabilir
        //eger testin icinde herhangi bir assertion iddia yoksa
        //kod problemsiz calisip bittiginde
        //Junit test passed olarak raporlar
    }
    @Test @Ignore
    public void test02(){
        System.out.println("Test02 calisti");
        //@Ignore notasyonu yazildigi test methodunun calistirilmamasini saglar
    }
    @Test
    public void test03(){
        System.out.println("Test03 calisti");
    }

}
