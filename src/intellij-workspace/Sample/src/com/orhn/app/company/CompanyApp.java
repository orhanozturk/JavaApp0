package com.orhn.app.company;

public class CompanyApp {
    private  static Worker getWorker() //Metot herhangi bir yerden bilgileri okuyor olarak düşünelim
    {
      Worker w = new Worker();

      w.setCitizenId("123456789");
      w.setName("Ali");
      w.setAddress("Edirne");
      w.setFeePerHour(120.5);
      w.setHourPerDay(8);

      return w;
    }

    private static Manager getManager()//Metot herhangi bir yerden bilgileri okuyor olarak düşünelim
    {
        Manager m = new Manager();

        m.setCitizenId("333444234");
        m.setName("Mehmet");
        m.setAddress("İstanbul");
        m.setSalary(30000);
        m.setDepartment("Pazarlama");

        return m;
    }
    private static SalesManager getSalesManager()//Metot herhangi bir yerden bilgileri okuyor olarak düşünelim
    {
        SalesManager sm = new SalesManager();

        sm.setCitizenId("666633534");
        sm.setName("Nazım");
        sm.setAddress("Ankara");
        sm.setSalary(40000);
        sm.setDepartment("Satış");
        sm.setExtra(10000);

        return sm;
    }

    private static ProjectWorker getProjectWorker()//Metot herhangi bir yerden bilgileri okuyor olarak düşünelim
    {
        ProjectWorker pw = new ProjectWorker();

        pw.setCitizenId("555553535");
        pw.setName("Aysel");
        pw.setAddress("Kocaeli");
        pw.setFeePerHour(120.5);
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

        hr.payInsurance(m);
        hr.payInsurance(w);
        hr.payInsurance(sm);
        hr.payInsurance(pw);
    }
}
