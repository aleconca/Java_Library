package Array;

import java.util.ArrayList;

public class Types {


    public static void main(String[] args) {
        ArrayList<Object> pippa = new ArrayList<>();

        int z = 10;
        ArrayList<String> middleton = new ArrayList<>();
        middleton.add("Queen");

        pippa.add(z);
        pippa.add(middleton);

        for (int i= 0; i<pippa.size(); i++){
            System.out.println(pippa.get(i));
        }


        ArrayList<String> kate2;

        kate2 = (ArrayList<String>) pippa.get(1);
        System.out.println(kate2.get(0));


        ArrayList<String> kate = new ArrayList<>();
        kate.add("william");

        System.out.println(kate.get(0));

    }





}
