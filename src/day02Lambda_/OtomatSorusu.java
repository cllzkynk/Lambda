package day02Lambda_;

import java.util.Scanner;
import java.util.TreeMap;

public class OtomatSorusu {

  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Java otomatina hosgeldiniz\n");
    TreeMap<String, Double> urunler = new TreeMap<>();
    urunler.put("A --> Snickers", 5.5);
    urunler.put("B --> Metro", 4.3);
    urunler.put("C --> Kitkat", 3.5);
    urunler.put("D --> Cikolatali gofret", 1.0);
    urunler.put("E --> Popkek", 2.5);
    char secim = ' ';
    boolean flag = false;
    String devam = "";
    urunler.forEach((x, y) -> System.out.println(x + " $" + y));
    double toplamTutar = 0;
    do {
      System.out.println("\nLutfen seciminizi yapiniz...");
      secim = scanner.nextLine().toUpperCase().charAt(0);
      switch (secim) {
        case 'A':
          toplamTutar += urunler.get("A --> Snickers");
          flag = false;
          break;
        case 'B':
          toplamTutar += urunler.get("B --> Metro");
          flag = false;
          break;
        case 'C':
          toplamTutar += urunler.get("C --> Kitkat");
          flag = false;
          break;
        case 'D':
          toplamTutar += urunler.get("D --> Cikolatali gofret");
          flag = false;
          break;
        case 'E':
          toplamTutar += urunler.get("E --> Popkek");
          flag = false;
          break;
        default:
          System.out.println(
            "Yanlis tuslama yaptiniz lutfen tekrar deneyiniz..."
          );
          flag = true;
          break;
      }
      if (flag == false) {
        System.out.println("Sectiginiz urun dusuyor...\n");
        Thread.sleep(300);
        System.out.println("Loading…\n" + "█▒▒▒▒▒▒▒▒▒");
        Thread.sleep(100);
        System.out.println("10%\n" + "███▒▒▒▒▒▒▒");
        Thread.sleep(100);
        System.out.println("30%\n" + "█████▒▒▒▒▒");
        Thread.sleep(100);
        System.out.println("50%\n" + "███████▒▒▒");
        Thread.sleep(100);
        System.out.println("100%\n" + "██████████");
        System.out.println("\n----------------------------------");
        System.out.println(
          "Afiyet olsun :)\nBaska bir urun almak ister misiniz(E-H)"
        );
        System.out.println("----------------------------------");
        devam = scanner.nextLine();
      }
    } while (devam.equalsIgnoreCase("E") || flag == true);
    System.out.println("Odemeniz gereken tutari --> $" + toplamTutar);
    System.out.println("-------------------------------------------\n\n");
    double odemeTutari = 0;
    do {
      System.out.println("Lutfen ucreti otomatin nakit giris bolumune koyunuz");
      double banknot = scanner.nextDouble();
      if (banknot == 1 || banknot == 5 || banknot == 10 || banknot == 20) {
        odemeTutari += banknot;
        if (odemeTutari < toplamTutar) {
          System.out.println(
            "-------------------------------------------------------------"
          );
          System.out.println(
            "Lutfen odemeyi tam yapiniz, odemeniz gereken eksik tutar --> " +
            (toplamTutar - odemeTutari)
          );
          System.out.println(
            "-------------------------------------------------------------\n"
          );
        }
        System.out.println("Paraniz kontrol ediliyor...");
        Thread.sleep(800);
        System.out.println("Paraniz onaylandi :)");
      } else {
        System.out.println(
          "Otomatimiz sadece $1,$5,$10,$20'lik banknot kabul etmektedir. Lutfen odemeyi bu sekilde yapiniz..\n"
        );
      }
    } while (odemeTutari < toplamTutar);
    if (odemeTutari > toplamTutar) {
      System.out.println("Para ustunuz --> $" + (odemeTutari - toplamTutar));
    }
    System.out.println(
      "Bizi tercih ettiginiz icin tesekkur ederiz gorusmek uzere :)"
    );
  }
}
