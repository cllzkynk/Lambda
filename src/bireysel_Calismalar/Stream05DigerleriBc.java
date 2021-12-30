package bireysel_Calismalar;

import streamOrnekler.Methodlar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream05DigerleriBc {
    public static void main(String[] args) {

        System.out.println(toplam(4)); //10
        System.out.println(toplam1(6)); //21
        toplamYazdir(10);
        tekSayilarinToplami(4, 7);
        System.out.println(tekSayilarinToplamiDondur(4, 7));
        System.out.println(tekSayilarinToplamiDondurLambda(4,7));
        System.out.println("Faktoriyel Mehtod'u : " + faktoriyel(6));
        System.out.println("Faktoriyel1 Mehtod'u : " + faktoriyel1(6));

    }


    //****************************************************************************************************
    // ÖRNEK25: 1'den belirtilen değere kadar olan tamsayıları toplayan ve sonucu döndüren metodu yazınız.
    //****************************************************************************************************

    public static int toplam(int deger){
        return IntStream.range(1, deger+1).sum();
    }

    public static  int toplam1(int deger){
        return IntStream.rangeClosed(1,deger).sum();
    }

    public static void toplamYazdir(int deger){
        System.out.println(IntStream.rangeClosed(1,deger).sum());
    }


    //****************************************************************************************************
    // ÖRNEK26: Berlirtilen aralıktaki tek sayıların toplamını yazdıran metodu tanımlayınız.
    //****************************************************************************************************

    public static void tekSayilarinToplami(int ilk, int son){
        System.out.println(IntStream.rangeClosed(ilk,son).filter(Methodlar::tekMi).sum());;
    }

    public static int tekSayilarinToplamiDondur(int ilk, int son){
       return IntStream.rangeClosed(ilk,son).filter(Methodlar::tekMi).sum();
    }

    public static int tekSayilarinToplamiDondurLambda(int ilk,int son){
        return IntStream.rangeClosed(ilk, son).filter(x-> x%2!=0).sum();
    }

    //****************************************************************************************************
    // ÖRNEK27: Berlirtilen sayının faktoriyelini hesaplayan metodunu tanımlayınız.
    //****************************************************************************************************
    // iterate metodu aslında döngülere benzer. Başlangıcı ve artım miktarı parametre olarak verilebilir.
    // Döngünün biteceği sayı ise limit() metodu ile gösterilir.

    public static int faktoriyel(int n){
        return IntStream.rangeClosed(1,n).reduce(1,(x,y) -> x*y);
    }

    public static Integer faktoriyel1(int n){
        return IntStream.iterate(1, x -> x+1).limit(n).reduce(1,(x, y)->x*y);
    }


    //*********************************************************************************************
    // ÖRNEK28: Bir double diziyi (notlar) Stream nesnesine dönüştürerek bu dizi içerisinde bulunan
    // sayıların 50 den büyük olanlarını ayrı bir listeye kaydererek yazdıran metodu tanımlayınız
    //**********************************************************************************************
    public static List<Double> doubleDiziCevirList() {
        Double[] notlar = {88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 10.0};
        Stream<Double> streamNotlar = Stream.of(notlar);
        return streamNotlar.filter(t -> t > 50.0).collect(Collectors.toList());
    }

}



