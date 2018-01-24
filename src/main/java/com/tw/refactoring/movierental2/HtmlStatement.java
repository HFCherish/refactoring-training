package com.tw.refactoring.movierental2;

public class HtmlStatement extends Statement {

    @Override
    protected String footerValue(Customer customer) {
        String total = String.format("</p><p>total: <em>%.1f</em><br>", customer.calTotalAmount());
        String points = String.format("earned points: <em>%.0f</em></p>", customer.calEarnedPoints());
        return total + points;
    }

    @Override
    protected String itemValue(Rental rental) {
        return String.format(rental.movie().name() + ": %.2f<br>", rental.getCharge());
    }

    @Override
    protected String headerValue(String customerId) {
        return "<h1>Rental record for <em>" + customerId + "</em>:</h1><p>";
    }
}