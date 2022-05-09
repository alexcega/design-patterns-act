package com.itesm.financial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {
    //a00824742
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");

        List<Ride> result = new ArrayList<>();

        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                result.add(newRide);
            }
        }

        PrintReportCreator factoryMethod = new PrintReportCreator();
        Report printReport = factoryMethod.createReport();

        WebReportCreator factoryMethod2 = new WebReportCreator();
        Report webReport = factoryMethod2.createReport();

        String htmlReport = webReport.createContent(result);
        String htmlReport2 = printReport.createContent(result);

        webReport.createFile(htmlReport);
        printReport.createFile(htmlReport2);
    }
}
