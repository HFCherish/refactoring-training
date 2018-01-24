package com.tw.refactoring.form.template.method;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public class Site {
    protected double units;
    protected double rate;
    public static double TAX_RATE = 0.1;

    public static class ResidentialSite extends Site {
        public double getBillableAmount() {
            double base = units * rate * 0.5;
            double tax = base * Site.TAX_RATE * 0.2;
            return base + tax;
        }
    }

    public static class LifelineSite extends Site {
        public double getBillableAmount() {
            double base = units * rate;
            double tax = base * Site.TAX_RATE;
            return base + tax;
        }
    }
}
