package day03Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("Ali","Ali","Aysima","Abdurrahman","Mehmet","Mustafa","Bedirhan","Yuksel","Suleyman"));

        yazdirBuyuk1(l);
        System.out.println();
        uzunlukSirala(l);
        System.out.println();
        farkliSonHarfSirala(l);
        System.out.println();
        uzunlukSiralaIlkEleman(l);
        System.out.println();
        yazdirAileBaslayan(l);
        System.out.println();
        AbaslaVeyaiBit(l);
        System.out.println();
        siralaBuyut(l);
        System.out.println();
        isimUzunlukSirala(l);
        System.out.println();
        karesiniAlSiralaSil(l);
        System.out.println();
        ebikGabik(l);
        System.out.println();
        sondanIkinciSiralaIlk(l);
        System.out.println();
        terstenSiralaIlkYazdir(l);


    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 1)list in elemanlarini buyuk harfle yazdir
    public static void yazdirBuyuk1(List<String> l) {
        l.stream().map(t->t.toUpperCase()).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
        System.out.println();
        l.stream().map(String::toUpperCase).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 2) elemanlari uzunluklarina göre sirala ve yazdir... Note: Java, elemanlari varsayilan olarak artan siraya koyar.
    public static void uzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).forEach(methodLambda02::bosluklaYazdir); // Kucukten buyuge
        // Ali Ali Aysima Mehmet Yuksel Mustafa Bedirhan Suleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(methodLambda02::bosluklaYazdir); // buyukten kucuge
        // Abdurrahman Bedirhan Suleyman Mustafa Aysima Mehmet Yuksel Ali Ali
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 3) farkli elemanlarini son harflerine göre siralayip yazdir
    public static void farkliSonHarfSirala(List<String> l) {
        l.stream().distinct().sorted(Comparator.comparing(t->t.substring(t.length()-1))).forEach(methodLambda02::bosluklaYazdir);
        // Aysima Mustafa Ali Yuksel Abdurrahman Bedirhan Suleyman Mehmet
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 4) Elemanlari uzunluklarina ve ardindan (ayni uzunlukta olanlari) ilk karakterlerine göre siralamak için bir yöntem oluşturun
    public static void uzunlukSiralaIlkEleman(List<String> l) {
        l.add("Ata");
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1))).forEach(methodLambda02::bosluklaYazdir);
        // Ali Ali Ata Aysima Mehmet Yuksel Mustafa Bedirhan Suleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1)).thenComparing(t->t.substring(1,2))).
                forEach(methodLambda02::bosluklaYazdir);
        // Ali Ali Ata Aysima Mehmet Yuksel Mustafa Bedirhan Suleyman Abdurrahman
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 5)Buyuk harflerle, "A" ile başlayan liste ögelerini yazdirmak için bir yöntem oluşturun
    public static void yazdirAileBaslayan(List<String> l) {

        l.stream().filter(t->t.startsWith("A")).map(String::toUpperCase).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ AYSİMA ABDURRAHMAN ATA
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 6)  Kuçuk harflerle, "A" ile başlayan veya "i" ile biten liste ögelerini yazdirmak için bir yöntem oluşturun
    public static void AbaslaVeyaiBit(List<String> l) {
        l.stream().filter(t->t.startsWith("A")||t.endsWith("i")).map(String::toLowerCase).forEach(methodLambda02::bosluklaYazdir);
        // ali ali aysima abdurrahman ata
        //metod reference ile yaparsak komutlarin içine sadece bir işlem alabiliriz.arrow (->) function da && || larla istedigimiz kadar işlem alabiliriz
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 7) Ögeleri uzunluklarina göre siraladiktan sonra buyuk harflerle yazdirmak için bir yöntem oluşturun
    public static void siralaBuyut(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(String::toUpperCase).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ ATA AYSİMA MEHMET YÜKSEL MUSTAFA BEDİRHAN SÜLEYMAN ABDURRAHMAN
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 8) Elemanlari uzunluklarina göre siralayin önce elemani sonra uzunlugunu yazdirin
    // Ali:3 Aysima:6
    public static void isimUzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(t->t + ":"+ t.length()).forEach(methodLambda02::bosluklaYazdir);
        // Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yuksel:6 Mustafa:7 Bedirhan:8 Suleyman:8 Abdurrahman:11
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yuksel:6 Mustafa:7 Bedirhan:8 Suleyman:8 Abdurrahman:11
    // 9) Her elemanin uzunlugunun karesini alip tekrarlilari sil, bunlarin 20'den buyuk olanlarini ters sirada  yazdirin
    public static void karesiniAlSiralaSil(List<String> l) {
        l.stream().map(t->t.length()*t.length()).distinct().filter(t->t>20).sorted(Comparator.reverseOrder()).forEach(methodLambda02::bosluklaYazdir);
        // 121 64 49 36
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 10) Tum elemanlarin uzunluklarini 12'den az olup olmadigini kontrol etmek için bir metod olusturun
    public static void ebikGabik(List<String> l) {

    //allMatch(): butun elemanlarda olmasini istedigimiz şeyleri yazariz sonuç boolean verir
    //örnegin String bir list için==> allMatch(t -> t.length() < 7)==elemanlarin hepsinin uzunlugu 7 den kuçukse true, biri bile degilse false
        boolean result1=    l.stream().allMatch(t->t.length()<12);
        System.out.println("elemanlarin uzunluklari 12 den kucuk mu? : " +result1); // elemanlarin uzunluklari 12 den kuçukmu? true
        System.out.println();

    // butun elemanlarin "x" ile baslamadigini kontrol etmek için bir yöntem olusturun...
    // NOt : noneMatch():hiçbir elemanda olmasin istersek kullaniriz, elemanlarin tumunde yoksa true, bir tane elemanda bile varsa false
    // örnegin==>noneMatch(t-> t.startsWith("X"))==hiçbiri X ile başlamiyorsa true
        boolean result2= l.stream().noneMatch(t->t.startsWith("X"));
        System.out.println("X ile baslayan öge yok : "+result2); // X ile baslayan öge yok : true
        System.out.println();

    // en az 1 tane "R" ile biten eleman olup olmadigini kontrol etmek icin bir metod olusturun.
    // Not : anyMatch(): en az bir elemanda olmasini istedigimiz bir özellik varsa kullaniriz,sonuç boolean dir
    // örnegin==>anyMatch(t-> t.endsWith("R"))== en az bir eleman R ile bitiyorsa true,yoksa false
        boolean result3= l.stream().anyMatch(t->t.endsWith("R"));
        System.out.println("elemanlardan herhangi biri R ile bitiyormu : " +result3); // false -- elemanlardan herhangi biri R ile bitiyormu : false
    }

    // elemanlari sondan 2. elemanlarina gore siralayip ilk elemani yazdir
    // Not : findFirst():listedeki ilk elemani verir. (tek eleman verecegi için, foreach ile yazdirilmaz. Butun soru syso nun içine alinarak yazdirilabilir)
    public static void sondanIkinciSiralaIlk(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst()); // Optional[Abdurrahman]
    }

    // elemanlari uzunluklarina göre tersten siralayip  ilk elemani yazdir
    public static void terstenSiralaIlkYazdir(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()); // Optional[Abdurrahman]
        System.out.println();

    // Eleman 'A', 'a' ile başliyor veya 'N', 'n' ile bitiyorsa o elemani silin

        l.removeIf(t->t.toUpperCase().startsWith("A")||t.toUpperCase().endsWith("N"));
        System.out.println(l); // [Mehmet, Mustafa, Yuksel]
    }

}