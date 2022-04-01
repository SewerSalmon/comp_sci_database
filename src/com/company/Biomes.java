package com.company;

import java.util.Vector;

public class Biomes {
    public Biomes(){
    }// set what grid squares are what biome // also controls if an area is found or not it will be read in from the game file but i dont hve access to that at the moment

    public void SetFound(int foundOrNot,String BiomeName) {

        Database found = new Database("Found.txt");


        //read in from the file atm made custom thing yeah
        Database d = new Database("Biomes.txt");
        for (int x = 0; x < d.getRecordCount(); x++) {
            if (d.getRecord(x + 1).split("\\s+")[0].compareTo(BiomeName) == 0) {
                String gridSquaresInBiome[] = d.getRecord(x + 1).split("\\s+");
                String compare[] =String.valueOf(found.readFromTo(0, found.FileManagement.getCollums() * found.getRecordCount() * (found.FileManagement.getLargestString() + 1))).split("\\s+");
                     for (int z = 1; z < gridSquaresInBiome.length; z++) {
                         // read in whole file and replace certain lines with what you want e.g if grid square name is a        replace lien a     0      with  a     1     or whatever passed in value is
                              for (int i = 0; i < compare.length; i = i + 2) {
                                       if (compare[i].compareTo(gridSquaresInBiome[z]) == 0) {
                                           compare[i + 1] = String.valueOf(foundOrNot);
                                       }
                              }
                    }
                     found.FileManagement.WriteToFile("", false, false);
                    for (int i = 0; i < compare.length; i = i + 2) {
                        found.FileManagement.WriteToFile(compare[i] + "," + compare[i + 1], true, true);
                    }
                    found.FileManagement.paddedSpaces();
                    return;
            }
        }
        System.out.println("not a biome");

    }


    public String whatBiome(GridSquare GS){

        return null;
    }

}
