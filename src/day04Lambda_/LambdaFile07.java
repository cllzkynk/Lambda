package day04Lambda_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaFile07 {

  public static void main(String[] args) throws IOException {
    //dosyadaki bütün kelimeleri oku ve yazdır.
    try {
      Files
        .lines(
          Paths.get(
            "D:\\uygulamalar\\Java Uygulamaları\\Lambda\\src\\LambdaDersleri\\DorduncuGun\\LambdaFile"
          )
        )
        .forEach(t -> System.out.println(t));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println(e);
    }

    //Tüm karakterleri büyük harfe dönüştürün ve okuyun

    Files
      .lines(
        Paths.get(
          "D:\\uygulamalar\\Java Uygulamaları\\Lambda\\src\\LambdaDersleri\\DorduncuGun\\LambdaFile"
        )
      )
      .map(t -> t.toUpperCase())
      .forEach(t -> System.out.println(t));

    //metindeki farklı kelimeleri yazdır

    Files
      .lines(
        Paths.get(
          "D:\\uygulamalar\\Java Uygulamaları\\Lambda\\src\\LambdaDersleri\\DorduncuGun\\LambdaFile"
        )
      )
      .map(t -> t.split(" "))
      .flatMap(Arrays::stream)
      .map(t -> t.replaceAll("\\W", ""))
      .distinct()
      .forEach(t -> System.out.println(t));
  }
}
