package com.orhn.math;

public class MutableFraction {
    private int m_a, m_b;

    private static MutableFraction add(int a1, int b1, int a2, int b2)
    {
        return  new MutableFraction(a1*b2 + a2*b1, b1 * b2);
    }

    private static MutableFraction subtract(int a1, int b1, int a2, int b2)
    {
        return  add(a1, b1, -a2, b2);
    }

    private static MutableFraction multiply(int a1, int b1, int a2, int b2)
    {
        return new MutableFraction(a1 * a2, b1 * b2);
    }

    private static MutableFraction divide(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void doWorkForException(String message)
    {
        System.out.println(message);
        System.exit(1); //Exception işlemlerinde ele alınacak
    }

    private static void check(int a, int b)
    {
        if(b == 0){
            if(a == 0){
                doWorkForException("Inderterminate");
            }else{
               doWorkForException("Undefined");
            }
        }
    }

    public MutableFraction()
    {
        m_b = 1;
    }

    public MutableFraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    private void configureSign()
    {
        if(m_b < 0){
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a), m_b);

        for(int i = min; i >= 2; --i)
        {
            if(m_a % i == 0 && m_b % i == 0){
                m_a /= i;
                m_b /= i;
                break;
            }
        }
    }

    private void set(int a, int b)
    {
        if(a == 0){
            m_a = 0;
            m_b = 1;
            return;
        }
        m_a = a;
        m_b = b;
        configureSign();
        simplify();
    }

    public MutableFraction(int a, int b)
    {
        check(a, b);
        set(a, b);
    }
}
