package Map_Tekrar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2Query02 {

  public static void main(String[] args)
    throws ClassNotFoundException, SQLException {
    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection con = DriverManager.getConnection(
      "jdbc:oracle:thin:@localhost:1521:xe",
      "hr",
      "hr"
    );

    Statement st = con.createStatement();

    /*ornek1  bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz*/

    ResultSet tablo1 = st.executeQuery("SELECT * FROM bolumler");

    while (tablo1.next()) {
      System.out.println(
        tablo1.getInt(1) +
        " " +
        tablo1.getString(2) +
        "  \t" +
        tablo1.getString(3)
      );
    }
    System.out.println("===============================");

    /*ornek2  SATIS VE MUHASEBE bolumlerinde calisan personelin
     * isimlerini ve maaslarini, maas ters sirali olarak listeleyin*/

    String a =
      "SELECT personel_isim, maas" +
      " FROM personel" +
      " WHERE bolum_id IN (10,30)" +
      " ORDER BY maas DESC"; //komutları tırnağın içindeyken enterla alt satıra indirdiğimizde bir
    //karakter boşluk bırakmalıyız ki üstteki komutla yapışmasın

    ResultSet tablo2 = st.executeQuery(a);

    while (tablo2.next()) {
      System.out.println(tablo2.getString(1) + "    \t" + tablo2.getInt(2));
    }

    System.out.println("===============================");
    /*  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini
		  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa
		  bile bolum ismi gosterilmelidir.   */

    ResultSet sonuc1 = st.executeQuery(
      "SELECT bolum_isim, personel_isim, maas" +
      " FROM bolumler b" +
      " LEFT JOIN personel p" +
      " ON b.bolum_id=p.bolum_id" +
      " ORDER BY bolum_isim, maas"
    );

    while (sonuc1.next()) {
      System.out.println(
        sonuc1.getString(1) +
        "    \t" +
        sonuc1.getString(2) +
        "     \t" +
        sonuc1.getInt(3)
      );
    }

    System.out.println("=====================================");
    /*=======================================================================
	  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
	========================================================================*/

    ResultSet sonuc2 = st.executeQuery(
      "SELECT bolum_isim, personel_isim, maas" +
      " FROM personel p" +
      " FULL JOIN bolumler b " +
      " ON b.bolum_id=p.bolum_id" +
      " ORDER BY maas DESC" +
      " FETCH NEXT 10 ROWS ONLY"
    );

    while (sonuc2.next()) {
      System.out.println(
        sonuc2.getString(1) +
        "\t\t" +
        sonuc2.getString(2) +
        "\t\t" +
        sonuc2.getInt(3)
      );
    }

    con.close();
    st.close();
    tablo1.close();
    tablo2.close();
    sonuc1.close();
    sonuc2.close();
  }
}
