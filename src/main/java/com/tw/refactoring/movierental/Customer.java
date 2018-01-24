package com.tw.refactoring.movierental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

}
