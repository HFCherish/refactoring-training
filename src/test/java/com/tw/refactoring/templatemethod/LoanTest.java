package com.tw.refactoring.templatemethod;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;


/**
 * @author pzzheng
 * @date 1/19/18
 */
public class LoanTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_get_term_loan() {
        Loan termLoan = new Loan(1000, 1, LocalDate.now());

        assertThat(termLoan.getCommitment(), closeTo(1000, 0.01));
        assertThat(termLoan.getExpire(), is(nullValue()));
    }
}