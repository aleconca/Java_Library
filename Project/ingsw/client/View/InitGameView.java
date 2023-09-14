package Project.ingsw.client.View;

import it.polimi.ingsw.Exceptions.ArrayDontFitException;
import it.polimi.ingsw.Exceptions.IncorrectMoveException;
import it.polimi.ingsw.server.Model.Color;
import it.polimi.ingsw.server.Model.LeaderCard;
import it.polimi.ingsw.server.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class InitGameView {
    //TODO delete class attributes (?)
    private String[] resourcesChosen = new String[2];
    private boolean hasFaithPoint = false;

    public String[] getResourcesChosen() {
        return resourcesChosen;
    }
    public void setResourcesChosen(String[] resourcesChosen) {
        this.resourcesChosen = resourcesChosen;
    }
    public boolean isHasFaithPoint() {
        return hasFaithPoint;
    }
    public void setHasFaithPoint(boolean hasFaithPoint) {
        this.hasFaithPoint = hasFaithPoint;
    }

    private ArrayList<Integer> leaderCardsChosen = new ArrayList<>(2);

    /**
     *Player chooses one (or two) resources and gets faithpoints before the game starts
     */
    public void initGameResources(Player player) throws IncorrectMoveException, ArrayDontFitException {
        Scanner scanner = new Scanner(System.in);
        String input;

        if (player.getNumber()==1) {
            System.out.println("YOU ARE FIRST PLAYER ! NEITHER RESOURCES NOR FAITHPOINTS :(");
        }
        else if (player.getNumber() == 2 || player.getNumber()==3) {
            do {
                System.out.println(Color.ANSI_WHITE + "CHOOSE" + Color.ANSI_RED + " 1 " + Color.ANSI_WHITE + "RESOURCE : " + "TYPE " + Color.ANSI_RED + "coin" +
                        Color.ANSI_WHITE + " - " + Color.ANSI_RED +  "stone" + Color.ANSI_WHITE + " - " + Color.ANSI_RED + "servant"  +
                        Color.ANSI_WHITE + " - " + Color.ANSI_RED +  "shield" + Color.ANSI_WHITE);
                input = scanner.next();
                if (goodRes(input)) {
                    resourcesChosen[0] = input;
                    //crea messaggio per passare le risorse da inserire
                }
                else
                    System.out.println(Color.ANSI_WHITE + "RETRY...");
            } while (!goodRes(input));

            if (player.getNumber() == 3) {
                hasFaithPoint=true;
            }
        } else if (player.getNumber() == 4) {
            int counter = 0;
            do {
                System.out.println(Color.ANSI_WHITE + "CHOOSE" + Color.ANSI_RED + " 2 " + Color.ANSI_WHITE + "RESOURCE : " + "TYPE " + Color.ANSI_RED + "coin " +
                        Color.ANSI_WHITE + "- " + Color.ANSI_RED +  "stone" + Color.ANSI_WHITE + " - " + Color.ANSI_RED + "servant"  +
                        Color.ANSI_WHITE + " - " + Color.ANSI_RED +  "shield" + Color.ANSI_WHITE);
                input = scanner.next();
                if (goodRes(input)) {
                    resourcesChosen[counter]=input;
                    counter++;
                }
                else System.out.println("RETRY...");
            } while (counter<=1);
            hasFaithPoint=true;
        }
    }

    private boolean goodRes(String in){
        return in.equals("coin") || in.equals("shield") || in.equals("servant") || in.equals("stone");
    }


    public void chooseLeaderCards(ArrayList<LeaderCard> leaderCards) {

        LeaderCardView leaderCardView = new LeaderCardView();
        int n=0,m=0;
        boolean stop=false;
        boolean passo1=true;
        ArrayList<Integer> num = new ArrayList<>(2);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0 ; i< leaderCards.size(); i++) {
            leaderCardView.printLeaderCard(leaderCards.get(i));
        }

        System.out.println("\n" + Color.ANSI_WHITE + "CHOOSE" + Color.ANSI_RED + " TWO "  + Color.ANSI_WHITE + "OF THESE CARDS" +
                " ( TYPE " + Color.ANSI_RED + "1 "+ Color.ANSI_WHITE + "- " + Color.ANSI_RED + "2"
                +Color.ANSI_WHITE + " - " + Color.ANSI_RED + "3" + Color.ANSI_WHITE + " - " + Color.ANSI_RED+ "4 " + Color.ANSI_WHITE + ") : ");

        //Player sceglie le due leaderCards
        do {
            if (passo1) {
                n = scanner.nextInt();
                if (n > 0 && n < 5) {
                    num.add(n);
                    passo1=false;
                } else
                    System.out.println("RETRY...");
            }
            if (!passo1){
                m = scanner.nextInt();
                if ((m > 0 && m < 5) && m!=n) {
                    num.add(m);
                    stop=true;
                } else
                    System.out.println("RETRY...");
            }
        }while(!stop);

        System.out.println("YOU CHOSE CARD " + Color.ANSI_RED + num.get(0) + Color.ANSI_WHITE +" AND CARD " + Color.ANSI_RED + num.get(1) + Color.ANSI_WHITE);

        leaderCardsChosen = num; //stringa di risposta
    }


    public ArrayList<Integer> getLeaderCardsChosen() {
        return leaderCardsChosen;
    }
}
