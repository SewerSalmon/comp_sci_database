package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    public static void main(String[] args)  {
        createGid();
    }

    public static void displayGrid(Grid grid){
        while(true){
            grid.move();
            System.out.println(grid.getCurrent().Name());
        }
    }

    public static void createGid(){
        Grid grid = new Grid();

        Database MG = new Database("MapGrid.txt");
        GridSquare gridSquares[] = new GridSquare[MG.FileManagement.getCollums()*MG.getRecordCount()];
        int counter=0;
        for(int x = 0; x<MG.getRecordCount();x++) {
            for(int y = 0;y<MG.FileManagement.getCollums();y++) {
                gridSquares[counter] = new GridSquare(MG.getRecord(x+1).split("\\s+")[y]);
                counter++;
            }
        }
        System.out.println("where do you want to start");// replace with click of gui?
        Scanner user = new Scanner(System.in);  // Create a Scanner object
        String start = user.nextLine();


        for(int z = 0; z<gridSquares.length-1;z++){
            if(start.equals(gridSquares[z].Name())){
               grid.SetCurrent(gridSquares[z]);
            }
        }



        displayGrid(grid);


    }

}

