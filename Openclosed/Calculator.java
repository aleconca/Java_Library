package Liskov.Openclosed;

import java.security.InvalidParameterException;

public class Calculator {
    public void calculate(CalculatorOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException("Cannot perform operation");
        }
        operation.perform();//binding dinamico evita la riscrittura del codice
        //se aggiungo una nuova operazione
        //di fatto mi basta far si che implemnti CalculatorOperation e faccia
        //Override della signature del metodo perform e lo implementi
    }

}
