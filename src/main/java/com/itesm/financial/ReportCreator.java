package com.itesm.financial;

public abstract class ReportCreator {
    // DP -> Factory: derivacion para creacion de reportes (Web y Print) 
    public Report getReport(){
        Report rep = createReport();
        return rep;
    }

    public abstract Report createReport();
}
