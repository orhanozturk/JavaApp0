/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Bir okulda Matematik sınavı ortak olarak yapılıyor olsun. Kaç şube ve herbir şubede kaç öğrenci olduğu
	bilgisi klavyeden alınsın: Öğrencilerin notları rasgele belirlensin. Tüm bu işlemlerden sonra Matamatik sınavı için
	herbir şubenin ayrı ayrı not ortalamaları ile okulun not ortalamasını bulan simülasyonu yazınız.
	Açıklamalar:
		- Notlar int türü ile tutulacaktır
		- Programı mümkün olduğunca nesne yönelimli ve genel düşünerek yazınız
	Not: İleride daha iyisi yazılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

import com.orhn.app.school.LectureInfoParserTest;
import com.orhn.app.simulation.lotto.LottoProbabilitySimulationApp;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		LectureInfoParserTest.run();
	}
}

