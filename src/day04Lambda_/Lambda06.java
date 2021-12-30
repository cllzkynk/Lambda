package day04Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lambda06 {

  public static void main(String[] args) {
    UniversiteLambda06 edebiyatBolum = new UniversiteLambda06(
      "IIBF",
      "ÇEKO",
      95,
      128
    );
    UniversiteLambda06 iktisatBolum = new UniversiteLambda06(
      "IIBF",
      "İktisat",
      98,
      134
    );
    UniversiteLambda06 matematikBolum = new UniversiteLambda06(
      "Fen Edebiyat",
      "Matematik",
      95,
      142
    );
    UniversiteLambda06 ingilizceBolum = new UniversiteLambda06(
      "Ingiliz Dili",
      "İngilizce",
      93,
      154
    );

    List<UniversiteLambda06> uniList = new ArrayList<>(
      Arrays.asList(edebiyatBolum, iktisatBolum, matematikBolum, ingilizceBolum)
    );

    //1)Tüm ortalama puanların (91)'den büyük olup olmadığını kontrol etmek için bir yöntem oluşturun

    System.out.println(
      uniList.stream().allMatch(t -> t.getNotOrtalamasi() > 91)
    );

    //2)Ders adlarından en az birinin "Matematik" kelimesini içerip içermediğini kontrol etmek için bir yöntem oluşturun
    System.out.println(
      uniList.stream().anyMatch(t -> t.getBolum().equals("Matematik"))
    );
    //3) Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturalım
    System.out.println(
      uniList
        .stream()
        .sorted(
          Comparator.comparing(UniversiteLambda06::getNotOrtalamasi).reversed()
        )
        .findFirst()
    );

    //4)Not ortalamasına göre artan sıralama yapıp ilk elemanı atla ve list olarak yazdır
    System.out.println(
      uniList
        .stream()
        .sorted(Comparator.comparing(UniversiteLambda06::getNotOrtalamasi))
        .skip(1)
        .collect(Collectors.toList())
    );
  }
}
