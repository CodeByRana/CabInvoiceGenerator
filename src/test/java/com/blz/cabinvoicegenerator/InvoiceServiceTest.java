package com.blz.cabinvoicegenerator;

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
}
