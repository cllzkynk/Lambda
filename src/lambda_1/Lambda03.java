package lambda_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>(
      Arrays.asList(7, 12, 14, 4, 9, 2, 4, 12, 16)
    );
    ilkDortEleman(l);
    System.out.println();
    ilkDortElemanGec(l);
    System.out.println();
    ucElemanYazdir(l);
    System.out.println();
    maxDeger(l);
    System.out.println();
  }

  //4)Listtekien küçük elemanı bul, en büyük elamnı bul
  public static void maxDeger(List<Integer> l) {
    System.out.println(l.stream().reduce(Integer.MAX_VALUE, Math::min));
    System.out.println(l.stream().reduce(Integer.MIN_VALUE, Math::max));

    //en büyük değeri bulmanın kolay yolu=
    l
      .stream()
      .sorted(Comparator.reverseOrder())
      .limit(1)
      .forEach(MethodLambda02::bosluklaYazdir);

    l.stream().sorted().limit(1).forEach(MethodLambda02::bosluklaYazdir);
  }

  //3) küçükten büyüğe sırala 4,5,6. elemanları yazdır.
  public static void ucElemanYazdir(List<Integer> l) {
    l
      .stream()
      .sorted()
      .skip(3)
      .limit(3)
      .forEach(MethodLambda02::bosluklaYazdir);
  }

  //2) küçükten büyüğe sırala ve ilk dört elemanı atlayarak yazdır.
  public static void ilkDortElemanGec(List<Integer> l) {
    l.stream().sorted().skip(4).forEach(MethodLambda02::bosluklaYazdir);
  }

  //1)küçükten büyüğe sırala ve ilk dört eleamnını yazdır.

  public static void ilkDortEleman(List<Integer> l) {
    l.stream().sorted().limit(4).forEach(MethodLambda02::bosluklaYazdir);
  }
}
