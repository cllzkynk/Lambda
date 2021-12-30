package day04Lambda_;

 
import java.util.stream.IntStream;

import lambda_1.MethodLambda02;

public class Lambda05 {

  public static void main(String[] args) {
    //1) 1den 20ye kadar olan sayıları yazdır

    IntStream.rangeClosed(1, 20).forEach(MethodLambda02::bosluklaYazdir);
    System.out.println();

    //2) functional programlamayı kullanarak 3 den 98 e kadar olan çift tam sayıların toplamı

    int toplam = IntStream.rangeClosed(3, 98).filter(t -> t % 2 == 0).sum();
    System.out.print(toplam);
    System.out.println();

    //3) funcional programing kullanarak 9! i bulalım.

    int carpim = IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact);
    System.out.print(carpim);
    System.out.println();

    // 4) İlk 7 çift sayma sayısının çarpımını bulun (2,4,6,8,10,12,14)

    int carpim2 = IntStream
      .rangeClosed(2, 50)
      .filter(t -> t % 2 == 0)
      .limit(7)
      .reduce(1, Math::multiplyExact);
    System.out.println(carpim2);

    //6)  6'dan büyük ilk 15 tek sayma sayısının toplamını bulun ==> 7, 9, 11, 13, 15, 17, 19

    int ittir = IntStream.iterate(7, t -> t + 2).limit(150).sum();
    System.out.print(ittir);
    System.out.println();

    //7) İlk 23 tek sayma sayısının toplamını bulun
    int toplayn = IntStream.iterate(2, t -> t + 2).limit(23).sum();
    System.out.print(toplayn);
    System.out.println();

    //7)  (11den 33 e kadar) her tam sayının rakamlarının toplamını hesaplamak için bir metod oluşturun

    IntStream
      .rangeClosed(11, 33)
      .map(MethodLambda02::rakamlarToplami)
      .forEach(MethodLambda02::bosluklaYazdir);
  }
}
