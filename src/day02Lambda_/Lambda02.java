package day02Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda02 {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(7, 12, 14, 4, 9, 2, 4, 12, 16));

        ilkDortEleman(l);
        System.out.println();
        ilkDortElemanGec(l);
        System.out.println();
        ucElamanYazdir(l);
    }

    // 1) küçükten büyüğe sırala sonra ilk 4 elemanı yazdır
    public static void ilkDortEleman(List<Integer> l) {
        l.stream().sorted().limit(4).forEach(methodLambda01::bosluklaYazdir); // 2 4 4 7
    }

    // 2) küçükten büyüğe sırala ilk 4 elemanı atla
    public static void ilkDortElemanGec(List<Integer> l) {
        l.stream().sorted().skip(4).forEach(methodLambda01::bosluklaYazdir); // 9 12 12 14 16
    }

    // 3) Kucukten Buyuge sirali 4,5 ve 6. sirayi yazidrin...

    private static void ucElamanYazdir(List<Integer> l) {
        l.stream().sorted().skip(3).forEach(methodLambda01::bosluklaYazdir); // 7 9 12 12 14 16
        System.out.println();
        l.stream().sorted().limit(6).skip(3).forEach(methodLambda01::bosluklaYazdir); // 7 9 12
        // 2. l de soyle yaptik...
        // sorted dan sonra bize 4 5 ve 6. elaman lazim oldugu icin limit ile ilk 6 yi cagirip skip ile son 3 u alip yazdirdik..

    }
}