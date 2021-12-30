package lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda01Kurallar {

    // Javada Lambda fonksiyonlari sadece Fonksiyonel interface'ler ile kullanilabilir.
    // Sadece bir adet abstract methodu olan interface'lere fonksiyonel interface denilir
    // Kullanici isterse kendi fonksiyonel interface'ini yazabilir. Ama java'da hali hazirda
    // Costumer, Function, Supplier, Predicate gibi tanimlanmis interfaceler bulunmaktadir.
    // Ayrica bu interface'leri parametre olarak alabilen  High Order Function (Hof)'lar da bulunmaktadir.
    // forEach(), map(), filter(), reduce() gibi Hof'lar fonksiyonel interfaceler ile calistigi icin
    // icerisinde Lambda fonksiyonlari yazmak munkundur.
    // Javada genelde bu gibi fonksiyonlar uzerinden Lambda ifadeleri kullanilmaktadir.

    public static void main(String[] args) {
        List<Integer> liste = Arrays.asList(1,2,3,4,5);

        // forEach() bir collection'nin iterasyonu icin kullanilan HOF'dur.
        // Parametre olarak bir lambda fonksiyonu alabilir


        // Dizinin Elemanlarını yazdıralım
        System.out.println("=== Dizinin Elamanlarını Yazdır ===");
        liste.forEach( (x)-> System.out.println(x));

        //Listenin elemanlarını 2 arttırarak yazdıralım.
        System.out.println("\n == Dizinin Elamanlarını 2 arttırarak Yazdır ==");
        liste.forEach(t-> System.out.print(t+2 + " "));


        System.out.println("\n=== Eğer satır sayısı 1'den fazla ise {} kullanmalıyız..=== ");
        liste.forEach(t-> {
            int miktar = 2;
            System.out.print(t + miktar + " ");
        });


        System.out.println("\n === Veri tipi kullanılırsa : Explicit ==");
        System.out.println("Dizinin Elemanlarının 2 katını yazdır.");
        liste.forEach((Integer x) -> System.out.print(x*2 + " "));

        System.out.println("\nLambda ifadesinde dış değişkenler kullanalıbilir");
        System.out.println("Ancak bu değişken Final gibi davranır.");
        int deger= 6;
        liste.forEach(t-> System.out.println(t+deger));


        // Metot Refransı =====> Class adı :: Metot adı
        System.out.println("\nJavanın Method referansını kullanabiliriz");
        liste.forEach(System.out::print);

        // Metot Referansı =====> Class adı :: Metot adı
        System.out.println("\nKendimizin yazdığı metotları da Method referansı olarak kullanabiliriz");
        liste.forEach(Lambda01Kurallar::yazdir);


        // 1) (int x, int y) -> {return x+y;}  ==> explicit (Veri tipi kullanılırsa)
        // 2) x -> x*x  ==> implicit
        // 3) () -> x

        /*
        Parametre tipleri acikca (explicit) tanimlanabilecegi gibi örtulu (implicit) olarak da tanimlanabilir
        Derleyici context'e bakarak veri tipini anlayabilir. esim. 1) ve 2)

        Eger paremetre tek ise etrafinda bir parentez sart degildir. 2)

        () Sifir parametre icin kulalanilir. 3)

        Suslu parantezler tek bir ifade icin sart degildir. 3)
         */





    }
    // int değer yazdıran metot
    public static void yazdir(int x) {
        System.out.print(x + " ");
    }

}
