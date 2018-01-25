package com.tw.refactoring.pullingup;

/**
 * @author pzzheng
 * @date 1/18/18
 */
public class Employee {
}

class Salesman extends Employee {
    protected String name;
    protected String age;

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Engineer extends Employee {
    protected String name;
    protected String industry;

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }
}
