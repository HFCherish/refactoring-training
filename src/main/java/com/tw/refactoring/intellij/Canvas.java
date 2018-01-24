package com.tw.refactoring.intellij;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author pzzheng
 * @date 1/23/18
 */
public class Canvas {
    private List<IShape> shapes;

    public void paint(Graphics g) {
        shapes.forEach(aShape -> aShape.paint(g));
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.paint(new DebugGraphics());
        canvas.shapes.clear();
    }
}
