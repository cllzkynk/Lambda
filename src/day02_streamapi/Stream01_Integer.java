package day02_streamapi;

import java.util.ArrayList;
import java.util.List;

public class Stream01_Integer {

    public static void main(String[] args) {

        List<Integer> rakamlar = new ArrayList<>();

        rakamlar.add(-2);
        rakamlar.add(-1);
        rakamlar.add(0);
        rakamlar.add(1);
        rakamlar.add(2);
        rakamlar.add(1); // Tekrarlida mevcut.
        rakamlar.add(2);
        rakamlar.add(3);
        rakamlar.add(4);
        rakamlar.add(5);
        rakamlar.add(6);
        rakamlar.add(7);
        rakamlar.add(8);
        rakamlar.add(9);
        System.out.println("Liste : " + rakamlar);
        // Method cagirma olunca t'ye gerek yok fakat Klasik kullanim yaoarsam ;
        rakamlar.stream().filter(t -> t%2 != 0).forEach(t -> System.out.print(t + " "));

        System.out.println("");

        rakamlar.stream().filter(t -> t%2 != 0).forEach(System.out :: print);
        // Method referansi ile bunlari sadece yan yana yazdirabilirim fakat burada method olusturmadan yapamam
        // Burada aralarina bosluk koyamadim cunku method referans'da boyle bir secegim yok.
        // Bunun icin soyle bir yol izlemem gerekiyor.
        System.out.println("METHOD REFERANS KISMI");
        rakamlar.stream().filter(t -> t%2 != 0).forEach(Stream01_Integer :: yazdir);

        System.out.println("FILTERI DEGISTIRMEK");
        rakamlar.stream().filter(Stream01_Integer::tekMi).forEach(Stream01_Integer :: yazdir);
    }
    public static void yazdir(int t) {
        System.out.print(t+" "); // Bu sekilde olunca Method referans ile bosluklu yazdirmis oluyorum.
    }

    public static boolean tekMi (int x) {
        return x%2!=0;
    }
}
