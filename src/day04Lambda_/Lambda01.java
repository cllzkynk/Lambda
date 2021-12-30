package day04Lambda_;

import java.util.stream.IntStream;

public class Lambda01 {

    public static void main(String[] args) {

        // 1- 1 den 20 ye kadar olan sayilari yazdiriniz...

        IntStream.rangeClosed(1,20).forEach(methodLambda03::bosluklaYazdir);
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

        System.out.println();

        // 2- functional programlamayi kullanarak 3 den 98 e kadar olan cift tam sayilarin toplamini bulunuz...
        // 1. yol
        System.out.println(IntStream.rangeClosed(3, 98).filter(t -> t % 2 == 0).sum()); // 2448
        // 2. yol
        System.out.println(IntStream.rangeClosed(3, 98).filter(methodLambda03::ciftMi).reduce(0, Integer::sum)); // 2448

        // 3-functional programming kullanarak 9! i bulunuz... (9!=1*2*3...*9)

        System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact)); // 362880

        // 4- Ilk 7 çift sayma sayisinin carpimini bulunuz... (2,4,6,8,10,12,14)
        // 1. yol
        System.out.println(IntStream.rangeClosed(2, 14).filter(methodLambda03::ciftMi).reduce(1, Math::multiplyExact)); // 645120
        // 2. yol
        System.out.println(IntStream.rangeClosed(1, 20).filter(t->t%2==0).limit(7).reduce(1, Math::multiplyExact)); // 645120

        // 5- 6'dan büyük ilk 150 tek sayma sayisinin toplamini bulunuz... ==> 7, 9, 11, 13, 15, 17, 19
        System.out.println(IntStream.iterate(7, t -> t + 2).limit(150).sum()); // 23400

        // 6- Ilk 23 tek sayma sayisinin toplamini bulunuz...
        System.out.println(IntStream.iterate(1, t -> t + 2).limit(23).sum()); // 529

        // 7- Ilk 23 cift sayma sayisinin toplamini bulunuz...
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(23).sum()); // 552

        // 8- (11 den 33 e kadar her tam sayinin rakamlarinni hesaplamak icin bir method olusturunuz...
        IntStream.rangeClosed(11,33).map(methodLambda03::rakamlarToplami).forEach(methodLambda03::bosluklaYazdir);
        // 2 3 4 5 6 7 8 9 10 2 3 4 5 6 7 8 9 10 11 3 4 5 6




    }

}

