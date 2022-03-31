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
                }
                if(x+MG.FileManagement.getCollums()<=gridSquares.length-1){
                    currentPos.setDown(gridSquares[x+MG.FileManagement.getCollums()]);
                }
                if(x-1>=row*MG.FileManagement.getCollums()){
                    currentPos.setLeft(gridSquares[x-1]);
                }
                if(x+1<=((row+1)*MG.FileManagement.getCollums())-1){
                    currentPos.setRight(gridSquares[x+1]);
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
        Display(oldpos);
    }

    public void Display(GridSquare oldpos){
        Database found = new Database("Found.txt");
        String areas[] = new String[found.getRecordCount()];
        int areasStatus[] = new int[found.getRecordCount()];
        for(int x = 0; x<found.getRecordCount();x++) {
            String temp[] = found.getRecord(x+1).split("\\s+");
            areas[x] = temp[0];
            areasStatus[x] = Integer.parseInt(temp[1]);
            if(currentPos.Name().compareTo(areas[x]) == 0){
                if (areasStatus[x] == 0){
                    // dont display
                    System.out.println("moved from "+ oldpos.Name() + " to ?");
                }else{
                    //display
                    System.out.println("moved from "+ oldpos.Name() + " to " + currentPos.Name());}
            }
        }
    }



    public void createGid(){
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
                SetCurrent(gridSquares[0]);
    }

}
