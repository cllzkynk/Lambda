package lambda_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {

  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>(
      Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15)
    );
    yazdirJava(l);
    System.out.println();
    yazdirLambda(l);
    System.out.println();
    ciftSayiJava(l);
    System.out.println();
    ciftSayiLambda(l);
    System.out.println();
    teksayiKare(l);
    System.out.println();
    farkliTekKup(l);
    System.out.println();
    ciftSayiKareToplam(l);
    System.out.println();
    tekrarsizCiftKupCarpim(l);
    System.out.println();
    tersDuzSira(l);
  }

  //7) Listedeki elemanlari siralayarak ve ters siralayarak yazdir.

  public static void tersDuzSira(List<Integer> l) {
    l.stream().sorted().forEach(t -> System.out.print(t + " "));
    System.out.println();
    l
      .stream()
      .sorted(Comparator.reverseOrder())
      .forEach(t -> System.out.print(t + " "));
  }

  //6) Listedeki tekrarli elemanlari silip kaln sayilardan çift olanlarinin küplerinin çarpimi
  public static void tekrarsizCiftKupCarpim(List<Integer> l) {
    int kup = l
      .stream()
      .distinct()
      .filter(t -> t % 2 == 0)
      .map(t -> t * t * t)
      .reduce(1, (x, y) -> x * y);

    System.out.print("Çift sayilarin küpünün çarpimi : " + kup);
  }

  //5) Lİstedeki tekrarli elemanlari silip çift sayi olanlarin karelerinin toplamini yazdiran metot oluştur
  public static void ciftSayiKareToplam(List<Integer> l) {
    System.out.print(
      l
        .stream()
        .distinct()
        .filter(t -> t % 2 == 0)
        .map(t -> t * t)
        .reduce(0, (x, y) -> x + y)
    );
  }

  ///4)Listedeki tekrarli elemanlari silip tek sayi olanlarin küplerini yazdiran metod oluştur
  public static void farkliTekKup(List<Integer> l) {
    l
      .stream()
      .distinct()
      .filter(t -> t % 2 == 1)
      .map(t -> t * t * t)
      .forEach(t -> System.out.print(t + " "));
  }

  //3) List teki tek sayilarin karelerini yazdiran metod oluşturun

  public static void teksayiKare(List<Integer> l) {
    l
      .stream()
      .filter(t -> t % 2 == 1)
      .map(t -> t * t)
      .forEach(t -> System.out.print(t + " "));
  }

  public static void ciftSayiLambda(List<Integer> l) {
    //lambda expression (->arrow function)
    l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));
  }

  public static void ciftSayiJava(List<Integer> l) {
    for (Integer w : l) {
      if (w % 2 == 0) System.out.print(w + " ");
    }
  }

  public static void yazdirJava(List<Integer> list) {
    for (Integer w : list) {
      System.out.print(w + " ");
    }
  }

  public static void yazdirLambda(List<Integer> l) {
    l.stream().forEach(t -> System.out.print(t + " "));
  }
}
//3) List teki tek sayilarin karelerini yazdiran metod oluşturun
//4) Listedeki tekrarli elemanlari silip tek sayi olanlarin küplerini yazdiran metod oluştur
//5) Listedeki tekrarli elemanlari silip çift sayi olanlarin karelerinin toplamini yazdiran metot oluştur
//6) Listedeki tekrarli elemanlari silip kaln sayilardan çift olanlarinin küplerinin çarpimi
//7) Listedeki elemanlari siralayarak ve ters siralayarak yazdir.
