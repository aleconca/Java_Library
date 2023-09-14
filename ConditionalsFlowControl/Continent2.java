package ConditionalsFlowControl;

public class Continent2 {

        public static void main(String[] args) {
            //prints out a continent and the largest city in that continent

            int continent = 4;

            switch(continent){
                case 1:
                    System.out.println("North America: Mexico City, Mexico.");
                    break;
                case 2:
                    System.out.println("SOuth America: Sao Paulo, Brazil.");
                    break;
                case 3:
                    System.out.println("Europe: Moscow, Russia.");
                    
                case 4:
                    System.out.println("Africa: Lagos, Nigeria.");

                case 5:
                    System.out.println("Antartica: McMurdo Station,US.");

                default:
                    System.out.println("Undefined continent");

            }


        }

}
