package com.orhn.app.places;

import java.util.ArrayList;
import java.util.Scanner;

public class StorePlacesToArrayApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Input the initial \"capacity\" value:");
        ArrayList places = new ArrayList(Integer.parseInt(kb.nextLine()));

        for (;;) {
            System.out.print("Input name:");
            String name = kb.nextLine();

            if ("quit".equals(name))
                break;

            System.out.print("Input latitude:");
            double latitude = Double.parseDouble(kb.nextLine());

            System.out.print("Input longitude:");
            double longitude = Double.parseDouble(kb.nextLine());

            places.add(new PlaceInfo(name, latitude, longitude));
            System.out.printf("Size:%d%n", places.size());
        }

        System.out.println("-------------------------------------------------------");

        for (Object o : places) {
            PlaceInfo pi = (PlaceInfo)o;

            System.out.println(pi.toString());
        }

        System.out.printf("Size:%d%n", places.size());
    }
}
