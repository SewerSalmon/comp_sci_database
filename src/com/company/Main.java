package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
      createGid();
    }

    public static void createGid(){
        // temp as will probaly use an image splitter to split image ito pixel squaers at the moment doig manually
        //should of doe with a array but oh well
        GridSquare a = new GridSquare("a");
        GridSquare b = new GridSquare("b");
        GridSquare c = new GridSquare("c");
        GridSquare d = new GridSquare("d");
        GridSquare e = new GridSquare("e");
        GridSquare f = new GridSquare("f");

// make easier way to do this e.g a.set up(b) also does b.set down(a)
        a.setUp(b);
        b.setDown(a);
        a.setRight(c);
        c.setLeft(a);
        a.setDown(d);
        d.setUp(a);
        a.setLeft(e);
        e.setRight(a);
        c.setUp(f);
        f.setDown(c);
        b.setRight(f);
        f.setLeft(b);

        Grid grid = new Grid(a);

        System.out.println(grid.getCurrent());
        grid.move();
        System.out.println(grid.getCurrent());
        grid.move();

    }

}

