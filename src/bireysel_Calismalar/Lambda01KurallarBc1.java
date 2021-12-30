package bireysel_Calismalar;

import java.util.Arrays;
import java.util.List;

public class Lambda01KurallarBc1 {
    public static void main(String[] args) {

        List<Integer> sayilar = Arrays.asList(1,2,3);

        sayilar.forEach(x -> {   // ifade sayisi birden fazla oldugu icin {} kullanmaliyiz
            x+=2;
            System.out.println(x);
        });

        sayilar.forEach((Integer x) -> { // istersek parametrenin veri tipini belirtiriz
            x+=2;
            System.out.println(x);
        });

        sayilar.forEach(x-> {
            int y = x*2; // Lambda ifadesinde lokal degisken kullanilabilir
            System.out.println(y);
        });


        int disDegisken = 5; // ifade disi parametre de kullanabiliriz.Ancak bu degisken  final gibi dusunulmmelidir
        sayilar.forEach(x -> System.out.println(x+disDegisken));

        // Method Referansi ====> Class adi :: Method adi
        sayilar.forEach( x -> System.out.println(x));
        sayilar.forEach(System.out::println); // Daha kisa kullanim icin Metot Referansi tercih edilebilir


        /*
        Method referansi, bir Lambda ifadesine, var olan bir fonksiyonu arguman olarak gecirmek icin kullanilabilir

        Referans gösterilen metodun imzasi, fonksiyonel arayuz  metodunun imzasi ile örtusmelidir.
         */


        sayilar.forEach(Lambda01KurallarBc1::yazdir);
    }

    public static void  yazdir (int x){
        System.out.print(x + " ");
    }



}
