package com.tw.refactoring;

/**
 * @author pzzheng
 * @date 1/25/18
 */
public class EncapsulateFieldTest {
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
    public static Person simplePerson(String name, String age) {
        Person person = new Person();
        person.name = name;
        person.age = age;

        return person;
    }
}
