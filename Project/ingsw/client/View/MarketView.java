package Project.ingsw.client.View;

import it.polimi.ingsw.server.Model.Color;
import it.polimi.ingsw.server.Model.Marble;
import it.polimi.ingsw.server.Model.Market;

import java.util.Arrays;
import java.util.Scanner;

public class MarketView {
    //Non mi sembra molto giusto, tuttavia almeno per il mercato potrebbe starci
    // perchè ogni volta che si va,
    // si deve creare un nuovo mercato e ottenere queste informazioni
    //TODO delete class attributes (?)
    /**
     * int RorC belongs to [0,2]:  0-not chosen ; 1-Row ; 2-Column
     * int number belongs to [0, 4]: is the number of the row or the column
     */
    private int RorC = 0;
    private int number = 0;
    Scanner scanner = new Scanner(System.in);

    private final String[] MARBLE = {"\u25cf"};

    /**
     * This method prints the updated Market
     * @param market took from "Game" class
     * @param isStart is true if it has to print just the market;
     *                is false if the player chose to go to the market (so it will print questions and scanner answers)
     * */
    public MarketView(Market market, boolean isStart) {
        //Anche se il market è già stampato, lo ristampa così da averlo sott'occhio mentre si sceglie riga, colonna, numero
        System.out.println(Color.ANSI_RED + "\n**" + Color.RESET + " MARKET " +Color.ANSI_RED+"**" + Color.RESET);
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                PrintColoredMarble(market.getMat()[i][j]);
            }
        }
        System.out.print("\n\n" + "TR: ");
        PrintColoredMarble(market.getTR());
        System.out.println();

        if (!isStart) {
            chooseRorC();
        } else { /*do nothing*/ }

        /*System.out.println("Do you wanna take marbles from the market? [y(es) or n(o)]");
        if(scanner.next().equals("y")){
            chooseRorC();
        }
        //else boh*/
    }

    /**
     * Algorithm to assign a specific color to marbles
     */
    private void PrintColoredMarble(Marble.color c){
        if (c == Marble.color.y)
            System.out.print(Color.ANSI_YELLOW + Arrays.toString(MARBLE) + Colour.RESET);
        else if (c== Marble.color.r)
            System.out.print(Color.ANSI_RED + Arrays.toString(MARBLE) + Colour.RESET);
        else if (c == Marble.color.w)
            System.out.print(Color.ANSI_WHITE + Arrays.toString(MARBLE) + Colour.RESET);
        else if (c == Marble.color.b)
            System.out.print(Color.ANSI_BLUE + Arrays.toString(MARBLE) + Colour.RESET);
        else if (c == Marble.color.p)
            System.out.print(Color.ANSI_PURPLE + Arrays.toString(MARBLE) + Colour.RESET);
        else if (c == Marble.color.g)
            System.out.print(Color.ANSI_GREY + Arrays.toString(MARBLE) + Colour.RESET);
        else
            System.out.println("Errore");
    }


    //Se si possono passare più parametri nei msg, si può mettere tutto nel visualize (?)
    private void chooseRorC() {
        //Mettere i controlli
        System.out.println("Okay, then choose if you want to take a row [R] or column [C]:");
        do {
            if(scanner.next().equals("R")) RorC=1;
            else if(scanner.next().equals("C")) RorC=2;
            else System.out.println("Not valid! Please type 'R' for Row or 'C' for Column");
        } while (RorC==0);
        chooseNumber();
    }

    private void chooseNumber() {
        //Mettere i controlli
        System.out.print("Now choose which ");
        if(RorC==1) {
            System.out.println("row: [1, 2, 3]");
            do {
                if(scanner.nextInt()!=1 || scanner.nextInt()!=2 || scanner.nextInt()!=3)
                    System.out.println("Number not valid! Please enter '1' or '2' or '3' ");
                else {
                    number=scanner.nextInt();
                    System.out.println("You chose the row number " + number);
                }
            } while (number==0);
        }
        else if(RorC==2) {
            System.out.println("column: [1, 2, 3, 4]");
            do {
                if(scanner.nextInt()!=1 || scanner.nextInt()!=2 || scanner.nextInt()!=3 || scanner.nextInt()!=4)
                    System.out.println("Number not valid! Please enter '1' or '2' or '3' or '4' ");
                else {
                    number=scanner.nextInt();
                    System.out.println("You chose the column number " + number);
                }
            } while (number==0);
        }
        else System.out.println("Error"); //non dovrebbe essere mai raggiunto

    }

    public boolean sureMessage(Market m){
        System.out.print("Finally you choose these marbels: ");
        if(RorC==1){
            for (Marble.color row: m.getColorsRow(number, m.getMat())) {
                PrintColoredMarble(row);
            }
        }
        else if(RorC==2){
            for (Marble.color col: m.getColorsColumn(number, m.getMat())) {
                PrintColoredMarble(col);
            }
        }
        else System.out.println("Error");
        System.out.println("Do you want to take these marbles? [Y]es or [N]o ");
        while (true) {
            if(scanner.next().equals("Y") || scanner.next().equals("y")) return true;
            else if(scanner.next().equals("N") || scanner.next().equals("n")) return false;
            else System.out.println("Input invalid. Please type 'Y' or 'N' ");
        }
    }

    public int getRorC() {
        return RorC;
    }

    public void setRorC(int rorC) {
        RorC = rorC;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
