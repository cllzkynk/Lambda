package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        //1) list in elemanlarını yanyana yazdır (java- structured)

        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));
        yazdirJava(l);
        System.out.println();
        yazdirLambda(l);

    }

    public static void yazdirJava(List<Integer> list) {
        for (Integer w : list) {
            System.out.print(w + " "); // 14 9 13 4 9 2 4 14 15

        }
    }

    //lambda (functional)
    public static void yazdirLambda(List<Integer> l) {
        l.stream().forEach(t -> System.out.print(t + " ")); // 14 9 13 4 9 2 4 14 15
    }
}