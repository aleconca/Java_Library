package Loops;

import java.util.ArrayList;

public class For2 {

    public static void main(String[] args) {
        //add 1 to every element
        int[] secretCode = { 0, 1 ,2,3,4};
        //Array
        for (int i = 0; i < secretCode.length; i++) {

            secretCode[i] += 1;

        }
        ArrayList<Integer> secretCodes= new ArrayList<Integer>();

        secretCodes.add(1);
        secretCodes.add(2);
        //ArrayList
        for (int i = 0; i < secretCodes.size(); i++) {

            int num = secretCodes.get(i);
            secretCodes.set(i, num + 1);

        }
    }

}
