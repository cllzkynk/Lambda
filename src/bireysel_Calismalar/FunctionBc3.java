package bireysel_Calismalar;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionBc3 {

    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        System.out.println("Virgulle ayrilmis olarak sayilari giriniz");

        String[] giris = scan.nextLine().split(",");

        Function<String, Integer> cevirici = x -> Integer.parseInt(x);
        int toplam = 0;
        for (String s : giris) {
            toplam += cevirici.apply(s);
        }

        System.out.println("Sayisi = " + giris.length);
        System.out.println("Toplam = " + toplam);


        scan.close();	

    }

}
