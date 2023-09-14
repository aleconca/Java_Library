package Visibilita;

public class Test {


    public static void main(String[] args){
       Data d1= new Data(1,2,3);
       d1= new Data(3,4,5);//nuova struttura dati, la precedente viene presa da GC

       //d1.mese=12;//Non posso farlo perchè i campi del tipo Data sono dichiarati coine privati in Data
        // e posssono pertanto essere solo visti e acceduti nella classe Data
        //allo stesso modo non potresti dichiarae il costruttore di data in test perche non pupi accedere ai campi di data
        //
    }

}
