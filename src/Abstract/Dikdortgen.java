package Abstract;

public class Dikdortgen extends Sekil {

  int uzun;
  int kisa;

  @Override
  public int cevre() {
    return 2 * (kisa + uzun);
  }

  @Override
  public int alan() {
    return kisa * uzun;
  }
}
