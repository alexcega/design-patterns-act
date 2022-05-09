package com.itesm.financial;

public class WebReportCreator extends ReportCreator {
    @Override
    public Report createReport() {
        return new WebReport();
    }
}
