package day04Lambda_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lambda03 {

    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("C:\\Users\\TOSHIBA-PC\\eclipse-workspace\\Lambda\\src\\day04Lambda\\File")).forEach(t-> System.out.println(t));
            // Java kolaydir, lambda daha kolaydir.
            // Lambda ogrenirseniz kodlama daha az zaman alacaktir.
            // Kursumuzdaki her ders ceketin cepleriyse, java ic cep, lambda da ic cebin bozuk para kismi
        } catch (IOException e) {
            e.printStackTrace();
            // hata yaptirirsak sunu yazdircakti...
            // java.nio.file.NoSuchFileException: C:\Users\TOSHIBA-PC\eclipse-workspace\Lambda\src\day04Lambda\Files
        }

        // 1- Tum karakterleri buyuk harfe donustururnuz ve okuyunuz...
        try {
            Files.lines(Paths.get("C:\\Users\\TOSHIBA-PC\\eclipse-workspace\\Lambda\\src\\day04Lambda\\File")).
                    map(String::toUpperCase).forEach(t-> System.out.println(t));
            // JAVA KOLAYDİR, LAMBDA DAHA KOLAYDİR.
            // LAMBDA OGRENİRSENİZ KODLAMA DAHA AZ ZAMAN ALACAKTİR.
            // KURSUMUZDAKİ HER DERS CEKETİN CEPLERİYSE, JAVA İC CEP, LAMBDA DA İC CEBİN BOZUK PARA KİSMİ
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2- Metindeki farkli kelimeleri yazdiriniz...
        try {
            Files.lines(Paths.get("C:\\Users\\TOSHIBA-PC\\eclipse-workspace\\Lambda\\src\\day04Lambda\\File")).
                    map(t->t.split(" ")).flatMap(Arrays::stream).map(t->t.replaceAll("\\W"," ")).
                    distinct().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3- Metinde "e" iceren tum kelimeleri yazidiriniz...
        try {
            Files.lines(Paths.get("C:\\Users\\TOSHIBA-PC\\eclipse-workspace\\Lambda\\src\\day04Lambda\\File")).
                    map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
            //
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
