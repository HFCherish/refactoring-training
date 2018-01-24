package com.tw.refactoring.movierental;

import java.util.stream.Collectors;

public class TextStatement implements Statement<String> {
    public String statement(Customer customer) {
        return customer.rentals().stream().map(rental -> String.format("\t" + rental.movie().name() + ": %.2f", rental.getCharge()))
                .collect(Collectors.joining("\n",
                        "Rental record for " + customer.id() + ": \n",
                        String.format("\ntotal: %.1f" + "\n" + "earned points: %.0f", customer.calTotalAmount(), customer.calEarnedPoints())));
    }
}