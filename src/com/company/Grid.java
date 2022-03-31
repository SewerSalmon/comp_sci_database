package com.company;
import java.util.Scanner;

public class Grid {
    private GridSquare currentPos;

    public Grid(){
    }

    public void SetCurrent(GridSquare b){
       currentPos = b;
    }

    public GridSquare getCurrent(){
        return currentPos;
    }

    private void CreateSurroundings(){
        Database MG = new Database("MapGrid.txt");
        GridSquare gridSquares[] = new GridSquare[MG.FileManagement.getCollums()*MG.getRecordCount()];
        int counter=0;
        for(int x = 0; x<MG.getRecordCount();x++) {
            for(int y = 0;y<MG.FileManagement.getCollums();y++) {
                gridSquares[counter] = new GridSquare(MG.getRecord(x+1).split("\\s+")[y]);
                counter++;
            }
        }
        for(int x = 0;x<gridSquares.length;x++){
            if(currentPos.Name().compareTo(gridSquares[x].Name())==0){
                int row = x/MG.FileManagement.getCollums();

                if(x-MG.FileManagement.getCollums()>=0){
                    currentPos.setUp(gridSquares[x-MG.FileManagement.getCollums()]);
                    System.out.println("up set to " + gridSquares[x-MG.FileManagement.getCollums()].Name());
                }
                if(x+MG.FileManagement.getCollums()<=gridSquares.length-1){
                    currentPos.setDown(gridSquares[x+MG.FileManagement.getCollums()]);
                    System.out.println("down set to " + gridSquares[x+MG.FileManagement.getCollums()].Name());
                }
                if(x-1>=row*MG.FileManagement.getCollums()){
                    currentPos.setLeft(gridSquares[x-1]);
                    System.out.println("left set to " + gridSquares[x-1].Name());
                }
                if(x+1<=((row+1)*MG.FileManagement.getCollums())-1){
                    currentPos.setRight(gridSquares[x+1]);
                    System.out.println("right set to " + gridSquares[x+1].Name());
                }

            }
        }


    }

    public void move(){
        CreateSurroundings();
        Scanner Ui = new Scanner(System.in);  // Create a Scanner object
        System.out.println("u/d/l/r");
        String input = Ui.nextLine();

        GridSquare oldpos = currentPos;
        if(input.equals("u")){
            if(currentPos.getUp() != null){
                SetCurrent(currentPos.getUp());
            }
        }
        if(input.equals("d")){
            if(currentPos.getDown() != null){
                SetCurrent(currentPos.getDown());
            }
        }
        if(input.equals("l")){
            if(currentPos.getLeft() != null){
                SetCurrent(currentPos.getLeft());
            }
        }
        if(input.equals("r")){
            if(currentPos.getRight() != null){
                SetCurrent(currentPos.getRight());
            }
        }
        oldpos.clear();
    }


}
