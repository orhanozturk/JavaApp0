/*----------------------------------------------------------------------------------------------------------------------
    Aşağı seviyede heap'de tahsis edilen nesnelere "dinamik ömürlü" nesneler denir. Bu nesnelerin yok edilmesi Java'da
	"çöp toplayıcı (garbage collector)" denilen ve arka planda çalışan bir akış tarafından yapılır. Çöp toplayıcı
	"artık kullanılmayan (garbage collected, eligible)" yani çöp diyebileceğimiz nesneleri yok eder. Burada 3 tane temel
	soru sorulabilir:
	1. Programcı bir nesneyi yok edebilir mi?
	2. Çöp olan yani artık kullanılmayan bir nesne çöp olur olmaz yok edilir mi?
	3. Çöp toplayıcı yok edilmesi gereken bir nesneyi nasıl anlar?

Cevap 1: Java'da programcı bir nesneyi yok edemez. Yani tahsis edilmiş bir alanı geri bırakamaz (free/delete). Programcı
	kod kışı içerisinde nesneyi "garbage collected" duruma getirebilir.

Cevap 2: Çöp toplayıcının ne zaman devreye gireceği standartlarda belirtilmemiştir. Bu çöp toplayıcı ile birlikte,
	JVM ve JRE yazanlara bırakılmıştır (implementation defined/dependent). Hemen devreye gireceği garanti değildir. Programcı
	bu bilinçle ve çöp toplayıcının etkinliğine güvenerek kod yazar.

Cevap 3: Bir nesnenin yok edilebilir yani çöp duruma gelmesi o nesneyi gösteren hiçbir referansın kalmaması demektir.
	Yani nesnenin adresinin hiçbir referans tarafından gösterilmiyor duruma gelmesidir. Bir nesnenin adresinin hangi
	referanslar	tarafından tutulduğu ve özellikle kaç tane referans tarafından tutulduğunun takibi için çeşitli algoritmalar
	kullanılmaktadır. Bu algoritmanın ne ve nasıl olacağı  da yazanlara bırakılmıştır. Biz burada "referans sayma (reference counting)"
	algoritması kullanılıyor varsayımıyla açıklama yapacağız. Referans sayma yönteminde her yaratılan nesne için bir
	referans sayacı tutulur. Bu sayaç genelde nesnenin içerisinde tutulur. Bu yöntemde nesnenin adfresi yeni bir referansa
	atandığında sayaç 1(bir) artırılır. Nesne bir referanstan kopartıldığında sayaç 1(bir) azaltılır. Sayacı sıfır olan
	yani hiçbir referans tarafından gösterilmeyen bir nesne artık "garbage collected" duruma gelmiş olur. Bir program
	sonlandığında tüm nesneler yok edilir
---------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

import com.orhn.util.ArrayUtil;

class App {
	public static void main(String [] args)
	{
	}
}


