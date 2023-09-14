package ConditionalsFlowControl;

public class CarLoan {
    public static void main(String[] args) {
        int loan = 10000;
        int loanLength = 3;//three years
        int interestRate = 5;//INTEREST RATE OF 5%
        int downPayment = 2000;

        if (loanLength <= 0 || interestRate <= 0) {
            //invalid loan
            System.out.println("Error, insert valid car loan");
        } else if (downPayment >= loan) {
            //Too much
            System.out.println("The car can be paid in full");
        } else {
            //calculate montlhy payment with intersts
            int remainingBalance = loan - downPayment;
            int months = loanLength * 12;
            int monthlyBalance = remainingBalance / months;
            int interest = (monthlyBalance * interestRate) / 100;
            int monthlyPayment = monthlyBalance + interest;

            System.out.println(monthlyPayment);
        }

    }
}
