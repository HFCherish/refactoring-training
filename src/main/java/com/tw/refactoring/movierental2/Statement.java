package com.tw.refactoring.movierental2;

import java.util.stream.Collectors;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public abstract class Statement {
    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();

        result.append(headerValue(customer.id()));

        result.append(customer.rentals().stream().map(rental -> itemValue(rental))
                .collect(Collectors.joining()));

        result.append(footerValue(customer));

        return result.toString();
    }

    protected abstract String footerValue(Customer customer);

    protected abstract String itemValue(Rental rental);

    protected abstract String headerValue(String customerId);
}
