package com.company;

public class Biomes {
    private String name;
    private Biomes up;
    private Biomes down;
    private Biomes left;
    private Biomes right;
    public Biomes( String name){
        this.name = name;
        up = null;
        down = null;
        left = null;
        right = null;
    }// read i from a file

    public void setUp(Biomes b){
        up=b;
    }
    public void setDown(Biomes b){
        down=b;
    }
    public void setLeft(Biomes b){
        left=b;
    }
    public void setRight(Biomes b){
        right=b;
    }
    public Biomes getUp(){
       return up;
    }
    public Biomes getDown(){
       return down;
    }
    public Biomes getLeft(){
        return left;
    }
    public Biomes getRight(){
        return right;
    }



    public String Name(){
        return name;
    }


}
