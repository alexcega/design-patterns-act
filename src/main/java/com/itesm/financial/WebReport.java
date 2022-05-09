package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WebReport extends Report{

    public void createFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.html");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    public String createHeaders(String title){
        return "<h1>" + title + "</h1>";
    }

    public String createTableHeaders() {
        return "<table>" +
                "<tr>" +
                    "<th> TaxiID </th>" +
                    "<th> Pickup time </th>" +
                    "<th> Dropoff time </th>" +
                    "<th> Passenger count </th>" +
                    "<th> Trip Distance </th>" +
                    "<th> Total amount </th>" +
                "</tr>";
    }

    public String closeTableHeaders() {
        return "</table>";
    }

    public String addRide(Ride ride) {
        return "<tr>" +
                "<td>" + ride.getTaxiId() + "</td>" +
                "<td>" + ride.getPickUpTime() + "</td>" +
                "<td>" + ride.getDropOffTime() + "</td>" +
                "<td>" + ride.getPassengerCount() + "</td>" +
                "<td>" + ride.getTripDistance() + "</td>" +
                "<td>" + formatAmount(ride.getTollsAmount()) + "</td>" +
                "</tr>";
    }

    public String formatAmount(double amount) {
        if(amount < 0) {
            return "<span style='color:red'>" + amount + "</span>";
        }
        return Double.toString(amount);
    }
}
