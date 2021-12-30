package day04Lambda_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Lambda02 {

    public static void main(String[] args) {

        EncapsuleUniversiteLambda02 edebiyatBolum = new EncapsuleUniversiteLambda02("FenEdebiyat", "Edebiyat", 97, 128);
        EncapsuleUniversiteLambda02 iktisatBolum = new EncapsuleUniversiteLambda02("IIBF", "Iktisat", 98, 134);
        EncapsuleUniversiteLambda02 matematikBolum = new EncapsuleUniversiteLambda02("FenEdebiyat", "Matematik", 95, 142);
        EncapsuleUniversiteLambda02 ingilizceBolum = new EncapsuleUniversiteLambda02("IngilizDili", "Ingilizce", 93, 154);

        List<EncapsuleUniversiteLambda02> uniList=new ArrayList<>(Arrays.asList(edebiyatBolum,iktisatBolum,matematikBolum,ingilizceBolum ));

        // 1- Tum ortalama puanlarin 91 den buyuk olup olmadigini kontrol etmek icin bir yontem olusturunuz...
        System.out.println(uniList.stream().allMatch(t -> t.getNotOrtalama() > 91)); // true

        // 2- Ders adlarindan en az birinin "matematik" kelimesini icerip icermedigini kontrol etmek icin bir yontem olusturun...
        System.out.println(uniList.stream().anyMatch(t->t.getBolum().equalsIgnoreCase("matematik"))); // true

        // 3- Ders adlarindan en az birinin "Matem" kelimesini icerip icermedigini kontrol etmek icin bir yontem olusturun...
        System.out.println(uniList.stream().anyMatch(t->t.getBolum().contains("Matem"))); // true

        // 4- Ortalama puani en yuksek olan kursu yazdırmak icin bir yöntem olusturunuz..
        System.out.println(uniList.stream().sorted(Comparator.comparing(EncapsuleUniversiteLambda02 ::getNotOrtalama).reversed()).findFirst());
        // Optional[EncapsuleUniversiteLambda02{fakulte='IIBF', bolum='İktisat', notOrtalama=98, ogrenciNo=134}]

        // 5- Not ortalamasina gore artan siralama yapip ilk elemanı atlayin ve list olarak yazdiriniz...
        System.out.println(uniList.stream().sorted(Comparator.comparing(EncapsuleUniversiteLambda02 ::getNotOrtalama)).skip(1).collect(Collectors.toList()));
        // [EncapsuleUniversiteLambda02{fakulte='FenEdebiyat', bolum='Matematik', notOrtalama=95, ogrenciNo=142},
        // EncapsuleUniversiteLambda02{fakulte='FenEdebiyat', bolum='Edebiyat', notOrtalama=97, ogrenciNo=128},
        // EncapsuleUniversiteLambda02{fakulte='IIBF', bolum='İktisat', notOrtalama=98, ogrenciNo=134}]



    }
}
