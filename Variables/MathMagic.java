package Variables;
import java.util.*;
import javax.sound.midi.SysexMessage;

public class MathMagic {

    public static void main(String[] args) {

        int myNumber =  4 - -1 ;
        // puoi fare -1
        // * /  %  | + - | =
        // se ho piu operatori del singolo gruppo valuta da sx  a dx
        float cast = (float) 14.1234567; //In Java per avere float fare cast
        //precisione 6 a 7 posti dopo la virgola
        //approx al numero maggiore da dopo il 5

        System.out.println(cast);

        double virgola =  12.12345678901;
        //double 15 a 16 decimali
        //non approssima

        System.out.println(virgola);
    }



}
