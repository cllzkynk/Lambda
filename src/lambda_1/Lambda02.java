package lambda_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lambda02 {

  // Method Reference'da bizim oluşturduğumuz metodları  veya Java metodlarını kullanırız.
  //Method Reference Syntax ı ==> ClassName::MethodName  System.out.println();  ==  System.out::println;
  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>(
      Arrays.asList(15, 14, 9, 13, 4, 9, 2, 4, 14, 6)
    );
    elemanYazdir(l);
    System.out.println();
    ciftSayiYazdir(l);
    System.out.println();
    tekSayiKare(l);
    System.out.println();
    tekSayiKupTekrarsiz(l);
    System.out.println();
    farkliCiftSayiKareToplam(l);
    System.out.println();
    farkliCiftSayiKupCarpim(l);
    System.out.println();
    System.out.print(farkliTersSirala(l));
  }

  //7)Listteki farklı ve 5 ten büyük ve çift elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.(Use Me
  public static List farkliTersSirala(List<Integer> l) {
    return l
      .stream()
      .distinct()
      .filter(t -> t > 5 && t % 2 == 0)
      .map(t -> t / 2)
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());
  }

  //6)Farklı çift sayıların küplerinin çarpımını yazdır .(Use Method Reference
  public static void farkliCiftSayiKupCarpim(List<Integer> l) {
    int carpim = l
      .stream()
      .distinct()
      .filter(MethodLambda02::ciftMi)
      .map(MethodLambda02::kupAl)
      .reduce(1, Math::multiplyExact);
    System.out.print(carpim + " ");
  }

  //5)Farklı çift sayıların karelerinin toplamını yazdır (Use Method Reference)

  public static void farkliCiftSayiKareToplam(List<Integer> l) {
    int sayi = l
      .stream()
      .distinct()
      .filter(MethodLambda02::ciftMi)
      .map(MethodLambda02::kareAl)
      .reduce(0, Math::addExact);
    System.out.print(sayi);
  }

  //4)Listteki tekrarlı olanları silip tek sayıların küplerini alıp aralarında boşluk bırakarak yanyana yazdır.
  public static void tekSayiKupTekrarsiz(List<Integer> l) {
    l
      .stream()
      .distinct()
      .filter(MethodLambda02::tekMi)
      .map(MethodLambda02::kupAl)
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //3)List teki tek sayıların karelerini alıp aralarında boşluk bırakarak yanyana yazdır
  public static void tekSayiKare(List<Integer> l) {
    l
      .stream()
      .filter(MethodLambda02::tekMi)
      .map(MethodLambda02::kareAl)
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //2)List in elemanlarından çift olanları aralarında boşluk bırakarak yanyana yazdır..(Method Reference)
  public static void ciftSayiYazdir(List<Integer> l) {
    l
      .stream()
      .filter(MethodLambda02::ciftMi)
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //1)List in elemanlarını aralarında boşluk bırakarak yanyana yazdır.(Method Reference- kendi metodumuz)
  public static void elemanYazdir(List<Integer> l) {
    l.stream().forEach(MethodLambda02::bosluklaYazdir); //15 14 9 13 4 9 2 4 14
  }
}
