package List;
import java.util.*;

public class LinkedList1 {


        public static void main(String args[]) {
            // Creating an object of the
            // class linked list
            LinkedList<String> object = new LinkedList<String>();

            // Adding the elements to the
            // linked list
            object.add("A");
            object.add("B");
            object.addLast("C");

            System.out.println(object);

            // Removing elements from the
            // list
            object.remove("B");
            object.removeFirst();

            System.out.println("Linked list after "
                    + "deletion: " + object);
        }


}
