/*----------------------------------------------------------------------------------------------------------------------
	Anahtar Notlar: Özellikle Nesne yönelimli programlama tekniğine ilişkin bazı ilkeler söz konusudur. Bu ilkelere
	bir programcı özel bir durum yoksa mutlaka uyar. Bu ilkelere genel olarak "Object Oriented Design Principles" denir.
	Bu ilkeler kısaca "SOLID" olarak bilinir:
	Single Responsibility Principle (SRP)
	Open Closed Principle (OCP)
	Liskov Substitution Principle (LSP)
	Interface Segregation Principle (ISP)
	Dependency Inversion Principle (DIP)

	Bu ilkeler bu kurs ve uygulama kurslarında zaman içerisinde anlaşılacaktır.
	Bu ilkeler birbirlerinden ayrı düşünülmemelidir.
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Anahtar Notlar: Nesne yönelimli programlama tekniği ilerledikçe bir takım genel problemlere yine bir takım genel
	çözümleri öneren ve 4 kişi tarafından hazırlanan kalıplar vardır. Bu problemlere ve çözümlerine  "design patterns"
	denir. Bu anlamnda bu 4 kişiyi temsil etmek amacıyla bu kalıplara "Gof (Gang of Four) patterns" de denir. Gof kalıplarından
	önce ve sonra da bir çok kalıp önerilmiştir. Ancak Gof kalıpları bu anlamda en çok kullanları biçiminde düşünülebilir.

	Anahtar Notlar: Tasarım kalıplarının hepsi heme öğrenilmeli midir? Bu anlamda tasarım kalıplarını çalışmak belli
	bir uygulama geliştirme becerisine sahip olduktan sonra daha verimli olur. Biz bu kursta ve uygulama kurslarında
	bu kalıpların bir çoğunu öğreneceğiz.
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Anahtar Notlar: Programlamada çalışma zamanında herhangi bir nesne ya da değişken için ayrılmayan genel olarak 1 byte'lık
	bölgenin adresine "null address" denir. Java'da bu adres "null" sabiti ile temsil edilir. Bir referansa null atanabilir.
	Bu durumda referansın içerisinde bir adres vardır ancak bu adreste bir nesne yoktur. Ya da daha genel anlatımla null
	adres çalışma zamnında yer ayırma anlamında kullanılmayan bir adrestir. Modern sistemlerde heme hepsinde "null adress"
	sıfır numaralı gözeneğin adresidir. Ancak böyle olmak zorunda değildir. Java programcısı açısından bu adresin sayısal
	değerinin ne olduğunun bir önemi yoktur. Zaten "null" sabiti bu adresi temsil eder. Bir refansın default değeri null'dır.
	null adres (referans) kavramı daha detaylı olarak ileride ele alınacaktır.
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	Singleton: Öyle bir sınıf olsun ki bu sınıf türünden program boyunca yalnızca bir tane nesne yaratılabilsin ve
	bu nesnenin referansı elde edilebilsin

	Anahtar Notlar: Singleton sınıfı'ın bir çok "gerçekleştirimi (implementation)" yapılabilir.

	Anahtar Notlar: Bu kursta Singleton kalıbının hangi durumlarda kullanılacağı ele alınmayacaktır. Yalnızca çeşitli
	implementasyonları yapılacaktır
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2 ? "Aynı nesne " : "Farklı nesneler");
	}
}

class Singleton{
	private static Singleton ms_instance;

	private int m_valeu;

	private Singleton()
	{}

	public static Singleton getInstance()
	{
		if(ms_instance == null)
			ms_instance = new Singleton();

		return ms_instance;
	}

	public int getValue()
	{
		return m_valeu;
	}

	public void setValue(int value)
	{
		m_valeu = value;
	}
}
