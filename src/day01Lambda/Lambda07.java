package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda07 {
    public static void main(String[] args) {

        // List teki elemanlari alıp ters sıralayarak list olarak yazdıriniz...

        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        TersDuzSirala(l);

    }

    public static void TersDuzSirala(List<Integer> l) {
        l.stream().sorted().forEach(t-> System.out.print(t+" ")); // Sayilari kucukten buyuge siraladik
        // 2 4 4 9 9 13 14 14 15
        System.out.println();
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" ")); // Sayilari buyukten kucuge siraladik
        // 15 14 14 13 9 9 4 4 2

    }
}
