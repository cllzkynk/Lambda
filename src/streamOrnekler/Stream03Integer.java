package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {
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

        System.out.println("En BÃœYÃœK DEÄ�ER:" + buyukBul(liste));
        System.out.println("En BÃœYÃœK DEÄ�ER:" + buyukBul1(liste));
        System.out.println("En KÃœÃ‡ÃœK DEÄ�ER:" + kucukBul(liste));
        System.out.println("Ã‡ARPIM DEÄ�ERÄ°:" + carpimBul(liste));
        System.out.println("Eleman SayÄ±sÄ± :" + elemanSay(liste,9));
        negatifSayilariYazdir(liste);
        List<Integer> negatifler = negatifSayiListesi(liste);
        System.out.println("\nNEGATÄ°F LÄ°STE:" + negatifler);
        System.out.println("TEK SAYILARIN SIRALI KARESÄ°:" +tekKareSiraliListele(liste));
    }

    //**************************************************************************************
    // ORNEK7: Bir listedeki en bÃ¼yÃ¼k sayÄ±yÄ± dÃ¶ndÃ¼ren metotu tanÄ±mlayÄ±nÄ±z.
    //**************************************************************************************
    public static int buyukBul(List<Integer> liste){
        return liste.stream().reduce(0, (x,y)-> x >y ? x:y);
    }

    //*****************************************************************************************
    // ORNEK8: Bir listedeki en bÃ¼yÃ¼k sayÄ±yÄ± dÃ¶ndÃ¼ren metotu tanÄ±mlayÄ±nÄ±z. (METOT REFERANSI)
    //*****************************************************************************************
    public static int buyukBul1(List<Integer> liste){
        return liste.stream().reduce(0,Math::max);
    }

    //*****************************************************************************************
    // ORNEK9: Bir listedeki en bÃ¼yÃ¼k sayÄ±yÄ± SIRALAYARAK bulan ve dÃ¶ndÃ¼ren metotu tanÄ±mlayÄ±nÄ±z.
    //*****************************************************************************************
    public static int buyukBul2(List<Integer> liste){
        return liste.stream().sorted().reduce(0,(x,y)->y);
    }

    //*****************************************************************************************
    // ORNEK10: Bir listedeki en kÃ¼Ã§Ã¼k sayÄ±yÄ± bulan ve dÃ¶ndÃ¼ren metotu tanÄ±mlayÄ±nÄ±z.
    //*****************************************************************************************
    public static int kucukBul(List<Integer> liste){
        return liste.stream().reduce(0,(x,y)-> x < y ? x:y);
    }

    //*****************************************************************************************
    // ORNEK11: Bir listedeki tÃ¼m elemanlarÄ±n  Ã§arpÄ±mÄ±nÄ± bulan ve dÃ¶ndÃ¼ren metotu tanÄ±mlayÄ±nÄ±z.
    //*****************************************************************************************
    public static int carpimBul(List<Integer> liste){
        return liste.stream().reduce(1,(x,y)-> x*y);
    }

    //********************************************************************************************
    // ORNEK12: Bir listede belirtilen elemandan kaÃ§ adet bulunduÄŸunu dÃ¶ndÃ¼ren metotu tanÄ±mlayÄ±nÄ±z.
    //********************************************************************************************
    public static int  elemanSay(List <Integer> liste, int eleman){
        return (int) liste.stream().filter(x -> x==eleman).count();
    }

    //********************************************************************************************
    // ORNEK13: Bir listedeki negatif sayÄ±larÄ± yazdÄ±ran metodu tanÄ±mlayÄ±nÄ±z.
    //********************************************************************************************
    public static void negatifSayilariYazdir(List<Integer> liste){
        liste.stream().filter(x-> x<0).forEach(System.out::print);
    }
    //********************************************************************************************
    // ORNEK14: Bir listedeki negatif sayÄ±larÄ± ayrÄ± bir liste olarak dÃ¶ndÃ¼ren metodu yazalÄ±m.
    //********************************************************************************************
    public static List<Integer> negatifSayiListesi(List<Integer> liste){
        return liste.stream().filter(x-> x<0).collect(Collectors.toList());
    }

    //********************************************************************************************
    // ORNEK15: Listedeki tek elemanlarÄ±n karelerini sÄ±ralÄ± olarak ve tekrarsÄ±z bir ÅŸekilde
    // listeye kaydeden metodu yazÄ±nÄ±z. (Kare almak iÃ§in pow() metodu kullanÄ±labilir.
    //********************************************************************************************
    public static List<Integer> tekKareSiraliListele(List <Integer> liste){
      return liste.
              stream().
              distinct().
              filter(Metotlar::tekMi).
              map(x -> (int) Math.pow(x, 2)).   // pow() double dÃ¶ndÃ¼rdÃ¼ÄŸÃ¼ iÃ§in int'e Ã§evrilmesi gerekir
              distinct().
              sorted().                         // sorted(Comparator.reverseOrder()).  ----> Ters sÄ±ra iÃ§in
              collect(Collectors.toList());
    }

}
