package Abstract;

import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Dikdortgen dikdortgen = new Dikdortgen();
    Scanner scan = new Scanner(System.in);

    System.out.print("Uzun kenar giriniz : ");

    dikdortgen.uzun = scan.nextInt();

    System.out.print("Kısa kenar giriniz : ");

    dikdortgen.kisa = scan.nextInt();

    System.out.println("Dikdörtgenin çevresi : " + dikdortgen.cevre());
    System.out.println("Dikdörtgenin alanı : " + dikdortgen.alan());
  }
}
