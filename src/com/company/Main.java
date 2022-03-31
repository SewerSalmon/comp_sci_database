package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    public static void main(String[] args)  {
        Grid g = new Grid();
        g.createGid();
        while (true) {
            g.move();
        }
    }

}

