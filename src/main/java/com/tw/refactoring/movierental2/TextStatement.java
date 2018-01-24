package com.tw.refactoring.movierental2;

public class TextStatement extends Statement {

    @Override
    protected String footerValue(Customer customer) {
        String total = String.format("total: %.1f\n", customer.calTotalAmount());
        String points = String.format("earned points: %.0f\n", customer.calEarnedPoints());
        return total + points;
    }

    @Override
    protected String itemValue(Rental rental) {
        return String.format("\t" + rental.movie().name() + ": %.2f\n", rental.getCharge());
    }

    @Override
    protected String headerValue(String customerId) {
        return "Rental record for " + customerId + ": \n";
    }
}