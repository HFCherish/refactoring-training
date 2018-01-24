package com.tw.refactoring.movierental;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static j2html.TagCreator.*;
import static java.util.Arrays.asList;

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

    public String statement() {
        return rentals.stream().map(rental -> String.format("\t" + rental.movie().name() + ": %.2f", rental.getCharge()))
                .collect(Collectors.joining("\n",
                        "Rental record for " + id + ": \n",
                        String.format("\ntotal: %.1f" + "\n" + "earned points: %.0f", calTotalAmount(), calEarnedPoints())));
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

    public ContainerTag htmlStatement() {
        return html(
                body(
                        h1(text("Rental record for "), em(id), text(":")),

                        p(
                                rentals.stream()
                                        .flatMap(rental -> asList(text(String.format(rental.movie().name() + ": %.2f", rental.getCharge())), br()).stream())
                                        .toArray(DomContent[]::new)),

                        p(
                                text("total: "), em(String.format("%.1f", calTotalAmount())), br(),
                                text("earned points: "), em(String.format("%.0f", calEarnedPoints())))
                )
        );
    }
}
