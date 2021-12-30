package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda04 {

    public static void main(String[] args) {

        // Listedeki tekrarli elemanlari silip farkli olup tek sayi olanlarin kuplerini alan bir method olusturun..

        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        farklitekSayiKup(l);

    }

    public static void farklitekSayiKup(List<Integer> l) {
        l.stream().distinct().filter(t->t%2==1).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
        // 729 2197 3375
    }
}
