package ConditionalsFlowControl;

public class CarLoan2 {

    private int loan ;
    private int loanLength;
    private int interestRate;
    private int downPayment;

    private int remainingBalance;


    public CarLoan2(int loan, int loanLength, int interestRate, int downPayment) {
        this.loan = loan;
        this.loanLength = loanLength;
        this.interestRate = interestRate;
        this.downPayment = downPayment;

        this.remainingBalance=loan-downPayment;
    }

    public int getLoan() {
        return loan;
    }

    public int getLoanLength() {
        return loanLength;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void deposit(int money){

        this.remainingBalance=this.remainingBalance-money;

        if(this.remainingBalance <0){
            System.out.println("Returning money.");
        }else if(this.remainingBalance ==0){
            System.out.println("Loan fully paied");
        }else{

            int toPay=monthlyPayment(this.remainingBalance);

            System.out.println("Money to pay per month: "+ toPay);

            System.out.println("Remaing balance: "+ this.remainingBalance);

        }

    }

    public int monthlyPayment(int balance){
        //calculate montlhy payment with intersts
        int months = loanLength*12;
        int monthlyBalance = this.remainingBalance/months;
        int interest = (monthlyBalance *interestRate )/100;
        int monthlyPayment= monthlyBalance+interest;


        return monthlyPayment;
    }

    public static void main(String[] args){

        CarLoan2 carLoan = new CarLoan2(10000,5,3,2000);

        int loan = carLoan.getLoan();
        int loanLength = carLoan.getLoanLength();
        int interestRate = carLoan.getInterestRate();
        int downPayment= carLoan.getDownPayment();



        /*if( interestRate <=0 || interestRate <=0){
            System.out.println("Error! Invalid car loan!");
        }else if(downPayment>=loan){
            System.out.println("The car can be paid in full");
        }*/

        int initialBalance= loan - downPayment;

        System.out.println("Initial balance is :"+ initialBalance);


        int toDeposit= carLoan.monthlyPayment(initialBalance);

        System.out.println("Client deposits :" + toDeposit );

        carLoan.deposit(toDeposit);

    }
}
