package com.tw.refactoring.templatemethod;

/**
 * @author pzzheng
 * @date 1/19/18
 */
public class CapitalStrategyTermLoan extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return 0;
    }
}
