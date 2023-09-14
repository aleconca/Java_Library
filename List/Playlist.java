package List;

import java.util.*;

class Playlist {


    public static void main(String[] args) {
        List<String> desertIslandPlaylist = new ArrayList<String>();

        desertIslandPlaylist.add("Cotton Candy");
        desertIslandPlaylist.add("Still Breathing");
        desertIslandPlaylist.add("Fluorescent adolescence");
        desertIslandPlaylist.add("Bad guy");
        desertIslandPlaylist.add("Therefore I AM");
        desertIslandPlaylist.add("Bad guy");

        System.out.println(desertIslandPlaylist);
        System.out.println(desertIslandPlaylist.size());

        desertIslandPlaylist.remove("Bad guy");

        System.out.println(desertIslandPlaylist.size());

        int indexA = desertIslandPlaylist.indexOf("Therefore I AM");
        System.out.println("get indexA: "+desertIslandPlaylist);

        int indexB = desertIslandPlaylist.indexOf("Cotton Candy");
        System.out.println("get indexB: "+desertIslandPlaylist);

        String tempA = "Therefore I AM";

        desertIslandPlaylist.set(indexA, "Cotton Candy");
        desertIslandPlaylist.set(indexB, tempA); //swap con variabile invece che riscrivere la stringa
        System.out.println("Final result: " + desertIslandPlaylist);


    }

}