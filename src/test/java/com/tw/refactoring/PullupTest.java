package com.tw.refactoring;

import org.junit.Test;

import java.util.Locale;

/**
 * @author pzzheng
 * @date 1/18/18
 */
public class PullupTest {
    /**
     * @author pzzheng
     */
    @Test
    public void test() {
        Salesman salesman = new Salesman();
        System.out.println(salesman.getName());

        Engineer engineer = new Engineer();
        System.out.println(engineer.getName());
    }
}

class Salesman {
    protected String name;
    protected String age;

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Engineer {
    protected String name;
    private String industry;
    private Locale companyLocale;
    private String companyName;

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }
}
