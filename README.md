# java-examples

Scanner daha kullanımı kolay olabilir ve çoğu durumda tercih edilebilir. Ancak, performans açısından büyük verilerle çalışırken BufferedReader tercih edilebilir.

trim(): Bu işlev, kullanıcı tarafından girilen metnin başındaki ve sonundaki boşlukları kaldırmak için kullanılır. Eğer kullanıcı yanlışlıkla başta veya sonda bir boşluk bırakırsa, bu boşlukları temizler ve sadece metnin kendisini alır.


List<Integer> arr = Stream.of(bufferedReader.readLine()
             .replaceAll("\\s+$", "")
             .split(" "))
             .map(Integer::parseInt);
             
.replaceAll("\\s+$", ""): Bu ifade, replaceAll fonksiyonu aracılığıyla bir regex (düzenli ifade) kullanarak metnin sonundaki boşlukları kaldırır. "\\s+$" ifadesi, bir veya daha fazla boşluğu (\\s+) satırın sonunda ($) bulur ve bunları boş bir dizeyle ("") değiştirir.

.split(" "): split fonksiyonu, metni boşluklara göre parçalara ayırır ve bir dizi haline getirir. Yani, kullanıcıdan alınan giriş satırını boşluklara göre ayırarak bir dizi oluşturur.

Stream.of(...): Stream.of bu diziyi bir akışa dönüştürür. Bir akış, üzerinde işlemler yapılabilen bir veri dizisidir.

.map(Integer::parseInt): map fonksiyonu, her bir öğeyi Integer türüne dönüştürmek için parseInt metoduyla bir işlev uygular.

.collect(toList()): collect fonksiyonu, akıştaki öğeleri toplar. toList() bu öğeleri bir List yapısına toplar.

Sonuç olarak, bu satır kullanıcıdan alınan giriş satırını boşluklara göre ayırır, her bir parçayı tamsayıya dönüştürür ve bunları bir List<Integer> yapısında saklar. Örneğin, kullanıcı "3 4 5 1" gibi bir giriş yaparsa, bu satır bu rakamları içeren bir List<Integer> oluşturur.


