package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda02 {

    public static void main(String[] args) {

        // 2)List in elemanlarından ÇİFT olanları aralarında boşluk bırakarak yazdıran metod oluştur(Structured)

        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        ciftSayiJava(l);
        System.out.println();
        ciftSayilambda(l);

    }

    // Lambda (fonctional) yoluyla

    public static void ciftSayilambda(List<Integer> l) {

        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " ")); // 14 4 2 4 14
    }

    // java yoluyla
    public static void ciftSayiJava(List<Integer> l) {
        for (Integer w : l) {
            if (w % 2 == 0) {
                System.out.print(w + " "); // 14 4 2 4 14
            }
        }
    }
}