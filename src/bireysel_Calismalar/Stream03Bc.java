package bireysel_Calismalar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Stream03IntegerBc {

    public static void main(String[] args) {


        List<Integer> liste = new ArrayList<>();


        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(-2);
        liste.add(4);
        liste.add(12);
        liste.add(-1);
        liste.add(15);
        liste.add(500);
        liste.add(-15);

        System.out.println(tekKareSiraliListele(liste));

    }

    //**************************************************************************************
    // ORNEK7: Bir listedeki en büyük sayıyı döndüren metotu tanımlayınız.
    //**************************************************************************************







    public static List<Integer> tekKareSiraliListele(List<Integer> liste) {
      return  liste.
              stream().
              filter(x -> x % 2 != 0).
              sorted().
              map(x-> x*x).
              distinct().
              collect(Collectors.toList());

    }
}
