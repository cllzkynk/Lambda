package Abstract_IkinciSoru;

import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Musteri musteri = new Musteri();
    System.out.println(
      "Ekmeği nereden almak istersiniz : \n1-Market\n2-Halkekmek"
    );
    int tercih = scan.nextInt();
    if (tercih == 1) {
      musteri.anaAbstract = new Market();
      System.out.println();
    } else {
      musteri.anaAbstract = new HalkEkmek();
      System.out.println();
    }
    musteri.alisveris();
  }
}
// 5 farkli market, 5 farkli urun alisverisi yapilsin. (Urun fiyatlari farkli olsun) Sonra
// toplam tutarlari karsilastirsin. En son tum marketlerdeki alisveris fiyatlarini ayri ayri
// ekrana yazdirin.
