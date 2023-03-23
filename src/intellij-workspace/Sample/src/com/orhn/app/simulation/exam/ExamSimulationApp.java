package com.orhn.app.simulation.exam;

public class ExamSimulationApp {
    public static void run()
    {
        ExamSimulation mathSimulation = new ExamSimulation("Matematik");
        ExamSimulation chemistrySimulation = new ExamSimulation("Kimya");

        mathSimulation.run();
        chemistrySimulation.run();

        mathSimulation.printReport();
        chemistrySimulation.printReport();
    }
}