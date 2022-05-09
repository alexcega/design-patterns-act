package com.itesm.financial;

public class PrintReportCreator extends ReportCreator {
    @Override
    public Report createReport() {
        return new PrintReport();
    }
}
