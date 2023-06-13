package com.orhn.app.randomgenerator;

import com.orhn.math.MutableFraction;
import com.orhn.math.geometry.Circle;
import com.orhn.util.ArrayUtil;
import com.orhn.util.StringUtil;

import java.util.Random;
import java.util.Scanner;

public class RandomObjectArrayFactory {
    private final Random m_random;

    private Object createObject()
    {
        return switch (m_random.nextInt(4)){
            case 0 -> StringUtil.getRandomTextTR(m_random, m_random.nextInt(10, 15));
            case 1 -> new Circle(m_random.nextDouble(-10, 10));
            case 2 -> ArrayUtil.getRandomArray(m_random, m_random.nextInt(5, 10), 0, 99);
            default -> new MutableFraction(m_random.nextInt(-10, 10), m_random.nextInt(-10, 10));
        };
    }

    public RandomObjectArrayFactory()
    {
        this(new Random());
    }

    public RandomObjectArrayFactory(Random random)
    {
        m_random = random;
    }

    public Object [] getObjects(int count)
    {
        Object [] objects = new Object[count];

        for (int i = 0; i < count; i++) {
            objects[i] = createObject();
        }

        return objects;
    }

}
