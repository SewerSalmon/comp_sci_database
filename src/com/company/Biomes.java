package com.company;

public class Biomes {
    public Biomes(){
    }// set what grid squares are what biome // also controls if an area is found or not it will be read in from the game file but i dont hve access to that at the moment

    public void SetFound(int foundOrNot,String BiomeName){
        //read in from the file atm made custom thing yeah
        Database d = new Database("Biomes.txt");
        for(int x = 0;x<d.FileManagement.lineAmount;x++){
           if(d.getRecord(x+1).split("\\s+")[0].compareTo(BiomeName)==0){
               String gridSquaresInBiome[]=d.getRecord(x+1).split("\\s+");
               Database found = new Database("Found.txt");
               String areas[] = new String[found.getRecordCount()];
               for(int y = 0; y<found.getRecordCount();y++) {
                   areas[y] = found.getRecord(y + 1).split("\\s+")[0];
                   for (int z = 1;z<gridSquaresInBiome.length;z++)
                    if (gridSquaresInBiome[z].compareTo(areas[y]) == 0) {
                        // read in whole file and replace certain lines with what you want e.g if grid square name is a        replace lien a     0      with  a     1     or whatever passed in value is

                    }
               }

           }
        }


    }

    public String whatBiome(GridSquare GS){

        return null;
    }

}
