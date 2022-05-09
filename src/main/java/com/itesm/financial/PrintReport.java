package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrintReport extends Report{

    public void createFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    public String createHeaders(String title){
        return title+"\n";
    }

    public String createTableHeaders() {
        return "TaxiID\t\t" +
                "Pickup time\t\t" +
                "Dropoff time\t\t" +
                "Passenger count\t\t" +
                "Trip Distance\t\t" +
                "Total amount\n" +
                "-----------------------------------------------------\n";
    }

    public String closeTableHeaders() {
        return "\n";
    }

    public String addRide(Ride ride) {
        return
                ride.getTaxiId() + " | " +
                ride.getPickUpTime() + " | " +
                ride.getDropOffTime() + " | " +
                ride.getPassengerCount() + " | " +
                ride.getTripDistance() + " | " +
                formatAmount(ride.getTollsAmount()) + "\n";
    }

    public String formatAmount(double amount) {
        if(amount < 0) {
            return "(" + amount + ")";
        }
        return Double.toString(amount);
    }
}
