package com.tw.refactoring.constructor;

import java.time.LocalDate;

/**
 * @author pzzheng
 * @date 1/19/18
 */
public final class Loan {
    private final double commitment;
    private final int riskRating;
    private final double outstanding;
    private final LocalDate maturity;
    private final LocalDate expire;
    private final CapitalStrategy capitalStrategy;

//    创建一个定期贷款（term loan）
    public Loan(double commitment, int riskRating, LocalDate maturity) {
//        this(commitment, riskRating, maturity, null);
        this.commitment = commitment;
        this.riskRating = riskRating;
        this.maturity = maturity;
        outstanding = 0;
        expire = null;
        capitalStrategy = null;
    }

//    创建一个循环贷款（revolving loan）
    public Loan(double commitment, int riskRating, LocalDate maturity, LocalDate expire) {
//        this(commitment, riskRating, 0.00, maturity, expire);
        this.commitment = commitment;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expire = expire;

        capitalStrategy = null;
        outstanding = 0;
    }

//    创建一个循环定期贷款
    public Loan(double commitment,
                int riskRating,
                double outstanding,
                LocalDate maturity,
                LocalDate expire) {

//        this(null, commitment, riskRating, outstanding, maturity, expire);
        this.commitment = commitment;
        this.riskRating = riskRating;
        this.outstanding = outstanding;
        this.maturity = maturity;
        this.expire = expire;
        capitalStrategy = null;
    }

//    创建一个循环定期贷款，采用特定的风险调整的资本策略
    public Loan(final CapitalStrategy capitalStrategy,
                double commitment,
                int riskRating, double outstanding,
                LocalDate maturity,
                LocalDate expire) {

        CapitalStrategy realCapitalStrategy = capitalStrategy;
        if (realCapitalStrategy == null) {
            if (expire == null) {
                realCapitalStrategy = new CapitalStrategyTermLoan();
            } else if (maturity == null) {
                realCapitalStrategy = new CapitalStrategyRevolver();
            } else {
                realCapitalStrategy = new CapitalStrategyRevolveTermLoan();
            }
        }

        this.commitment = commitment;
        this.maturity = maturity;
        this.expire = expire;
        this.riskRating = riskRating;
        this.outstanding = outstanding;
        this.capitalStrategy = realCapitalStrategy;
    }

    public double getUnusedPercentage() {
        return 0;
    }

    public double getCommitment() {
        return commitment;
    }

    public LocalDate getExpire() {
        return expire;
    }
}
