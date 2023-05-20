/*----------------------------------------------------------------------------------------------------------------------
	Sınıflar arası ilişkiler: Sınıflar arası ilişkiler aslında nesneler arasındaki ilişkiler olarak düşünülmeldir. Örneğin,
	uçak ile pilotları arasında bir ilişki vardır. Ya da araba ile motoru arasında da bir ilişki vardır. Burada uçak
	nesnesinin pilot nesneleri arasındaki ilişkiden bahsedilir. Benzer şekilde araba nesnesinin motor nesnesi olan
	ilişkiden bahsedilmiş olur. Ancak şüphesiz bu ilişkilere uygun olarak sınıflar yazılmalıdır.

	Nesne yönelimli programlama tekniği kullanılarak geliştirilecek bir projenin kodlama aşamasına gelindiğinde önce sınıflar
	ve aralarındaki ilişkiler belirlenir. Sonra kodlamaya geçilir. Sınıflar ve aralarındaki ilişkiler belirlenirken, sınıfların
	ve nesnelerin konuya (domain) ilişkin durumları düşünülür.

	Anahtar Notlar: Bir projenin müşteri ile görüşülmesinden (ihtiyaçların belirlenmesi için) teslime (deployment) kadar
	geçen sürecin çeşitli şemalar ile anlatılmasını sağlayan UML (Unified Modeling Language) denilen bir araç bazı
	durumlarda kullanılabilmektedir. Bu aracın önemli ve geliştiriciler ilgilendiren şemalarından birisi
	"sınıf şeması (class diagram)"'dır. Bu şema, kodlamaya yönelik ve kodlamaya başlamadan önce yapılır. Bu şemada sınıfların
	detayları ve aralarındaki ilişkiler çizilir.

	Anahtar Notlar: UML her zaman ve her detayı ile kullanılmalı mıdır? Bunun için verilecek cevap nettir: Hayır.
	Gerektiğinde ve gerektiği kadar kullanılmalıdır.

 	Anahtar Notlar: Kavram ya da kavramlar modellenirken genel durumlar düşünülür. İstisna niteliğinde olabilecek durumlar
 	modelleme yapılırken - genel olarak - göz önünde bulundurulmaz. Aksi durumda hiçbir şey modellenemez. Örneğin,
 	araba ile motoru arasındaki "X" ilişki için şu koşullar olsun ya da tersine aşağıdaki koşullar gerçeklendiğinde araba
 	ile motoru arasındaki ilişki "X" olsun:
 		1. Araba nesnesine ait motor nesnesi başka bir araba nesnesi veya başka bir nesne tarafından kullanılamaz
 		2. Araba nesnesine ait motor nesnesinin ömrü hemen hemen araba ile başlayıp, araba ile son bulacak
	Burada, ikinci madde bazı durumlarda gerçeklenmeyebilir. Ama bu ilişkin genel durumunu bozmaz.

	Bir sınıfın derlenebilmesi için başka bir sınıfın varolması gerektiği duruma "bağımlılık (dependency)" denir. Aslında bu
	kavram sadece sınıflara özgü değildir. Örneğin bir metodun içerisinde başka bir metodun çağrılması durumunda çağrılan
	metodun var olması gerekir. Bu anlamda çağıran metot çağrılan metoda bağımlıdır. Burada bağımlılık terimi sınıflar
	arasında ele alacağız.

	İki sınıf arasında aşağıdaki ilişkilerden ya hiçbirisi yoktur ya da bir tanesi vardır:
	1. İçerme (composition) (has a): A ve B arasındaki "A has a B" ilişkisi için aşağıdaki iki koşulun da gerçeklenmesi
	gerekir, ya da tersine aşağıdaki iki koşulun da gerçeklendiği ilişkidir:
		- A nesnesine ait B nesnesi başka bir nesne tarafından kullanılmayacak
		- A nesnesine ait B nesnesi ömrüne hemen hemen A ile başlayacak ve hemen hemen A ile ömrü son bulacak.
	Bu ilişkide A nesnesi kendisine ait B nesnesini istediği bir durumda (birçok durumda ya da hemen her durumda)
	kullanabilmektedir.

	2. Birleşme (aggregation) (holds a):  A ve B arasındaki "A holds a B" ilişkisi, composition ilişkisinin kurallarının
	en az bir tanesinin gerçeklenmediği bütünsel kullanım ilişkisidir.

	3. Çağrışım (association): A nesnesinin B nesnesini ihtiyacı olduğunda kullanması, saklamaması ilişkisidir. Yani
	bütünsel bir kullanım yoktur. Bu kullanıma "parçalı (partial)" da denir

	4. Türetme/Kalıtım (inheritance) (is a): Biyoloji'den programlamaya aktarılmıştır. Biyoloji'de kalıtım ebeveynin (parent)
	özelliklerinin çocuğuna (child) aktarılmasıdır. Programlamaya ilişkin detayları ileride ele alınacaktır

	Anahtar Notlar: Yukarıdaki ilişkilerden "inheritance dışında kalan ilişkiler için Java'da doğrudan sentaks ve semantic
	kurallar yoktur. Dilin genel sentaks kuralları ve semantik kuralları ile ilişkin kuralları doğrultusunda
	gerçekleştirilebilir (implementation). Ancak "inheritance" için Java'da ayrı sentaks ve semantik kurallar vardır.

	Anahtar Notlar: Bazı sınıfların implementasyonları gereği yukarıdaki ilişkilerden hiçbirisi olmayabilir. Ya da
	bazı özel durumlar dolayısıyla da iki sınıf arasında yukarıdaki ilişkilerden biri olmayabilir. Ama ortada yine bir
	bağımlılık (dependency) söz konusudur. Bu da yine genel durumu bozmaz. Böylesi durumlar ileride ele alınacaktır.
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	Car, Plane, Driver, Pilot, Engine sınıfları ve aralarındaki ilişkiler. Örnekte detaylar göz ardı edilmiştir
----------------------------------------------------------------------------------------------------------------------*/


package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		Pilot[] pilots = {new Pilot(1, "Ali Cetinkol", 10000), new Pilot(2, "Orhan ozturk",
				7000), new Pilot(3, "Mahmut Tuncer", 5000)};
		Plane p = new Plane(4, pilots);

		p.fly();
	}
}

class  Plane{
	private Engine[] m_engines;
	private Pilot[] m_pilots;

	private void startEngines()
	{
		for (Engine engine : m_engines) {
			engine.startEngine();
		}
	}
	private void accelerateEngines()
	{
		for (Engine engine : m_engines) {
			engine.acclerateEngine();
		}
	}
	private void slowEngines()
	{
		for (Engine engine : m_engines) {
			engine.slowEngine();
		}
	}
	private void stopEngines()
	{
		for (Engine engine : m_engines) {
			engine.stopEngine();
		}
	}

	public Plane(int engineCount, Pilot [] pilots)
	{
		m_pilots = pilots;
		m_engines = new Engine[engineCount];

		for (int i = 0; i < engineCount; ++i)
			m_engines[i] = new Engine();
	}

	public void fly()
	{
		System.out.println("Pilots:");
		for (Pilot p: m_pilots) {
			System.out.printf("%d. %s, %d%n", p.getTitle(), p.getName(), p.getFlightDuration());
		}

		startEngines();
		accelerateEngines();
		//..

		System.out.println("Flying...");
		//..

		slowEngines();

		//..
		stopEngines();

	}
}

class Pilot{
	private int m_title;
	private String m_name;
	private int m_flightDuration;

	public Pilot(int title, String name, int flightDuration)
	{
		m_title = title;
		m_name = name;
		m_flightDuration = flightDuration;
	}

	public int getTitle() {
		return m_title;
	}

	public void setTitle(int m_title) {
		this.m_title = m_title;
	}

	public String getName() {
		return m_name;
	}

	public void setName(String m_name) {
		this.m_name = m_name;
	}

	public int getFlightDuration() {
		return m_flightDuration;
	}

	public void setFlightDuration(int m_flightDuration) {
		this.m_flightDuration = m_flightDuration;
	}
}
class Engine{
	//...
	public void startEngine()
	{
		System.out.println("Start Engine");
	}

	public void acclerateEngine()
	{
		System.out.println("Accelerate Engine");
	}

	public void slowEngine()
	{
		System.out.println("Slow Engine");
	}
	public void stopEngine()
	{
		System.out.println("Stop Engine");
	}

}