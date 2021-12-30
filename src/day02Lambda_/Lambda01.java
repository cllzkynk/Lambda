package day02Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

            // Method Reference'da bizim oluşturduğumuz metodları veya Java metodlarını kullanırız.
            // Method Reference Syntax ı ==> ClassName::MethodName
            // System.out.println();  ==  System.out::println;

            List<Integer> l= new ArrayList<Integer>(Arrays.asList(15,14,9,13,4,9,2,4,14,6));

            elemanYazdir(l);
            System.out.println();
            ciftSayiYazdir(l);
            System.out.println();
            tekSayiKare(l);
            System.out.println();
            tekSayiKupTekrarsiz(l);
            System.out.println();
            farkliCiftSayiKareToplam(l);
            System.out.println();
            farkliCiftSayiKupCarpim(l);
            System.out.println();
            System.out.println(farkliTersSirala(l));
            System.out.println();
            maxDeger(l);

        }



    // 1) List in elemanlarını aralarında boşluk bırakarak yanyana yazdır.(Method Reference- kendi metodumuz)
        public static void elemanYazdir(List<Integer> l) {
            l.stream().forEach(methodLambda01::bosluklaYazdir); // 15,14,9,13,4,9,2,4,14
            // l.stream().forEach(System.out::print); java nın metodu.. bu sekilde de yapabiliriz...

        }
        // 2) List in elemanlarından çift olanları aralarında boşluk bırakarak yanyana yazdır..(Method Reference)
        public static void ciftSayiYazdir(List<Integer> l) {
            l.stream().filter(methodLambda01::ciftMi).forEach(methodLambda01::bosluklaYazdir); // 14 4 2 4 14 6
        }
        // 3) List teki tek sayıların karelerini alıp aralarında boşluk bırakarak yanyana yazdır
        public static void tekSayiKare(List<Integer> l) {
            l.stream().filter(methodLambda01::tekMi).map(methodLambda01::kareAl).forEach(methodLambda01::bosluklaYazdir); // 225 81 169 81
        }
        // 4) List teki tekrarlı olanları silip tek sayıların küplerini alıp aralarında boşluk bırakarak yanyana yazdır.
        public static void tekSayiKupTekrarsiz(List<Integer> l) {
            l.stream().distinct().filter(methodLambda01::tekMi).map(methodLambda01::kupAl).forEach(methodLambda01::bosluklaYazdir); // 3375 729 2197
        }
        // 5) Farklı çift sayıların karelerinin toplamını yazdır (Use Method Reference)
        public static void farkliCiftSayiKareToplam(List<Integer> l) {
            int num=  l.stream().distinct().filter(methodLambda01::ciftMi).map(methodLambda01::kareAl).reduce(0,Math::addExact);
            System.out.println(num); // 252
        }
        // 6) Farklı çift sayıların küplerinin çarpımını yazdır .(Use Method Reference)
        public static void farkliCiftSayiKupCarpim(List<Integer> l) {
            System.out.println(l.stream().distinct().filter(methodLambda01::ciftMi).map(methodLambda01::kupAl).reduce(1, Math::multiplyExact));
            // 303464448
        }
        // 7) List teki farklı ve 5 ten büyük ve çift elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.
        public static List farkliTersSirala(List<Integer> l) {
            return    l.stream().distinct().filter(t->t>5 && t%2==0).map(t->t/2).sorted(Comparator.reverseOrder()).collect(Collectors.toList()); // [7, 3]
        }

        // 8) listte ki en buyuk elemani bul...
        public static void maxDeger(List<Integer> l) {
            System.out.println(l.stream().reduce(Integer.MAX_VALUE, Math::max));
            System.out.println();
            System.out.println(l.stream().reduce(Integer.MIN_VALUE, Math::min));

            l.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(methodLambda01::bosluklaYazdir); // 15 (max)
            // sorted(Comparator.reverseOrder()) buyukten kucuge sirala..
            l.stream().sorted().limit(1).forEach(methodLambda01::bosluklaYazdir); // 15 2
            // ( en buyuk ve en kucugu yanyana yazdirdi)


    }

    }

