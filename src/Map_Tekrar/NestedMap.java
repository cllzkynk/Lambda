package Map_Tekrar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NestedMap {

  public static void main(String[] args) {
    HashMap<Integer, HashMap<String, String>> kisiListesi = new HashMap<>();
    HashMap<String, String> kisi1 = new HashMap<>();
    kisi1.put("Ad", "Nilüfer");
    kisi1.put("Soyad", "Demir");
    kisi1.put("Adres", "Ankara");
    kisi1.put("Bölüm", "Dev");
    kisiListesi.put(1213, kisi1);

    HashMap<String, String> kisi2 = new HashMap<>();
    kisi2.put("Ad", "Ayşe");
    kisi2.put("Soyad", "Can");
    kisi2.put("Adres", "Adana");
    kisi2.put("Bölüm", "QA");

    kisiListesi.put(4413, kisi1);
    kisiListesi.put(6690, kisi2);
    System.out.println(kisiListesi);

    //Maplerde data getirme
    //maplerde get ile iç kısımdaki value lere karşılık gelen mapler gelir..
    System.out.println(kisiListesi.get(4413)); //{Ad=Nilüfer, Soyad=Demir, Bölüm=Dev, Adres=Ankara}
    System.out.println(kisiListesi.get(4413).get("Ad")); //Nilüfer
  }
}
