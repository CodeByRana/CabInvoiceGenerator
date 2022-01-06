package com.blz.cabinvoicegenerator.service;

import com.blz.cabinvoicegenerator.model.InvoiceSummary;
import com.blz.cabinvoicegenerator.model.Ride;

public class InvoiceService {

    private final double COST_PER_KM = 10.0;
    private final int COST_PER_MIN = 1;
    private final double MIN_FARE = 5.0;

    //Total fare calculate
    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;

        //3rd way
        return Math.max(totalFare, MIN_FARE);
    }

    //Step-2 Multiple Rides (Calculate the aggregate total for all)
    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride: rides) {
            totalFare += calculateFare(ride.getDistance(),ride.getTime());
        }
        return  totalFare;
    }
    //Invoice Summary
    public InvoiceSummary calculateFares(Ride[] rides) {
        double totalFare=0.0;
        for(Ride ride:rides)
        {
            totalFare+=calculateFare(ride.getDistance(),ride.getTime());
        }
        System.out.println("rides : " +rides.length+" Fare : "+totalFare);
        return new InvoiceSummary(rides.length,totalFare);
    }
}
