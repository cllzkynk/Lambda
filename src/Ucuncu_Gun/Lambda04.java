package Ucuncu_Gun;

 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lambda_1.MethodLambda02;

public class Lambda04 {

  public static void main(String[] args) {
    List<String> l = new ArrayList<>(
      Arrays.asList(
        "Ali",
        "Ali",
        "Aysima",
        "Abdurrahman",
        "Mehmet",
        "Mustafa",
        "Bedirhan",
        "Yüksel",
        "Süleyman"
      )
    );
    yazdirBuyuk01(l);
    System.out.println();
    uzunlukSirala(l);
    System.out.println();
    farkliSonHarfSirala(l);
    System.out.println();
    uzunlukVeIlkHarfSirala(l);
    System.out.println();
    buyukAYazdir(l);
    System.out.println();
    ABaslaVeyaIBit(l);
    System.out.println();
    buyutSirala(l);
    System.out.println();
    isimUzunlukSirala(l);
    System.out.println();
    uzunlugunKaresiniAl(l);
    System.out.println();
    onikidenUzunMu(l);
    System.out.println();
    sondanIkinciSiralaIlk(l);
    System.out.println();
  }

  //11) elemanları sondan 2. elemanlarına göre sıralayıp ilk elemanı yazdır
  public static void sondanIkinciSiralaIlk(List<String> l) {
    System.out.println(
      l
        .stream()
        .sorted(Comparator.comparing(t -> t.charAt(t.length() - 2)))
        .findFirst()
    );
  }

  //10) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol etmek için bir metod oluşturun
  //bütün elemanların "x" ile başlamadığını kontrol etmek için bir yöntem oluşturun
  //en az 1 tane "R" ile biten eleman olup olmadığını kontrol etmek için bir metod oluşturun.
  public static void onikidenUzunMu(List<String> l) {
    boolean result1 = l.stream().allMatch(t -> t.length() < 12);
    System.out.print("Elemanların uzunlukları 12 den küçük mü : " + result1);
    System.out.println();
    boolean result2 = l.stream().noneMatch(t -> t.startsWith("x"));
    System.out.print("Elemanlar x ile başlıyor mu : " + result2);
    System.out.println();
    boolean result3 = l.stream().anyMatch(t -> t.endsWith("R"));
    System.out.print("En az 1 eleman R harfi ile bitiyor mu : " + result2);
  }

  //9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil, bunların 20'den büyük olanlarını ters sırada  yazdırın
  public static void uzunlugunKaresiniAl(List<String> l) {
    l
      .stream()
      .map(t -> t.length() * t.length())
      .distinct()
      .filter(t -> t > 20)
      .sorted(Comparator.reverseOrder())
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın
  public static void isimUzunlukSirala(List<String> l) {
    l
      .stream()
      .sorted(Comparator.comparing(String::length))
      .map(t -> t + ":" + t.length())
      .map(t -> t + ",")
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle yazdırmak için bir yöntem oluşturun
  public static void buyutSirala(List<String> l) {
    l
      .stream()
      .map(String::toUpperCase)
      .sorted(Comparator.comparing(String::length))
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //7)  Küçük harflerle, "A" ile başlayan veya "i" ile biten liste öğelerini yazdırmak için bir yöntem oluşturun
  public static void ABaslaVeyaIBit(List<String> l) {
    l
      .stream()
      .filter(t -> t.startsWith("A") || t.endsWith("i"))
      .map(String::toLowerCase)
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //5)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun    */
  public static void buyukAYazdir(List<String> l) {
    l
      .stream()
      .filter(t -> t.startsWith("A"))
      .map(String::toUpperCase)
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //4) Elemanları uzunluklarına ve ardından (aynı uzunlukta olanları) ilk karakterlerine göre sıralamak için bir yöntem oluşturun
  public static void uzunlukVeIlkHarfSirala(List<String> l) {
    l.add("Ata");
    l
      .stream()
      .sorted(
        Comparator
          .comparing(String::length)
          .thenComparing(t -> t.substring(0, 1))
      )
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //3) farklı elemanların son harflerine göre sıralayıp yazdır
  public static void farkliSonHarfSirala(List<String> l) {
    l
      .stream()
      .distinct()
      .sorted(Comparator.comparing(t -> t.substring(t.length() - 1)))
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //2)Elemanları uzunluklarına göre sırala ve yazdır.Birini tüüm harfler büyük yaptım.
  public static void uzunlukSirala(List<String> l) {
    l
      .stream()
      .map(String::toUpperCase)
      .sorted(Comparator.comparing(String::length))
      .forEach(MethodLambda02::bosluklaYazdir);

    //ikinci yöntem
    l
      .stream()
      .sorted(Comparator.comparing(String::length).reversed())
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //1)Listin elemanlarını büyük harfle yazdır.
  public static void yazdirBuyuk01(List<String> l) {
    l
      .stream()
      .map(t -> t.toUpperCase())
      .forEach(MethodLambda02::bosluklaYazdir);
    System.out.println();
    //bu da diğer yol....
    l.stream().map(String::toUpperCase).forEach(MethodLambda02::bosluklaYazdir);
  }
}
