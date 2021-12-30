package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda06 {

    public static void main(String[] args) {

        // Listedeki tekrarlı elemanları silip çift sayı olanların küplerinin çarpımını yazdıran metod oluştur


        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        CiftSayiKupCarpimi(l);

    }

    public static void CiftSayiKupCarpimi(List<Integer> l) {

        System.out.println(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (x, y) -> x * y));
        // 1404928
    }
}

