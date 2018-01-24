package com.tw.refactoring.movierental;

import j2html.TagCreator;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

import java.util.Arrays;

public class HtmlStatement implements Statement<ContainerTag> {

    @Override
    public ContainerTag statement(Customer customer) {
        return TagCreator.html(
                TagCreator.body(
                        TagCreator.h1(TagCreator.text("Rental record for "), TagCreator.em(customer.id()), TagCreator.text(":")),

                        TagCreator.p(
                                customer.rentals().stream()
                                        .flatMap(rental -> Arrays.asList(TagCreator.text(String.format(rental.movie().name() + ": %.2f", rental.getCharge())), TagCreator.br()).stream())
                                        .toArray(DomContent[]::new)),

                        TagCreator.p(
                                TagCreator.text("total: "), TagCreator.em(String.format("%.1f", customer.calTotalAmount())), TagCreator.br(),
                                TagCreator.text("earned points: "), TagCreator.em(String.format("%.0f", customer.calEarnedPoints())))
                )
        );
    }
}