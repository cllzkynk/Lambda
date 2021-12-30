package day03_streamapi;

import java.util.ArrayList;
import java.util.List;

public class Stream01_Integer {

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        tekKareYazdir(liste);

    }

    public static void tekKareYazdir(List<Integer> l) {
        l.stream().filter(Stream01_Integer::tekMi).map(x->x*x).forEach(Stream01_Integer::yazdir);
        // 81 169 81 225 tekrarli halide var . Peki tekrarsiz nasil yazacagim ?
        // distinct method'unu kullanarak yapacagim .
        System.out.println("\n MAP'IN ONCESINDE DISCINT");
        l.stream().filter(Stream01_Integer::tekMi).distinct().map(x->x*x).forEach(Stream01_Integer::yazdir);
        System.out.println("\n MAP'IN SONRASINDA DISCINT");
        l.stream().filter(Stream01_Integer::tekMi).map(x->x*x).distinct().forEach(Stream01_Integer::yazdir);
        // distinct'i nereye koydugunun ne onemi var ? Hangi asamada ayristirman gerekiyorsa oraya distinct yazmalisin.
        // Burada distinct stream yaptiktan, filter yaptiktan, karesini aldiktan sonra ayristirma yapiyor.
        System.out.println("\n FILTER ONCESINDE DISCINT");
        l.stream().distinct().filter(Stream01_Integer::tekMi).map(x->x*x).forEach(Stream01_Integer::yazdir);
        // Burada ise stream yaptiktan sonra distinct yaptik yani her yerde oluyor fakat ne zaman kullancagini
        // yazdigin programa gore belirle.
    }
    public static boolean tekMi(int x){
        return x % 2 != 0;
    }
    public static boolean ciftMi(int x){
        return x%2==0;
    }
    public static void yazdir(int x){
        System.out.print( x + " ");
    }
}
