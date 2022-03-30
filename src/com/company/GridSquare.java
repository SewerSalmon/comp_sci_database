
package com.company;
public class GridSquare {// mayeb chage to an aray list idk help
    private String name;
    private GridSquare up;
    private GridSquare down;
    private GridSquare left;
    private GridSquare right;
    public GridSquare( String name){
        this.name = name;
        up = null;
        down = null;
        left = null;
        right = null;
    }// read i from a file

    public void setUp(GridSquare b){
        up=b;
    }
    public void setDown(GridSquare b){
        down=b;
    }
    public void setLeft(GridSquare b){
        left=b;
    }
    public void setRight(GridSquare b){
        right=b;
    }
    public GridSquare getUp(){
        return up;
    }
    public GridSquare getDown(){
        return down;
    }
    public GridSquare getLeft(){
        return left;
    }
    public GridSquare getRight(){
        return right;
    }
    public String Name(){
        return name;
    }


}
