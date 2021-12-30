package bireysel_Calismalar;

public interface MesajVerBc2 {

    void merhaba(String mesaj); // abstract method
    default void bye(){         // Default method
        System.out.println("Gule Gule");
    }
}
