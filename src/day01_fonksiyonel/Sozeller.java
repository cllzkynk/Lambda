package day01_fonksiyonel;

public class Sozeller {

    /*
  - Java8'den once Java. 3 programala paradigmasini destekliyordu :
  1) Prosedurel(Yapisal) Programlama
  2) Nesne Yonelimli Programlama (OOP) {if else for..}
  3) Jenerik (Generic) programlama (Gormedik daha ama <> elmas dedigimiz yapilar bir ornektir) (Java 5 ile eklendi)

  - Java 8 ile birlikte Fonksiyonel Programlama ozelligi sinirli da olsa Java diline girmis oldu.
  Problem vozumunu matematiksel fonksiyonlarin uzerinden gerceklestiren programlama stili.
  Kodlama dili artik Fonksiyonel kisma kaydi . Fonsiyonlar uzerinden yazilmis kodlar.
  Bu isin temeli JavaScript'dir. JS ile yayginlasmistir. Java %100 olarak Fonksiyonel'i destekleyemiyor.
  Fonksiyonel Kodlama nedir ? Her seyi Matematiksel Fonksiyon'larla yapmaya calismaktir.
  Hazir yazilmis fonksiyonlarla yazilan kodlama turu.

  - Imperatif (Emirsel) Programlama : Belirli adimlar uzerinden ilerleyen ve akis kontrolune dayanan programala stilidir.
   Adim adim ilerdigimiz kodlama turudur. (Adim adim tarifi veriyoruz once if yap sonra else sonra for'a git vb..)
  - Declarative : Akis kontrolune odaklanmadan neyin yapilacaginin tanimlandigi programlama stilidir.
  (Tarif, ayrinti olmadan al bunu kullan diyoruz)

  - Java 8'de fonksiyon = method diyebiliriz fakat Fonksiyonel Kodlama olara geciyor ismi .
  Normalde biz 1'den 100'e kadar toplama yapmak icin for kullaniyorduk . Fakat Fonksiyonel Kodlama ile bir tane fonksiyon var
  onu kullaniyoruz ve direkt topluyor (ornek sum[1..100] yazdik direkt topladi) .
  Bu fonksiyonlarin cogu hazir halde java kutuphanesinde var, biz onlari cekip kullanacagiz.

  - Neden kullanmayi tercih ediyoruz ?
  a) Imperatif programlamaya gore daha anlasilir ve daha aciklayici program yazmaya imkan tanir.

  b) Kod yazmaktan ziyade probleme odaklanmaya izin verir. Bir dizi var icinde yuklu miktarda veriler var.
  Bas Harfi "A" olanlari alip yazdiracagiz . Klasik yontemde once diziye gir for kullan degisken ile ata ve
  ekrana yazdir'a odaklaniyoruz ama Fonksiyonel'de bu asamalari dusunmuyoruz belli komutlar var onu alip direkt yapabiliyoruz.

  c) Paralel hesaplamaya daha uygundur. (Daha gormedik ama biz elimizdeki islemleri ayni anda kullanabiliriz
  yani Multi-Threading, elimizde var olan islemcileri efektif bir sekilde kullanmak.)

  d) Yan etkileri azaltir.(Verilerin degistirilemez gibi davranmasini saglar),
  Yan Etki : Siz istemediginiz halde bazi verilerin degistirilmesidir.
  Bir fonksiyon yazdik ve static kullandik diyelim ve bir sekilde degistirmis gibi, bir mantik hatasidir, tespiti zordur.
  Yan etkiler azaltilabilir ornek olarak immutable class'lar.

  - Temeli matematiksel fonksiyon'lara dayaniyor. Fonksiyon bir parametre aliyor ve buna gore bir cikti veriyor.
  f(x) = 5x / x = 3 diyorum f(3) = 15 oluyor.
  Temeli Lambda Hesaplamasina dayanmaktadir. Lambda Hesaplama teorisi, Lisp, Haskell, Ocaml ve
  C++ gibi fonksiyonel dillerin hesaplama modeline esas teskil etti. Sonunda Java8 ile birlikte Java diline de eklenmis oldu.

  - Lambda ifadeleri : Parametrelere ve bir vucuda sahip, ISIMSIZ fonksiyonlardir. Yazin sekli olarak (parametreler) -> {body}
  (x) -> {x*x} , sol taraf parametre ya da parametrelerimiz , sag taraf ise expressions kismimiz.
  Bunun bir diger ismi de Arrow Function olarak geciyor.

  - Bir lambda ifadesi 0 veya daha fazla sayida parametre alabilir ve parametreler virgulle ayrilir.
  (int x, int y) -> {return x+y;}   Buna "explicit" denir.
  x -> x * x                        Buna "implicit" denir. x'de int double String yazmiyor nasil anlayacagiz ?
  Yazdigimiz koda gore kendisi anliyor.

  Parametre tipleri acikca (explicit) tanimlanabilecegi gibi ortulu (implicit) olarakda tanimlanabilir.
  Derleyici context'e bakarak veri tipini anlayabilir.
  Eger parametre tek ise etrafinda bir parantez sart degildir.
  () sifir parametre icin kullanilir.
  Suslu parantezler tek bir ifade icin sart degildir.

  (x) -> System.out.println(x); Parametreyi aliyor ve ekrana yazdiriyor.
  (x) -> x*x; Girilen parametrenin karesini aliyor.
  (x,y) -> x*y; 2 adet parametrenin carpimi aldim.
  (x) -> x*x*x; Verilen parametrenin kupunu aldim.
  (x,y) -> x+y; 2 adet parametreyi toplar.
  () -> System.out.println(); Alt satira gecis yaptirdi.
  (int x, int y) -> x*y; Carpar.

  (x) -> {
  int y=5;
  y = y+x;
  return y: }
  expression sayisi birden fazla ile suslu parantez kullaniyoruz. Suslu parantez varsa ve bir sey dondurmek
  istiyorsak "return" kullanmamiz gerekiyor. (Dipnot : for donguleri ici ne kadar dolu olursa olsun 1 expression sayilir)

  - Lambda bir nesne midir ?
  Tam olarak degildir (Kimliksiz Nesnedir)
  Object sinifindan TURETILMEMISTIR. Dolayisiyla .equals(), .hashcode() vb method'lari desteklemez.
  Lambda ifadelerinde new keywordu olmaz.
  this keyword'u de desteklemez.

  - Lambda Java'da nerede ve nasil kullanilir ?
  Java Fonksiyonel programlamayi %100 desteklemedigi icin Lambda ifadelerini her durumda kullanmak mumkun degildir.
  Java'da Lambda ifadeleri genelde Fonksiyonel Arayuz (Functional Interface) icerisinde kullanilmaktadir.
    a) Sadece bir tek abstract (soyut) method'u olan arayuzlerdir. (Lambda'lar karismasin diye)
    b) default method'lara sahip olabilir.
  Sadece tek method sarti, Lambda ifadelerine uygun olmasini saglamak icindir.
  Not : Java'da method'lar kendi baslarina bir eleman degillerdir. Method'lar diger bir dil elemaninin
  (Sinif, enum, interface...) icinde tanimlanirlar. Bu sebeple, Java ortaminda, bir Lambda ifadesinden
  bir method'a donusum icin "fonksiyonel arayuzlerin" kullanilmasi tercih edilmistir.

  - Java'da kullanici, kendi Fonksiyonel arayuzlerini tanimlayabilir.
  Ancak, Java8 icerisinde 4 kategoride toplam 43 adet hazir arayuz tanimlanmistir.
   a) Kategori isimleri : Function, Supplier, Consumer, Predicate
   b) Kutuphane : java.util.function
   c) Java8 oncesinde olan bazi arayuzler de vardir (Runnable gibi)

   Consumer<T> ==> void tipinde bir fonksiyonel arayuzdur.
   Suplplier<T> ==> Parametre almayan fonksiyonel arayuzdur.
   Predicate<T> ==> Bir sartin degerlendirilmesini saglayan fonksiyonel arayuzdur.
   Function<T,R> ==> T tipinde parametre alan, R tipinde sonuc donduren arayuzdur.
   BiFunction<T, U, R> ===> 2 parametre alip bir sonuc donduren arayuzdur.
   Bunlari ezberlemeye gerek yoktur.
   Javada fonksiyonel arayüzlerin kullanıldığı bazı yüksek seviyeli fonksiyonlar (High Order Function-HOF) bulunmaktadır.
    HOF : Bir fonksyionu (method'u) parametre olarak alabilen ve / veya sonuclari bir fonksiyon olarak dondurebilen donksiyonlardir.
   Hocanin anlatimi :
   void say ( topla() ) { // Yani bir method baska bir method'u dondurebiliyorsa HOF olur.
   }

*/ // Sozeller

    /*
    Ctrl + Space	Basic code completion (the name of any class, method or variable)
Ctrl + Shift + Space	Smart code completion (filters the list of methods and variables by expected type)
Ctrl + Shift + Enter	Complete statement
Ctrl + P	Parameter info (within method call arguments)
Ctrl + Alt + L	Reformat code
Ctrl + Alt + O	Optimize imports
Ctrl + F4	Close active editor tab
Ctrl + Shift + F	Find in path
Ctrl + Shift + R	Replace in path
Ctrl + Shift + S	Search structurally (Ultimate Edition only)
Ctrl + Shift + F7	Highlight usages in file
Ctrl + Alt + F7	Show usages
F9	Resume program
Ctrl + N	Go to class
F12	Go back to previous tool window
Esc	Go to editor (from tool window)
Ctrl + E	Recent files popup
Ctrl + Alt + Left/Right	Navigate back/forward
Shift + F6	Rename
Ctrl + F6	Change Signature
Ctrl + K	Commit project to VCS
Ctrl + T	Update project from VCS
Alt + Shift + C	View recent changes
Ctrl + Alt + Y	Synchronize
Ctrl + Shift + F12	Toggle maximizing editor
Alt + Shift + F	Add to Favorites
Ctrl + Alt + S	Open Settings dialog
Ctrl + Alt + Shift + S	Open Project Structure dialog
     */ // Kisayol Tuslari

}
