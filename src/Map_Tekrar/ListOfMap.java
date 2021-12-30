package Map_Tekrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListOfMap {

  public static void main(String[] args) {
    HashMap<String, List<String>> karisik = new HashMap<>();
    List<String> meyveler = new ArrayList<>(
      Arrays.asList("Elma", "Armut", "Çilek")
    );
    List<String> sebzeler = new ArrayList<>(
      Arrays.asList("Kabak", "Patlıcan", "Marul", "Ispanak")
    );
    List<String> vitaminler = new ArrayList<>(
      Arrays.asList("A", "B", "C", "D")
    );
    karisik.put("Meyveler", meyveler);
    karisik.put("Sebzeler", sebzeler);
    karisik.put("Vitaminler", vitaminler);

    System.out.println(karisik.get("Sebzeler").get(1));
  }
}
