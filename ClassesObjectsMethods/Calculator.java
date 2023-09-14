package ClassesObjectsMethods;

public class Calculator {

        //Constructor
        public Calculator(){

        }

        public int add(int a,int b){
            return a+b;
        }

        public int subtract(int a, int b){
            return a-b;
        }

        public int multiply(int a , int b){
            return a*b;
        }

        public int divide(int a,int b){
            return a/b;
        }

        public int modulo(int a, int b){
            return a%b;
        }

        public static void main(String[] args){
            Calculator calculator = new Calculator();

            System.out.println(calculator.add(5,7));

            System.out.println(calculator.subtract(45,11));

        }


}
