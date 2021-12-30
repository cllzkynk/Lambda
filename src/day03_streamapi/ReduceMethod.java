package day03_streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceMethod {

    public static void main(String[] args) {
        // ORNEK : Bir listeyi parametre olarak alan ve listedeki tek sayilarin karelerinin toplamini hesaplayan method'u yaziniz.

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
        System.out.println("TOPLAM : " + tekKupToplami(liste));
        System.out.println("TOPLAM : " + tekKupToplami2(liste));
        System.out.println("TOPLAM : " + tekKupToplami3(liste));
    }

   public static int tekKupToplami(List<Integer> l) {
        return l.stream().filter(Stream01_Integer::tekMi).map(x->x*x*x).reduce(0,(x,y)-> (x+y)); // 7030
        // Stream01_Integer::tekMi diger class'daki method'u cagirdim bununla.
        // reduce(identity: 0, (x,y)-> (x+y)) nedir ?

   }
    public static Optional<Integer> tekKupToplami2(List<Integer> l) {
        return l.stream().filter(Stream01_Integer::tekMi).map(x->x*x*x).reduce(Math::addExact); // 7030
        // Hata veriyor ustune geldim Optional<Integer> yapti

    }
    public static int tekKupToplami3(List<Integer> l) {
      //  return l.stream().filter(Stream01_Integer::tekMi).map(x->x*x*x).reduce(0); // 703

        return l.stream().filter(Stream01_Integer::tekMi).map(x->x*x*x).reduce(0,(x,y)-> (x+y)); // 7030
    }



}

