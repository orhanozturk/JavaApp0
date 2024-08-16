/*-----------------------------------------------------
  	FILE		: NumberUtil.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 16.02.2023
  	
  	Aim:
  	
  	
  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free
   
 -----------------------------------------------------*/

package com.orhn.util;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.log10;
import static java.lang.Math.abs;

public final class NumberUtil {

    private static final String [] ONES;
    private static final String [] TENS;

    static {
        ONES = new String[]{"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
        TENS = new String[]{"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    }

    private NumberUtil()
    {
    }

    private static int [] getDigits(long a, int n)
    {
        a = Math.abs(a);
        int [] result = new int[a == 0 ? 1 : (int)(log10(a) / n) + 1];
        int powOfTen = (int)pow(10, n);

        for (int i = result.length - 1; i >= 0; result[i--] = (int)(a % powOfTen), a /= powOfTen)
            ;

        return result;
    }

    private static String numToText3DigitsTR(String str, int val)
    {
        int a = val / 100;
        int b = val / 10 % 10;
        int c = val % 10;

        if (a != 0) {
            if (a != 1)
                str += ONES[a];
            str += "yüz";
        }

        if (b != 0)
            str += TENS[b];

        if (c != 0)
            str += ONES[c];

        return str;
    }

    private static String numToText3DigitsTR(int val)
    {
        return val == 0 ? "sıfır" : numToText3DigitsTR(val < 0 ? "eksi" : "", Math.abs(val));
    }

    public static boolean areFriends(int a, int b)
    {
        return sumFactors(a) == b && sumFactors(b) == a;
    }

    public static int calculateDigitalRoot(int a)
    {
        int root = abs(a);

        while (root > 9)
            root = digitsSum(root);

        return root;
    }

    public static int countDigits(long a)
    {
        return a == 0 ? 1 : (int)log10(abs(a)) + 1;
    }

    public static int digitsSum(int a)
    {
        int sum = 0;

        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }

        return sum;
    }

    public static int factorial(int n)
    {
        int result = 1;

        for (int i = 2; i <= n; ++i)
            result *= i;

        return result;
    }
    public static int fibonacciNumber(int n)
    {
        if (n <= 2)
            return n - 1;

        int prev1 = 1, prev2 = 0, val = 0;

        for (int i = 2; i < n; ++i) {
            val = prev1 + prev2;
            prev2 = prev1;
            prev1 = val;
        }

        return val;
    }

    public static int [] getDigits(long a)
    {
        return getDigits(a, 1);
    }

    public static int [] getDigitsInTwos(long a)
    {
        return getDigits(a, 2);
    }

    public static int [] getDigitsInThrees(long a)
    {
        return getDigits(a, 3);
    }

    public static int getDigitsPowSum(int a)
    {
        int n = countDigits(a);
        int total = 0;

        while (a != 0) {
            total += pow(a % 10, n);
            a /= 10;
        }

        return total;
    }

    public static int getHardyRamanujanPairCount(int a)
    {
        int count = 0;

        EXIT_LOOP:
        for (int x = 1; x * x * x < a; ++x)
            for (int y = x + 1; x * x * x + y * y * y <= a; ++y) {
                if (x * x * x + y * y * y == a) {
                    if (++count == 2)
                        break EXIT_LOOP;

                    ++x;
                }
            }
        return count;
    }

    public static int getPrime(int n)
    {
        int count = 0;
        int val = 2;

        for (;;) {
            if (isPrime(val))
                ++count;

            if (count == n)
                return val;

            ++val;
        }
    }

    public static int indexOfPrime(long a)
    {
        int i = 1;
        long val = 2;

        for (;;) {
            if (val == a)
                return i;

            if (isPrime(val))
                ++i;

            ++val;
        }
    }
    public static boolean isArmstrong(int a)
    {
        return a >= 0 && getDigitsPowSum(a) == a;
    }

    public static boolean isDecimalHarshad(int a)
    {
        return a > 0 && a % digitsSum(a) == 0;
    }

    public static boolean isHardyRamanujan(int a)
    {
        return a > 0 && getHardyRamanujanPairCount(a) == 2;
    }

    public static boolean isPerfect(int a)
    {
        return sumFactors(a) == a;
    }

    public static boolean isPrime(long a)
    {
        if (a <= 1)
            return false;

        if (a % 2 == 0)
            return a == 2;

        if (a % 3 == 0)
            return a == 3;

        if (a % 5 == 0)
            return a == 5;

        if (a % 7 == 0)
            return a == 7;

        for (long i = 11; i * i <= a; i += 2)
            if (a % i == 0)
                return false;

        return true;
    }

    public static boolean isSuperPrime(long a)
    {
        return isPrime(a) && isPrime(indexOfPrime(a));
    }

    public static int max(int a, int b, int c)
    {
        return Math.max(Math.max(a, b), c);
    }

    public static int mid(int a, int b, int c)
    {
        if (a <= b && b <= c || c <= b && b <= a)
            return b;

        if (b <= a && a <= c || c <= a && a <= b)
            return a;

        return c;
    }

    public static int min(int a, int b, int c)
    {
        return Math.min(Math.min(a, b), c);
    }

    public static void printCollatz(int n)
    {
        if (n <= 0) {
            System.out.println("Geçersiz sayı");
            return;
        }

        System.out.println(n);

        while (n != 1)
            System.out.println(n = (n % 2 == 0) ? (n / 2) : (3 * n + 1));
    }

    public static void printGoldBach(int val)
    {
        for (int a = 2; a < val; ++a) {
            int b = val - a;

            if (isPrime(a) && isPrime(b) && a <= b)
                System.out.printf("%d + %d = %d == %d%n", a, b, a + b, val);
        }
    }

    public static int sumFactors(int a)
    {
        if (a == 1)
            return 1;

        int result = 0;
        int sqrtVal = (int)sqrt(a);

        for (int i = 2; i <= sqrtVal; ++i)
            if (a % i == 0)
                result += (i == a / i) ? i : (i + a / i);

        return result + 1;
    }
}
