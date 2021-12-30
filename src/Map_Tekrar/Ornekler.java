package Map_Tekrar;

import java.util.HashMap;
import java.util.Scanner;

public class Ornekler {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String secim = "";
    HashMap<Integer, HashMap<String, String>> kisiListesi = new HashMap<>();
    do {
      HashMap<String, String> kisiBilgileri = new HashMap<>();

      System.out.print("Lütfen adınızı ve soyadınızı giriniz : ");
      //String isim=scan.nextLine();
      kisiBilgileri.put("Ad", scan.nextLine());

      System.out.print("Lütfen adresinizi giriniz : ");
      //  String adres=scan.nextLine();
      kisiBilgileri.put("Adres", scan.nextLine());

      System.out.print("Lütfen telefonunuzu giriniz : ");
      //String tel=scan.nextLine();
      kisiBilgileri.put("Telefon", scan.nextLine());

      System.out.print("Lütfen 4 haneli kimlik no giriniz : ");
      // int kimlikNo=scan.nextInt();
      kisiListesi.put(scan.nextInt(), kisiBilgileri);
      scan.nextLine();
      System.out.println(kisiBilgileri);
      System.out.println(kisiListesi);

      System.out.print("Devam etmek istiyor musunuz(E/H)");
      secim = scan.nextLine();
    } while (secim.equalsIgnoreCase("E"));

    System.out.print(
      "Görüntülemek istediğiniz kişinin kimlik numarasını giriniz : "
    );
    System.out.println(kisiListesi.get(scan.nextInt()));
  }
}
