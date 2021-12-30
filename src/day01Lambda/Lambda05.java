package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda05 {
    public static void main(String[] args) {
        
        // Listedeki tekrarli elemanlari silip cift sayi olanlarin karelerini toplayan bir method olusturun..

        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        CiftSayiKareToplam(l);
    }

    public static void CiftSayiKareToplam(List<Integer> l) {
        System.out.print(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y));
        // 216

        // 2. yol ile yazdirma...
        // int sayi=l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y);
        // System.out.println(sayi); // 216
    }
}
