package com.tw.refactoring.movierental;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public final class Statements {
    public static HtmlStatement htmlStatement() {
        return new HtmlStatement();
    }

    public static TextStatement textStatement() {
        return new TextStatement();
    }
}
