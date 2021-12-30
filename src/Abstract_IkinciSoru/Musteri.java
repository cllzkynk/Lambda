package Abstract_IkinciSoru;

import java.util.Scanner;

public class Musteri {

  AnaAbstract anaAbstract;

  static Scanner scan = new Scanner(System.in);

  public void alisveris() {
    System.out.println("Ekmek Hesaplaması");
    System.out.print("Kaç ekmek almak istiyorsunuz : ");
    int x = scan.nextInt();

    System.out.println("Ekmek fiyatı : " + anaAbstract.ekmekAL(x) / x + " TL");
    System.out.print("Ödeyeceğiniz miktar : " + anaAbstract.ekmekAL(x) + " TL");
  }
}
