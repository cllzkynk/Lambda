package streamProje01;
import java.util.ArrayList;
import java.util.List;


public class Main {


    private static List<Ogrenci> ogrListesi = new ArrayList<>();


    public static void main(String[] args) {


        testOgrenciolustur();
        ismeGoreListele("ahmet");
        ismeGoreListele("ayşe");
        ismeGoreListele("john");
    }






    private static void ismeGoreListele(String isim){

        System.out.println("\n============ "+ isim.toUpperCase() + " ADINDAKİ ÖĞRENCİLER ========");

        ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).
                // filter(t->t.getAd().equalsIgnoreCase(isim))
                // t = bir ogrenci nesnesi yani bir objedir
                // filter(t->t.getAd().equalsIgnoreCase(isim)) ==> tek tek tum isimleri getirerek
                // buyuk kucuk hassasiyeti olmadan ayni olanlari filtrele


                        /*
                        main clasinda olusturulan, ogrListesi isimli  colection'nina
                        Ogrenci clasc'i constructor'i ile uretilen yeni objeleri eklemistik
                        burada ise ;

                        ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).

                        ile ogrListesi colection'u  stream objesine cevirerek filtreledik

                        forEach(System.out::println); ile ise;
                        filtrelenen tum objeleri  forEach ile  methot referansi yaparak yazdirdik

                         */

                forEach(System.out::println);
    }





    private static void testOgrenciolustur(){

        // Ogrenci org1 = new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek");
        // ogrListesi.add(org1)
        // yada asagidaki sekilde yapabilirsiniz. bu kisa yol daha guzel ve bu sekilde tanimlanmis olan
        // yeni obje (new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek") direk ogrListesi'ne add yapilmis olur (ogrListesi.add(.....))


                        /*
                        main clasinda olusturulan, ogrListesi isimli  colection'nina
                        Ogrenci clasc'i constructor'i ile uretilen
                        yeni objeleri ekledik
                         */



        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayşe", "Can", 21, 82.3, "kadın"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayşe", "Yılmaz", 40, 45, "kadın"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Öztürk", 20, 95.5, "erkek"));
    }

}