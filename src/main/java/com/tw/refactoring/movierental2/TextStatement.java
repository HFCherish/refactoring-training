package com.tw.refactoring.movierental2;

import java.util.stream.Collectors;

public class TextStatement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();

//        add header
        result.append("Rental record for " + customer.id() + ": \n");

//        add detail
        result.append(customer.rentals().stream().map(rental -> String.format("\t" + rental.movie().name() + ": %.2f\n", rental.getCharge()))
                .collect(Collectors.joining()));

//        add footer
        double total = customer.calTotalAmount();
        result.append(String.format("total: %.1f\n", total));
        double earnedPoints = customer.calEarnedPoints();
        result.append(String.format("earned points: %.0f\n", earnedPoints));

        return result.toString();
    }
}