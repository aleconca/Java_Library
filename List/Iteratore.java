package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteratore {

    public static void main(String[] args){

        List<String> cars= new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        Iterator<String> str=cars.iterator();

        while(str.hasNext()){
            String s = str.next();
            System.out.println(s);

        }


    }
}
