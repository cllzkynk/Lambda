package Map_Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapOrnek {

  public static void main(String[] args) {
    Map<Integer, String> ogr = new HashMap<>();

    ogr.put(117, "Erdem GÖÇEN -8/A");
    ogr.put(13, "Merve GÖÇEN -7/B");
    ogr.put(665, "Akif GÖÇEN -6/C");
    ogr.put(45, "Dila GÖÇEN -5/D");
    ogr.put(90, "Mine GÖÇEN -4/E");

    //yeni bir öğrenci girişi yapısın .var olan numara ile kayıt yapılmaya çalışıldığında
    //o numaralı kaydın olduğunu ve o numaraya ait kişinin bilgisini getirsin
    // eger belirtilen numara kayıtlı değilse kaydınız eklenmiştir desin.

    Scanner scan = new Scanner(System.in);
    System.out.print("Numara giriniz : ");

    int numara = scan.nextInt();
    scan.nextLine();

    System.out.print("Öğrenci bilgisini giriniz : ");
    String bilgi = scan.nextLine();

    if (ogr.putIfAbsent(numara, bilgi) == null) {
      System.out.println("kaydınız eklenmiştir " + ogr.get(numara));
    } else {
      System.out.println(
        "Bu kayıt mevcuttur : Kayıt " +
        ogr.putIfAbsent(numara, bilgi) +
        " kişisine aittir.."
      );
      // bir numara girildiğinde o kişiye ait sınıf bilgisi çıksın
      // kayıt yok ise "Boyle bir kayıt yok "desin

      System.out.print("Bir sayı giriniz : ");
      int sayi = scan.nextInt();

      if (ogr.get(sayi) == null) {
        System.out.println("Boyle bir kayit yok");
      } else {
        String temp = String.valueOf(ogr.get(sayi));
        System.out.println(
          "Ilgili ogrencinin sinifi " + temp.substring(temp.indexOf("-"))
        );

        System.out.print("Bir numara giriniz : ");
        int ogrNo = scan.nextInt();
        scan.nextLine();

        //bir numra girildiğinde o kişiye ait sınıf bilgisini bize göstersin
        //eğer kayıt yoksa böyle bir kayıt yok mesajı versin

        System.out.println(
          ogr.get(numara).substring(ogr.get(numara).indexOf('-') + 1)
        );
        //Maplerde bir keye karşılık birden fazla value olabilir mi?

      }
    }
  }
}
