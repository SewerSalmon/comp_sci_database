package com.company;
import java.util.Scanner;

public class Grid {
    GridSquare currentPos;

    public Grid(GridSquare start){
    currentPos = start;
    //each biome knows what it is next to this goes into the text file if it is the biome it gets 0 or if it is urelated it gets -1 if it is up  1 left 2 down 3 right 4
    }
    private void SetCurrent(GridSquare b){
       currentPos = b;
    }

    public String getCurrent(){
        return currentPos.Name();
    }

    public void move(){
        Scanner Ui = new Scanner(System.in);  // Create a Scanner object
        System.out.println("up/down/left/right");
        String input = Ui.nextLine();

        if(input.equals("up")){
            if(currentPos.getUp() != null){
                SetCurrent(currentPos.getUp());
            }
        }
        if(input.equals("down")){
            if(currentPos.getDown() != null){
                SetCurrent(currentPos.getDown());
            }
        }
        if(input.equals("left")){
            if(currentPos.getLeft() != null){
                SetCurrent(currentPos.getLeft());
            }
        }
        if(input.equals("right")){
            if(currentPos.getRight() != null){
                SetCurrent(currentPos.getRight());
            }
        }

    }


}
