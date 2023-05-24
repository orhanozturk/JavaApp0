/*-----------------------------------------------------
  	FILE		: PointCommonUtil.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 24.05.2023


  	Friendly Utility class for Point and MutablePoint

  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free

 -----------------------------------------------------*/
package com.orhn.math.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PointCommonUtil {

    private PointCommonUtil(){}

    public static double distance(int x1, int y1, int x2, int y2)
    {
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }
    public static String  toString(int x, int y)
    {
        return String.format("(%d, %d)", x, y);
    }
}
