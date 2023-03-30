package com.orhn.app.simulation.lotto;

public class LottoProbabilitySimulationApp {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;){
            System.out.print("Bir sayi giriniz : ");
            int count = Integer.parseInt(kb.nextLine());

            if(count == 0)
                break;

            LottoProbabilitySimulation simulation = new LottoProbabilitySimulation(count);

            simulation.run();

            System.out.printf("1. oyun icin kazanma olasılıgı:%f%n", simulation.getGame1Prob());
            System.out.printf("2. oyun icin kazanma olasılıgı:%f%n", simulation.getGame2Prob());
            System.out.printf("3. oyun icin kazanma olasılıgı:%f%n", simulation.getGame3Prob());
        }
    }
}
