package com.tw.refactoring.intellij;

/**
 * @author pzzheng
 * @date 1/23/18
 */
public class Foo implements FooInterface {
    private String b;
    public String getInfo() {
        String b1 = b;
        return ("(" + b1 + ")");
    }
}

class Bar {
    Foo foo;
    String t2 = foo.getInfo();
}
