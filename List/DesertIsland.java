package List;

import java.util.ArrayList;

public class DesertIsland {
    public static void main(String[] args){
        ArrayList<String> desertIsland = new ArrayList<String>();

        desertIsland.add("Worth it");
        desertIsland.add("Knees");
        desertIsland.add("Oh my");

        System.out.println(desertIsland.size());

        boolean i=desertIsland.remove("worth it");

        System.out.println(desertIsland);

        System.out.println(i);

        int indexA= desertIsland.indexOf("Worth it");

        int indexB= desertIsland.indexOf("Oh my");

        System.out.println(indexB);

        System.out.println(indexA);

        String temp = "Therefore I am";

        desertIsland.set(indexA,"Worth it");

        desertIsland.set(indexB, "Last hurray");

        System.out.println(desertIsland);

    }
}
