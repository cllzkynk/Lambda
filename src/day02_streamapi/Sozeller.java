package day02_streamapi;

public class Sozeller {

    /*
      - Buyuk veri iceren nesnelerini (Collection vb) fonksiyonel programlama ile islememize imkan sagyan bir API'dir.
      - Stream bir veri yapisi degildir ve bellekte yer tutmaz. Sadece, var olan veri yapilarini girdi olarak alir ve
      girdilerin veri yapisini degistirmeden isler.
      - Verilerin sirali islemlerden (pipeline) gecirilerek islenmesini ve istenilen sonuclarin elde edilmesini saglar.
      Biz bir collection'i aldik belirli islemlerden gecirdik yazdirdik diyelim sirali islemlere soktugumuz icin bu olaya
      pipeline diyoruz.
      - Stream API, olk olarak JAVA8 ile gelmistir ve java.util.stream paketinde yer almaktadir.

      - Neden StreamAPI kullaniyoruz ? Streamapi icerisinde yazilmis hazir method'lar fonksiyonlari destekliyorlar.
     - Stream API icerisindeki method'lar Lambda ifadelerini desteklemektedir.
     Method'lar icerisinde fonksiyonel arayuzler kullandigi icin Lambda ifadelerini kullanmak mumkundur.
     - Dongu vb. islemleri kullanmak yerine hazir method'larin kullanimi sayesinde
     cok daha kisa ve anlasilir kod yazmak mumkundur.
     - ParallelStreams sayesinde multi-threading islemleri yapmak daha kolaydir.
     - Girdi olarak aldigi nesneleri (veri) degistirmedigi icin daha guvenilir program yazmak mumkundur.
     - Deavantaji ise geleneksel dongu tabanli programlamya gore cogu durumda daha yavas sonuc uretebilmektedir.

     - Bir Stream hatti; bir kaynak, O'nu takip eden ve 0(sifir) veya
     daha fazla ara islem ve bir terminal(sinlandirici) islem icerir.
     - Stream Kaynagi : Collection, List, Set, File, Array vb.
     - Stream donduren Method'lar : Filter, map, sort, distinct, limit vb.
     - Terminal Islemleri : foreach, collect, reduce, min, count gibi void veya stream dondurmeyen methodlardir.
     Terminal islemleri Stream'i kapatmak demektir, Stream'i kapatmazsak olmaz.

     int arr [] = {1,2,3,5,9};
     Bu Array'i aldik   arr.Stream() ile stream haline cevirdim ve su hale geldi ;
     1
     2
     3
     5
     9
     arr.Stream().filter(t-> t%2==1)  Tek sayilari aldim ve sonra bunu foreach ile yazdirabilirim.
      arr.Stream().filter(t-> t%2==1).forEach(sout)  butun hali bu sekilde.

     */
}
