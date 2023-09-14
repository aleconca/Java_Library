package Loops;
import java.util.ArrayList;

public class Loops {

    public boolean isPrime(int number) {
        if (number < 2 && number != 0) {
            return true;
        } else if (number == 0) {
            return false;
        } else {

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }


            return true;

        }
    }

    public static void main(String[] args) {

        int[] numbers = {0, 2, 5, 7};
        Loops pd = new Loops();

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(pd.isPrime(numbers[i]));
        }

        ArrayList<String> titles = new ArrayList<String>();

        titles.add("Without me");
        titles.add("Sweater Weather");
        titles.add("3am");

        for( String title : titles ){
            if (title.equals("3am")){
                System.out.println("OK");
            }
        }




    }

}


