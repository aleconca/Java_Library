package ClassesObjectsMethods;

public class Calculator2 {

    private String wellHi ;
    private String attr2;


    public Calculator2(String string){
        this.wellHi=string;
    }

    public Calculator2(String string , String attr){
        this.wellHi=string;
        this.attr2=attr;
    }

    public int add(int a, int b){
        return a+b;
    }

    public int substract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public int divide(int a, int b){
        return a/b;
    }

    public int modulo(int a, int b){
        return a%b;
    }

    @Override
    public String toString() {
        return
                 wellHi + '\n' +
                 attr2 + '\n'
                ;
    }

    public static void main(String[] args){

        Calculator2 calculator = new Calculator2("Hey there!");

        System.out.println(calculator.wellHi+"Printing sum:"+calculator.add(10,20));

        Calculator2 calculator2= new Calculator2("Hey again", "and again");

        System.out.println(calculator2+"Printing sum:"+calculator2.add(10,20));


    }
}
