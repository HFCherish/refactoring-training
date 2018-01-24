package com.tw.refactoring.movierental2;

import org.junit.Before;
import org.junit.Test;

import static com.tw.refactoring.movierental2.Statements.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public class CustomerTest {

    private Movie newMovie;
    private Movie forChildren;
    private Movie normalMovie;
    private Customer customer;

    /**
     * @author pzzheng
     */
    @Before
    public void setUp() {
        newMovie = new Movie("new movie", Movie.MovieCatetory.NEW_RELEASE);
        forChildren = new Movie("for children", Movie.MovieCatetory.CHILDREN);
        normalMovie = new Movie("normal movie", Movie.MovieCatetory.NORMAL);
        customer = new Customer("peizhen")
                .rent(newMovie, 1)
                .rent(forChildren, 3)
                .rent(normalMovie, 2);
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_print_statement_right() {
        String result = newTextStatement().value(customer);

        assertThat(result, is("Rental record for " + customer.id() + ": \n" +
                "\t" + newMovie.name() + ": 3.00\n" +
                "\t" + forChildren.name() + ": 1.50\n" +
                "\t" + normalMovie.name() + ": 2.00\n" +
                "total: 6.5\n" +
                "earned points: 3\n"));
    }

    @Test
    public void should_print_html_statement_right() {
        String result = newHtmlStatement().value(customer);
        assertThat(result, is("<h1>Rental record for <em>" + customer.id() + "</em>:</h1>" +
                "<p>" +
                    newMovie.name() + ": 3.00<br>" +
                    forChildren.name() + ": 1.50<br>" +
                    normalMovie.name() + ": 2.00<br>" +
                "</p>" +
                "<p>" +
                    "total: <em>6.5</em><br>" +
                    "earned points: <em>3</em>" +
                "</p>"));
    }


}