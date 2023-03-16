/*-----------------------------------------------------
  	FILE		: StringUtil.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 16.02.2023
  	
  	Aim:
  	
  	
  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free
   
 -----------------------------------------------------*/

package com.orhn.util;

import java.util.Scanner;
import java.util.Random;

public class StringUtil {
	
	/*----------------------------------------------------------------------------------------------------------------------	 
	Sınıf Çalışması: Parametresi ile aldığı bir yazının ilk harfi büyük geri kalan harfleri küçük olacak şekilde ve
 	harf dışı karakterler de aynı kalacak şekilde bir yazı döndüren capitalizeWS isimli metodu StringUtil sınıfı 
 	içerisinde yazınız ve aşağıdaki kod ile test ediniz. Metot yazının başında boşluk karakterleri olsa bile ilk 
 	boşluk olmayan harfi büyütecek şekilde yazılacaktır
 	Örnek:   jAVA Programcısı ÇOK çalışmalıdır ->   Java programcısı çok çalışmalıdır
   ----------------------------------------------------------------------------------------------------------------------*/
	public static String capitalizeWS(String str)
	{
		int i;
		int len = str.length();
		
		for (i = 0; i < len && Character.isWhitespace(str.charAt(i)); i++) 
			;
		
		return i == len ? str : str.substring(0, i) + Character.toUpperCase(str.charAt(i)) + str.substring(i + 1).toLowerCase();
	}
	
	/*----------------------------------------------------------------------------------------------------------------------	 
	Sınıf Çalışması: Klavyeden elma girilene kadar alınan yazıların arasında - karakteri olacak birleştirilmiş bir
	String oluşturan programı yazınız.
	Örneğin ankara istanbul izmir girilirse -> ankara-istanbul-izmir
	Örneğin: ankara girilirse -> ankara
	Açıklamalar:
	- Tamamı whitespace karakterlerden oluşan ve boş string yazıya eklenmeyecektir
	----------------------------------------------------------------------------------------------------------------------*/
	public static void concatWithHpyhen()
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Yazıları girmeye baslayınız:");
		String str = "";
		String s;
		
		while (!(s = kb.nextLine()).equals("elma")) {
			if(s.trim().isEmpty())
				continue;
			
			str += s + "-";
		}
		
		if(!str.isEmpty())
			str = str.substring(0, str.length() - 1);
		
		System.out.println(str);
	}
	
	public static int countString(String s1, String s2)
	{
		int count = 0;
	
		for(int i = 0; (i = s1.indexOf(s2, i)) != -1; ++i, ++count)
			;
		
		return count;
	}

	public static String changeCase(String s)
	{
		char []c = s.toCharArray();

		for(int i = 0; i < c.length; ++i)
			c[i] = Character.isLowerCase(c[i]) ? Character.toUpperCase(c[i]) : Character.toLowerCase(c[i]);

		return String.valueOf(c);
	}

	public static int countStringIgnoreCase(String s1, String s2)
	{
		return countString(s1.toLowerCase(), s2.toLowerCase());
	}
	
	public static String getRandomTextTR(Random r, int n)
	{
		return getRandomText(r, n, "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ");	
	}
	
	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new Random(), n);
	}
	
	public static String getRandomTextEN(Random r, int n)
	{
		return getRandomText(r, n, "abcdefghijklmnopqrstuwxvyzABCDEFGHIJKLMNOPQRSTUWXVYZ");
	}

	public static String [] getRandomTextsTR(int count, int min, int max)
	{
		return getRandomTextsTR(new Random(), count, min, max);
	}

	public static String [] getRandomTextsTR(Random r, int count, int min, int max)
	{
		String [] result = new String[count];
		for(int i = 0; i < count; ++i)
			result[i] = getRandomTextTR(r, r.nextInt(min, max + 1));

		return result;
	}
	public static String getRandomTextEN(int n)
	{
		return getRandomTextEN(new Random(), n);
	}
	
	public static String getRandomText(Random r, int n, String sourceText)
	{
		String str = "";
		int len = sourceText.length();
		
		for(int i = 0; i < n; ++i)
			str += sourceText.charAt(r.nextInt(len));
		
		return str;
	}
	
	public static String padLeading(String s, int len, char ch)
	{
		int length = s.length();
		
		return len <= length ? s : repeat(len - length, ch) + s;
	}
	
 	public static String padLeading(String s, int len)
 	{
 		return padLeading(s, len, ' ');
 	}
 	
 	public static String padTrailing(String s, int len, char ch)
 	{
 		int length = s.length();
		
		return len <= length ? s : s + repeat(len - length, ch);
 	}
 	
 	public static String padTrailing(String s, int len)
 	{
 		return padTrailing(s, len, ' ');
 	}
 	 	
 	public static String repeat(int count, char ch)
 	{
 		return String.format("%" + count + "c", ' ').replace(' ', ch);
 	}
 	
 	public static String getLastLongestPalindrome(String s)
	{
		String result = "";
		
		int end = s.length();
		
		while (end != 0) {
			int begin = 0;
			
			while (begin != end) {
				String str = s.substring(begin++, end);
				
				if(str.length() > 1 && isPalindrome(str) && result.length() < str.length())
					result = str;
			}
			
			--end;
		}
		
		return result;
		
	}
	
	public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char cLeft = Character.toLowerCase(s.charAt(left));
			
			if(!Character.isLetter(cLeft)) {
				++left;
				continue;
			}
			
			char cRight = Character.toLowerCase(s.charAt(right));
			
			if(!Character.isLetter(cRight)) {
				--right;
				continue;
			}
			
			if(cLeft != cRight)
				return false;
			
			++left;
			--right;
		}
		
		return true;
	}
	
	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
	}
	
	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
	}
	
	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();
		
		for (int i = 0; i < len; i++)
			if(!s.contains(alphabet.charAt(i) + ""))
				return false;
		
		return true;
	}
	
	public static String reverse(String str)
	{
		String s = "";
		
		for (int i = str.length() - 1; i >= 0; --i)
			s += str.charAt(i);
		
		return s;
	}

	public static String squeeze(String s1, String s2)
	{
		int len = s1.length();
		char[] c = new char[len];
		int idx = 0;

		for (int i = 0; i < len; ++i){
			char ch = s1.charAt(i);
			if(!s2.contains(ch + ""))
				c[idx++] = ch;
		}

		return String.valueOf(c, 0, idx);
	}

	public static String join(String [] s, char delimiter)
	{
		return join(s, delimiter + "");
	}

	public static String join(String [] s, String delimiter)
	{
		return String.join(delimiter, s);
	}
}