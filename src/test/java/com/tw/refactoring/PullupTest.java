package com.tw.refactoring;

import org.junit.Test;

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
    protected String industry;

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }
}
