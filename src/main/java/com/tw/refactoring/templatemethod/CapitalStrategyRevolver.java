package com.tw.refactoring.templatemethod;

/**
 * @author pzzheng
 * @date 1/19/18
 */
public class CapitalStrategyRevolver extends CapitalStrategy{

    @Override
    public double capital(Loan loan) {
        return 0;
    }
}
