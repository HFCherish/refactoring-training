package com.tw.refactoring.movierental;

import j2html.tags.ContainerTag;
import org.junit.Before;
import org.junit.Test;

import static j2html.TagCreator.*;
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
        String result = customer.statement();

        assertThat(result, is("Rental record for " + customer.id() + ": \n" +
                "\t" + newMovie.name() + ": 3.00\n" +
                "\t" + forChildren.name() + ": 1.50\n" +
                "\t" + normalMovie.name() + ": 2.00\n" +
                "total: 6.5\n" +
                "earned points: 3"));
    }

    @Test
    public void should_print_html_statement_right() {
        ContainerTag result = customer.htmlStatement();

        assertThat(result.render(), is(html(
                body(
                        h1(text("Rental record for "), em(customer.id()), text(":")),

                        p(
                                text(newMovie.name() + ": 3.00"),
                                br(),
                                text(forChildren.name() + ": 1.50"),
                                br(),
                                text(normalMovie.name() + ": 2.00"),
                                br()),

                        p(
                                text("total: "), em("6.5"), br(),
                                text("earned points: "), em("3"))
                )
        ).render()));

    }
}