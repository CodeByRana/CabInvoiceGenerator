package com.blz.cabinvoicegenerator;

import com.blz.cabinvoicegenerator.model.InvoiceSummary;
import com.blz.cabinvoicegenerator.model.Ride;
import com.blz.cabinvoicegenerator.service.InvoiceService;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_whenCalculateFare_shouldReturnTotalFare(){

        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25,totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeTest2_whenCalculateFare_shouldReturnTotalFare(){

        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(1.0, 5);
        Assert.assertEquals(15,totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeTest2_whenCalculateFareIsLessThan5_shouldReturnTotalFareAs5(){

        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(0.1, 1);
        Assert.assertEquals(5,totalFare, 0.0);
    }
    @Test
    public void  givenMultipleRide_WhenCalculateFare_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(1.0, 5),
                new Ride(0.1, 1)};
        double totalFare = invoiceService.calculateFare(rides);
        Assert.assertEquals(45, totalFare, 0.0);
    }
    @Test
    public  void givenMultipleRidesCase3_whenCalculateFare_ShouldReturnAggregateTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(1.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary expectedSummery= new InvoiceSummary(3,45);
        InvoiceSummary actualSummery=invoiceService.calculateFares(rides);
        Assert.assertEquals(expectedSummery,actualSummery);
    }
}
