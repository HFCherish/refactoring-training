package com.tw.refactoring;

import org.junit.Test;

/**
 * @author pzzheng
 * @date 1/25/18
 */
public class SubstituteAlgorithmTest {

    /**
     * @author pzzheng
     */
    @Test
    public void test() {
        ClassA classA = new ClassA();
        classA.problemASolution1();
        classA.problemASolution2();
        classA.problemBSolution1();
        classA.methodShouldInB();

        ClassB classB = new ClassB();
        classB.problemBSolution2();
    }
}

class ClassA {
    public void problemASolution1 () {
        System.out.println("this is the first solution for problem a");
    }

    public void problemASolution2 () {
        System.out.println("this is the second solution for problem a");
    }

    public void problemBSolution1 () {
        System.out.println("this is the first solution for problem b");
    }

    public void methodShouldInB() {
        System.out.println("this method should be in B, now is in " + this.getClass().getSimpleName());
    }

}

class ClassB {
    public void problemBSolution2 () {
        System.out.println("this is the second solution for problem b");
    }
}

