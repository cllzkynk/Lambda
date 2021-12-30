package day01Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03 {

    public static void main(String[] args) {

        // Listteki tek sayilarin karelerini yzdiran method olusturun...
        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        tekSayilarinKaresi(l);

    }

    public static void tekSayilarinKaresi(List<Integer> l) {
        l.stream().filter(t->t%2==1).map(t->t*t).forEach(t-> System.out.print(t+" ")); // 81 169 81 225
    }

}
