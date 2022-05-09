package com.itesm.financial;

import java.io.IOException;
import java.util.List;

// Clase report para el uso de web report y pritn report
public abstract class Report {
    // Principio SOLID -> Open Close : se extiende a partir de aqui sin necesidad de afectar estas funciones, por lo que
    // no es necesario abstraer
    public String createContent(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createHeaders("Taxi Report"));
        builder.append(createTableHeaders());
        rides.forEach( ride -> {
            builder.append(addRide(ride));
        });
        builder.append(closeTableHeaders());

        return builder.toString();
    }

    public abstract void createFile(String content) throws IOException;

    public abstract String createTableHeaders();

    public abstract String createHeaders(String title);

    public abstract String addRide(Ride ride);

    public abstract String formatAmount(double amount);

    public abstract String closeTableHeaders();
}
