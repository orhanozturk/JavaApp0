/*----------------------------------------------------------------------
	FILE        : StringUtil.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 13.11.2022

	Utility class for string operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.orhn.util;

import java.util.ArrayList;
import java.util.Random;

public final class StringUtil {
	private static final String ALPHABET_TR;
	private static final String ALPHABET_EN;
	private static final String ALPHABET_CAPITAL_TR;
	private static final String ALPHABET_CAPITAL_EN;
	private static final String ALPHABET_ALL_TR;
	private static final String ALPHABET_ALL_EN;

	static {
		ALPHABET_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
		ALPHABET_EN = "abcdefghijklmnopqrstuwxvyz";
		ALPHABET_CAPITAL_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
		ALPHABET_CAPITAL_EN = "ABCDEFGHIJKLMNOPQRSTUWXVYZ";
		ALPHABET_ALL_TR = ALPHABET_TR + ALPHABET_CAPITAL_TR;
		ALPHABET_ALL_EN = ALPHABET_EN + ALPHABET_CAPITAL_EN;
	}

	private StringUtil()
	{
	}

	public static String capitalizeWS(String s)
	{
		int i;
		int len = s.length();

		for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
			;

		return i == len ? s : s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1).toLowerCase();
	}

	public static String changeCase(String s)
	{
		char [] c = s.toCharArray();

		for (int i = 0; i < c.length; ++i)
			c[i] = Character.isLowerCase(c[i]) ? Character.toUpperCase(c[i]) : Character.toLowerCase(c[i]);

		return String.valueOf(c);
	}

	public static int countString(String s1, String s2)
	{
		int count = 0;

		for (int i = -1; (i = s1.indexOf(s2, i + 1)) != -1; ++count)
			;

		return count;
	}

	public static int countStringIgnoreCase(String s1, String s2)
	{
		return countString(s1.toLowerCase(), s2.toLowerCase());
	}

	public static String getLastLongestPalindrome(String s)
	{
		String result = "";

		int end = s.length();

		while (end != 0) {
			int begin = 0;

			while (begin != end) {
				String str = s.substring(begin++, end);

				if (str.length() > 1 && isPalindrome(str) && result.length() < str.length())
					result = str;
			}

			--end;
		}

		return result;
	}

	public static String getRandomText(Random r, int n, String sourceText)
	{
		char [] c = new char[n];
		int len = sourceText.length();

		for (int i = 0; i < n; ++i)
			c[i] = sourceText.charAt(r.nextInt(len));

		return String.valueOf(c);
	}

	public static String getRandomTextEN(Random r, int n)
	{
		return getRandomText(r, n, ALPHABET_ALL_EN);
	}

	public static String getRandomTextEN(int n)
	{
		return getRandomTextTR(new Random(), n);
	}

	public static String getRandomTextTR(Random r, int n)
	{
		return getRandomText(r, n, ALPHABET_ALL_TR);
	}

	public static String getRandomTextTR(int n)
	{
		return getRandomTextTR(new Random(), n);
	}

	public static String [] getRandomTextsEN(int count, int min, int max)
	{
		return getRandomTextsEN(new Random(), count, min, max);
	}

	public static String [] getRandomTextsEN(Random r, int count, int min, int max)
	{
		String [] result = new String[count];

		for (int i = 0; i < count; ++i)
			result[i] = getRandomTextEN(r, r.nextInt(min, max + 1));

		return result;
	}

	public static String [] getRandomTextsTR(int count, int min, int max)
	{
		return getRandomTextsTR(new Random(), count, min, max);
	}

	public static String [] getRandomTextsTR(Random r, int count, int min, int max)
	{
		String [] result = new String[count];

		for (int i = 0; i < count; ++i)
			result[i] = getRandomTextTR(r, r.nextInt(min, max + 1));

		return result;
	}

	public static boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			char cLeft = Character.toLowerCase(s.charAt(left));

			if (!Character.isLetter(cLeft)) {
				++left;
				continue;
			}

			char cRight = Character.toLowerCase(s.charAt(right));

			if (!Character.isLetter(cRight)) {
				--right;
				continue;
			}

			if (cLeft != cRight)
				return false;

			++left;
			--right;
		}

		return true;
	}

	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();

		for (int i = 0; i < len; ++i)
			if (!s.contains(alphabet.charAt(i) + ""))
				return false;

		return true;
	}

	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), ALPHABET_EN);
	}

	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), ALPHABET_TR);
	}

	public static String join(String [] s, char delimiter)
	{
		return join(s, delimiter + "");
	}

	public static String join(String [] s, char delimiter, boolean removeEmpties)
	{
		return join(s, delimiter + "", removeEmpties);
	}

	public static String join(String [] s, String delimiter)
	{
		return String.join(delimiter, s);
	}

	public static String join(String [] s, String delimiter, boolean removeEmpties)
	{
		String str = "";

		for (String sVal : s) {
			if (removeEmpties && sVal.isBlank())
				continue;

			str += sVal + delimiter;
		}

		return str.substring(0, str.length() - delimiter.length());
	}

	public static String join(ArrayList list, String delimiter)
	{
		return join(list, delimiter, false);
	}

	public static String join(ArrayList list, char delimiter)
	{
		return join(list, delimiter, false);
	}

	public static String join(ArrayList list, char delimiter, boolean removeEmpties)
	{
		return join(list, delimiter + "", removeEmpties);
	}

	public static String join(ArrayList list, String delimiter, boolean removeEmpties)
	{
		String str = "";

		for (Object o : list) {
			String s = (String)o;

			if (removeEmpties && s.isBlank())
				continue;

			str += s + delimiter;
		}
		return str.substring(0, str.length() - delimiter.length());
	}

	public static String padLeading(String s, int len, char ch)
	{
		int length = s.length();

		return len <= length ? s : (ch + "").repeat(len - length) + s;
	}

	public static String padLeading(String s, int len)
	{
		return padLeading(s, len, ' ');
	}

	public static String padTrailing(String s, int len, char ch)
	{
		int length = s.length();

		return len <= length ? s : (ch + "").repeat(len - length);
	}

	public static String padTrailing(String s, int len)
	{
		return padTrailing(s, len, ' ');
	}

	public static String reverse(String str)
	{
		char [] c = str.toCharArray();

		ArrayUtil.reverse(c);

		return String.valueOf(c);
	}

	public static String squeeze(String s1, String s2)
	{
		int len = s1.length();
		char [] c = new char[len];
		int idx = 0;

		for (int i = 0; i < len; ++i) {
			char ch = s1.charAt(i);

			if (!s2.contains(ch + ""))
				c[idx++] = ch;
		}

		return String.valueOf(c, 0, idx);
	}
	public static String squeezeIgnoreCase(String s1, String s2)
	{
		return squeeze(s1.toLowerCase(), s2.toLowerCase());
	}
}
