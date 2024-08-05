package com.orhn.app.company;

public class CompanyApp {
    private static Worker getWorker() //Metot herhangi bir yerden bilgileri okuyor olarak düşününüz
    {
        Worker w = new Worker();

        w.setCitizenId("12345678924");
        w.setName("Ali");
        w.setAddress("Şişli");
        w.setFeePerHour(100.4);
        w.setHourPerDay(8);

        return w;
    }

    private static Manager getManager() //Metot herhangi bir yerden bilgileri okuyor olarak düşününüz
    {
        Manager m = new Manager();

        m.setName("Veli");
        m.setCitizenId("12345678916");
        m.setAddress("Mecidiyeköy");
        m.setSalary(30000);
        m.setDepartment("Pazarlama");

        return m;
    }

    private static SalesManager getSalesManager() //Metot herhangi bir yerden bilgileri okuyor olarak düşününüz
    {
        SalesManager sm = new SalesManager();

        sm.setName("Selami");
        sm.setCitizenId("12345678918");
        sm.setAddress("Beykoz");
        sm.setSalary(40000);
        sm.setDepartment("Satış");
        sm.setExtra(10000);

        return sm;
    }

    private static ProjectWorker getProjectWorker() //Metot herhangi bir yerden bilgileri okuyor olarak düşününüz
    {
        ProjectWorker pw = new ProjectWorker();

        pw.setCitizenId("12345678924");
        pw.setName("Ayşe");
        pw.setAddress("Riva");
        pw.setFeePerHour(100.4);
        pw.setHourPerDay(8);
        pw.setFeeFactor(1.5);
        pw.setProjectName("Chat system");

        return pw;
    }


    public static void run()
    {
        HumanResources hr = new HumanResources();
        Manager m = getManager();
        Worker w = getWorker();
        SalesManager sm = getSalesManager();
        ProjectWorker pw = getProjectWorker();

        //...

        hr.payInsurance(m);
        hr.payInsurance(w);
        hr.payInsurance(sm);
        hr.payInsurance(pw);
    }
}