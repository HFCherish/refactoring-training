package com.tw.refactoring.movierental2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public final class Customer {
    private final String id;
    private final List<Rental> rentals;

    public Customer(String id) {
        this.id = id;
        this.rentals = Collections.emptyList();
    }

    private Customer(String id, List<Rental> rentals) {
        this.id = id;
        this.rentals = rentals;
    }

    public double calEarnedPoints() {
        return rentals.stream().mapToDouble(Rental::points).sum();
    }

    public double calTotalAmount() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    public String id() {
        return id;
    }

    public List<Rental> rentals() {
        return Collections.unmodifiableList(rentals);
    }

    public Customer rent(final Movie movie, int daysRented) {
        return new Customer(id, new ArrayList<Rental>(rentals) {{
            add(new Rental(movie, daysRented));
        }});
    }

    public String statement() {
        StringBuilder result = new StringBuilder();

//        add header
        result.append("Rental record for " + id + ": \n");

//        add detail
        result.append(rentals.stream().map(rental -> String.format("\t" + rental.movie().name() + ": %.2f\n", rental.getCharge()))
                .collect(Collectors.joining()));

//        add footer
        double total = calTotalAmount();
        result.append(String.format("total: %.1f\n", total));
        double earnedPoints = calEarnedPoints();
        result.append(String.format("earned points: %.0f\n", earnedPoints));

        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder();

//        add header
        result.append("<h1>Rental record for <em>" + id + "</em>:</h1><p>");

//        add detail
        result.append(rentals.stream().map(rental -> String.format(rental.movie().name() + ": %.2f<br>", rental.getCharge()))
                .collect(Collectors.joining()));

//        add footer
        double total = calTotalAmount();
        result.append(String.format("</p><p>total: <em>%.1f</em><br>", total));
        double earnedPoints = calEarnedPoints();
        result.append(String.format("earned points: <em>%.0f</em></p>", earnedPoints));

        return result.toString();
    }
}
