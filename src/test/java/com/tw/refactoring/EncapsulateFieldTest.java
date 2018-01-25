package com.tw.refactoring;

import org.junit.Test;

/**
 * @author pzzheng
 * @date 1/25/18
 */
public class EncapsulateFieldTest {
    /**
     * @author pzzheng
     */
    @Test
    public void test() {
        System.out.println(PersonFactory.CHINA_POPULATION);
    }
}

class Person {
    public String name;
    public String age;

    @Override
    public String toString() {
        return name + " is " + age + "years old.";
    }
}

class PersonFactory {
    public static double CHINA_POPULATION = 13.79;

    public static Person simplePerson(String name, String age) {
        Person person = new Person();
        person.name = name;
        person.age = age;

        return person;
    }
}
