package com.tw.refactoring.movierental2;

import java.util.stream.Collectors;

public class HtmlStatement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();

//        add header
        result.append("<h1>Rental record for <em>" + customer.id() + "</em>:</h1><p>");

//        add detail
        result.append(customer.rentals().stream().map(rental -> String.format(rental.movie().name() + ": %.2f<br>", rental.getCharge()))
                .collect(Collectors.joining()));

//        add footer
        double total = customer.calTotalAmount();
        result.append(String.format("</p><p>total: <em>%.1f</em><br>", total));
        double earnedPoints = customer.calEarnedPoints();
        result.append(String.format("earned points: <em>%.0f</em></p>", earnedPoints));

        return result.toString();
    }
}