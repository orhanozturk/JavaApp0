package com.orhn.app.lottery;
import com.orhn.util.array.ArrayUtil;

import java.util.Scanner;

public class NumericLotteryApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;){
            System.out.print("Kaç tane kupon oynamak istersiniz:");
            int n = Integer.parseInt(kb.nextLine());

            NumericLottery lottery = new NumericLottery();

            if(n <= 0)
                break;

            while (n-- > 0)
               ArrayUtil.print(2, lottery.getNumbers());
        }
    }
}
