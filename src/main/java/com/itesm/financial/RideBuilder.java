package com.itesm.financial;

import java.util.Date;

//Concrete builder for Rides
public class RideBuilder {
    private Ride ride;

    private long taxiId;
    private Date pickUpTime;
    private Date dropOffTime;
    private int passengerCount;
    private double tripDistance;
    private double tollsAmount;

    public static RideBuilder getBuilder() {return new RideBuilder();}


    public RideBuilder withTaxiId(long taxiId){
        this.taxiId = taxiId;
        return this;
    }

    public RideBuilder withPickUpTime(Date pickUpTime){
        this.pickUpTime = pickUpTime;
        return this;
    }

    public RideBuilder withDropOffTime(Date dropOffTime){
        this.dropOffTime = dropOffTime;
        return this;
    }

    public RideBuilder withPassengerCount(int passengerCount){
        this.passengerCount = passengerCount;
        return this;
    }

    public RideBuilder withTripDistance(Double tripDistance){
        this.tripDistance = tripDistance;
        return this;
    }

    public RideBuilder withTollsAmount(Double tollsAmount){
        this.tollsAmount = tollsAmount;
        return this;
    }

    public Ride build() {return new Ride(this.taxiId, this.pickUpTime, this.dropOffTime, this.passengerCount, this.tripDistance, this.tollsAmount);}
}
