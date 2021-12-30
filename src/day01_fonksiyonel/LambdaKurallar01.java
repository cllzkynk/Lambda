package day01_fonksiyonel;

import java.util.Arrays;
import java.util.List;

public class LambdaKurallar01 {
    public static void main(String[] args) {

        List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
        liste.forEach( x -> System.out.println(x));

        // Liste => C  forEach => HOF

        System.out.println("================================");
        // Listenin elemanlarini 2 arttirarak yazdiralim.
        liste.forEach( t -> System.out.println(t + 2));

        System.out.println("\n SUSLU PARANTEZ KULLANIM YERI");
        // Listenin elemanlarini 2 arttirarak yazdiralim.

        // Expression'larimiz birden fazla ise suslu parantez icinde yazmak zorundayiz.
        liste.forEach( t -> {
                int miktar = 2; // 1. EXPRESSION
                System.out.print(t+ miktar + " "); // 2. EXPRESSION
        } );

       /*
       (int x, int y) -> {return x+y;}   Buna "explicit" denir.
       x -> x * x                        Buna "implicit" denir. x'de int double String yazmiyor nasil anlayacagiz ?
        Yazdigimiz koda gore kendisi anliyor.
        */

        System.out.println("\n EXPLICIT ORNEGI");
        liste.forEach((Integer x) -> System.out.print(x*2+" "));

        System.out.println("DISARDAN BIR DEGISKEN TANIMLAYALIM");
        // Bir dis degisken kullanalim ve elemanlar ile isleme sokalim
        int deger = 5;
        liste.forEach(x -> System.out.print(x+deger+" ")); //

        // liste.forEach(x -> System.out.print(deger++));
        // Disardaki deger'i foreachloop icerisinde yeniden bir atama yapamiyorum
        System.out.println("\n Deger : "+deger);

        System.out.println(" \n \n FOR EACH LOOP ICERISINDE METHOD CAGIRMA YONTEMI");
        // Method referansi =>  Class Adi :: Method Adi   ==> Boyle yazinca bir class icindeki method'u yazdirabiliyoruz
        // Method'un cagirilmasinin bir yontemidir.
        liste.forEach(System.out :: print); // System.out Class'indan println method'unu cagirdim.
        System.out.println("");
        liste.forEach(LambdaKurallar01 :: yazdir);

        }
    // preferences aramaya proofreading'leri kapatiyoruz
    public static void yazdir(int x) {
            System.out.println("BU CLASS'DAKI YAZDIR METHOD'U CALISTI ve x degerleri : " + x);
        }

}
