package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_assertions {

/*
Junit framework da raporlamanin dogru olmasi icin Testlerin Assert class indaki hazir methodlar la yapilmasi gerekir

Eger Assert classs kullanilmazsa
Junit kodlarin sorunsuz olarak calisip bittigini raporlar
C01 de testleri if else ile yaptigimiz icin
Tesler Failed olsa da kodlar sorunsuz calistigi icin
testler yesil tik olarak isaretlendi
 */
int P1yas1=60;
int P2yas2=66;
int P3yas3=70;


    @Test
public void test01(){
 //emekli yasi 65 olduguna göre yas P2 nin emekli olabilecegini test ediniz
        Assert.assertTrue(P2yas2>65);
    }

    @Test
    public void test02(){
        //emekli yasi 65 olduguna göre
        //P1 in emekli olamayacaginin test edin
        Assert.assertFalse(P1yas1>65);
    }
    @Test
    public void test03(){
        //emekli yasi 65 olduguna göre
        //P3 in emekli olamayacaginin test edin
        Assert.assertFalse("Girilen Yas 65 den kücük olmadigindan emekli olabilir",P3yas3>65);
    }

}
