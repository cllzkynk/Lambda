package Map_Tekrar;

import java.util.HashMap;

public class MapMethods {

  public static void main(String[] args) {
    HashMap<Integer, String> hm1 = new HashMap<>();
    hm1.put(101, "Ali Han"); // eleman eklemek için kullanılır. 101 key Alihan value
    hm1.put(102, "Veli Can"); //eleman ekleme put iile yapılır. add gibi
    hm1.put(103, "Ayşe Tan");
    hm1.put(101, "Kemal Yıldız"); // burayı yorum satırına alarak başta dene sonra normal hale getir. aynı key kullanıldığında eski kaydın üzerine yazar.
    System.out.println(hm1); //{101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan}

    hm1.put(104, "Veli Can"); //tekrarlı keye izin vermez ancak tekrarlı value ya izin verir
    System.out.println(hm1); //{101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can}

    hm1.put(null, "Merve Göçen"); //bir tane null değer ekleyebilir
    System.out.println(hm1); //{null=Merve, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can}

    hm1.put(null, "Dila Göçen"); //merve değerinin üztüne yazar
    System.out.println(hm1); //{null=Dila Göçen, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can}

    hm1.put(105, null);
    System.out.println(hm1); //sona ekledi{null=Dila Göçen, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can, 105=null}

    hm1.put(106, null); //value ler istediğimiz kadar null değer alır
    System.out.println(hm1); //{null=Dila Göçen, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can, 105=null, 106=null}

    System.out.println(hm1.get(103)); //Ayşe Tan

    //tüm value leri getirme:

    System.out.println(hm1.values()); //sıralı gelmeyebilir [Dila Göçen, Kemal Yıldız, Veli Can, Ayşe Tan, Veli Can, null, null]

    //tüm key leri getirme:

    System.out.println(hm1.keySet()); //[null, 101, 102, 103, 104, 105, 106]

    //key değerlerini lambda ile toplama
    System.out.println(
      hm1.keySet().stream().filter(t -> t != null).reduce(0, (a, b) -> a + b) //621
    );
    hm1.putIfAbsent(104, "Akif Emre"); //eğer yoksa ekle demek.var olan belirtilen keye ait key ve value olduğu için eklemedi.

    System.out.println(hm1); //{null=Dila Göçen, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can, 105=null, 106=null}

    hm1.putIfAbsent(107, "hakan tetik");
    System.out.println(hm1); //{null=Dila Göçen, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can, 105=null, 106=null, 107=hakan tetik}

    hm1.putIfAbsent(105, "Faruk Efehan");
    System.out.println(hm1); //null olan değeri ekledi.{null=Dila Göçen, 101=Kemal Yıldız, 102=Veli Can, 103=Ayşe Tan, 104=Veli Can, 105=Faruk Efehan, 106=null, 107=hakan tetik}

    System.out.print("hm1 in eleman sayısı : " + hm1.size());
    System.out.println();
    HashMap<Integer, String> hm2 = new HashMap<>();
    hm2.put(107, "Elma");
    hm2.put(106, "Erik");

    hm1.putAll(hm2); //hepsini ekle, aynı key olmamalı dikkat edelim
    System.out.print("hm2 in eleman sayısı : " + hm2.size());

    System.out.println(hm1); //hm1 in içine hm2 yi tamamen ekledi
  }
}
