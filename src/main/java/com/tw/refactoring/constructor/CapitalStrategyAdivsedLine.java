package com.tw.refactoring.constructor;

/**
 * @author pzzheng
 * @date 1/19/18
 */
public class CapitalStrategyAdivsedLine extends CapitalStrategy{

    @Override
    public double capital(Loan loan) {
        return loan.getCommitment()
                * loan.getUnusedPercentage()
                * duration(loan)
                * riskFactorFor(loan);
    }

    private double duration(Loan loan) {
        return 0;
    }

    private double riskFactorFor(Loan loan) {
        return 0;
    }
}
