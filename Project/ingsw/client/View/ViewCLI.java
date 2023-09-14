package Project.ingsw.client.View;


import it.polimi.ingsw.Exceptions.ArrayDontFitException;
import it.polimi.ingsw.Exceptions.IncorrectMoveException;
import it.polimi.ingsw.Network.MessageToServer.*;
import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ServerHandler;
import it.polimi.ingsw.server.Controller.Game;
import it.polimi.ingsw.server.Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewCLI implements View {

    private ServerHandler serverHandler;

    public void setServerHandler(ServerHandler serverHandler) {
        this.serverHandler = serverHandler;
    }



    @Override
    public void initGame(Player player, ArrayList<LeaderCard> cards) throws IncorrectMoveException, ArrayDontFitException, IOException {
        InitGameView initGameView = new InitGameView();

        initGameView.initGameResources(player);
        initGameView.chooseLeaderCards(cards);

        InitGameResponse msg = new InitGameResponse(initGameView.getLeaderCardsChosen(),cards ,initGameView.getResourcesChosen(),player);
        serverHandler.sendMsg(msg);


    }



    // Anche questo funziona in locale: cioè viene invocato nel messaggio dal server(?),
    // però poi il client prende la stringa di ritorno
    // e direttamente chiama il metodo giusto in base a questa stringa (goToMarket, buyDevCard ecc..)
    // (e poi setterà e invierà il messaggio)
    @Override
    public String startTurn(Market market, DevelopCardDeck developCardDeck) {
        //Ristampa dashboard è alla fine del turno precedente
        MarketView marketView = new MarketView(market, true); //stampa solo il mercato aggiornato
        //TODO method to print Develop Cards Deck (will be inserted in a new class "DevCardsGridView" maybe

        System.out.println("\nIT'S YOUR TURN! What do you want to do?");
        System.out.println("Go to Market "+ Color.ANSI_RED+ "[M]" + Colour.RESET +
                ", buy Develop Card " + Color.ANSI_RED + "[D]" + Colour.RESET +
                ", active Production " + Color.ANSI_RED + "[P]" + Colour.RESET +
                ", active Leader card(s) " + Color.ANSI_RED + "[L]" + Colour.RESET);

        Scanner scanner = new Scanner(System.in);

        return scanner.next();//stringa di risposta




    }



    // Return Msg ? Perchè questo metodo sarà chiamato in locale dal Client
    // quando l'utente digiterà "M" all'inizio del turno
    // il messaggio verrà inviato quando ci saranno i dati di riga/colonna
    public SelectedMarblesMsg goToMarket(Market m) {
        MarketView market = new MarketView(m, false);
        if(market.sureMessage(m)){

        }

        SelectedMarblesMsg selmarblemsg = new SelectedMarblesMsg();
        selmarblemsg.setRorC(market.getRorC());
        selmarblemsg.setNumber(market.getNumber());
        return selmarblemsg;
    }




   //-------------------------------View Buy  Dev Cards------------------------------------------------------------------

    @Override
    public void  ShowDevCards(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3, Player player) throws IOException {

        /*griglia :
                lvl3 [1-green][4-blu][7-yellow][10-purple]
                lvl2 [2-green][5-blu][8-yellow][11-purple]
                lvl1 [3-green][6-blu][9-yellow][12-purple]
                 */


        int cardNum = 0;
        int index;
        //oggetto per metodi di ricerca
        SearchCardsMethods2 searchMethods = new SearchCardsMethods2();

        for (int i = 0; i < 4; i++) {

            cardNum++;
            //lvl3
            System.out.print("\ncard : " + cardNum);

            index = searchMethods.searchCardLvl3(lvl3, cardNum);

            if (index >= 0) {
                devCard cardView = new devCard(lvl3.get(index));
            } else {
                System.out.println("\nCards finished.");
            }


            cardNum++;

            //lvl2
            System.out.print("\ncard : " + cardNum);

            index = searchMethods.searchCardLvl2(lvl2, cardNum);

            if (index >= 0) {
                devCard cardView = new devCard(lvl2.get(index));
            } else {
                System.out.println("\nCards finished.");
            }

            cardNum++;

            //lvl1
            System.out.print("\ncard : " + cardNum);

            index = searchMethods.searchCardLvl1(lvl1, cardNum);

            if (index >= 0) {
                devCard cardView = new devCard(lvl1.get(index));
            } else {
                System.out.println("\nCards finished.");
            }

        }


        //which card?
        System.out.println("\nInsert card number(1 to 12):");
        Scanner scanner = new Scanner(System.in);

        String chosenIndex = scanner.next();//chosen Index


        DashboardView  showDashBoard = new DashboardView(player);

        showDashBoard.visualizePerMulti();


        //in which slot do you wanna put this card?
        System.out.println("\nIn which card slot do you wanna put this card(1 to 3):");
        String chosenSlot = scanner.next();


        //invio indice per chiamata a buyDevcard che ritornera la chosenCArd e chiedera lo slot
        SelectedDevCardMsg msg = new SelectedDevCardMsg(lvl1,lvl2,lvl3,player,chosenIndex,chosenSlot);
        serverHandler.sendMsg(msg);

    }



    //-------------------------------------------------------------------------------------------------------------------


    @Override
    public void ShowDashboardSingle(Player player){
        DashboardView dashboardView = new DashboardView(player);
        dashboardView.visualizePerSingle();
    }

    @Override
    public void ShowActionSignal(Game game) {
        System.out.print(Color.ANSI_RED + "\n*" + Colour.RESET + " Action Signal: ");
        game.getActionSignalStack().getActionSignals().get(0).visualizeSignal(game.getActionSignalStack().getActionSignals().get(0));
        actionActivatedSignal(game.getActionSignalStack().getActionSignals().get(0));
    }

    private void actionActivatedSignal(ActionSignal actionSignal){
        if (actionSignal instanceof LorenzoSignal)
            System.out.println("Lorenzo Signal got activated ( it doesn't do anything :) )");
        else if (actionSignal instanceof BlackCross1Reset)
            System.out.println("Lorenzo is moving (+1) and the ActionSignal stack has been reset\n");
        else if (actionSignal instanceof BlackCrossMove2)
            System.out.println("Lorenzo is moving (+2)\n");
        else if (actionSignal instanceof DiscardBlueSignal)
            System.out.println("The column of Blue DevelopCards' grid got discarded\n");
        else if (actionSignal instanceof DiscardGreenSignal)
            System.out.println("The column of Green DevelopCards' grid got discarded\n");
        else if (actionSignal instanceof DiscardPurpleSignal)
            System.out.println("The column of Purple DevelopCards' grid got discarded\n");
        else if (actionSignal instanceof DiscardYellowSignal)
            System.out.println("The column of Yellow DevelopCards' grid got discarded\n");
    }


    @Override
    public void ShowMarket(Market market){
        MarketView marketView = new MarketView(market, true);
    }






    //--------------------View activate Production------------------------------------------------------------------------


    //DevelopCardProduction e ActivateProduction testati in locale :)

    //non lo sovrascrivo perchè richiamato nel metodo seguente
    public ArrayList<String> DevelopCardProduction() {

        //array di stringhe da usare lato server per rimuoverele dal client a lato server
        ArrayList<String> develop = new ArrayList<>();
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        String w;//seconda stringa di input

        boolean stop = false;


        while (!stop) {

            System.out.println("Insert  necessary resource number" + counter + ":[coin,shield,stone,servant]." +
                    "Insert 'end' to finish.");
            w = scanner.next();

            if (w.equals("end")) {
                stop = true;
            } else if (w.equals("coin") || w.equals("shield") || w.equals("stone") || w.equals("servant")) {
                develop.add(w);
            }

        }

        return develop;

    }

    //Verifica input e ritorna array basic con risorsa stringa aggiunta

    public ArrayList<String> VerifyInput(String s, ArrayList<String> basic){
        Scanner scanner = new Scanner(System.in);

        if (s.equals("coin") || s.equals("shield") || s.equals("stone") || s.equals("servant")) {
            basic.add(s);
        } else {

            while (!(s.equals("coin") || s.equals("shield") || s.equals("stone") || s.equals("servant"))) {
                System.out.println("Invalid resource name. Choose between coin,shield,stone or servant.");
                s = scanner.next();
            }

            basic.add(s);
        }

        return basic;//ritorno array aggiornato

    }



    @Override
    public void ActivateProduction(Player player) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> basic = new ArrayList<>();//array per attivare base production
        boolean stop = false;
        int counter = 0;
        ArrayList<Integer> z = new ArrayList<>();//interi degli slot da attivare
        ArrayList<ArrayList<String>> cards = new ArrayList<>();//memo risorse delle carte dello slot x
        int x; //intero per scanner.nextInt


        //start by printing dashpoard
        DashboardView dashboardView = new DashboardView(player);
        dashboardView.visualizePerMulti();


        while (!stop) {

            //chiedo le risorse a scelta e le salvo per rimuoverle e salvare la produzione lato server
            System.out.println("Do you want to activate your basic producion?:[y/n]");
            String s = scanner.next();


            if (s.equals("y")) {

                //asks for two resources
                for (int i = 0; i < 2; i++) {

                    System.out.println("Insert  1 resource:[coin,shield,stone,servant]");
                    s = scanner.next();

                    basic = VerifyInput(s,basic);

                }

                System.out.println("Insert resource of your choice:[coin,shield,stone,servant]");
                basic= VerifyInput(s,basic);//aggiungo risorsa frutto della basic production in ultima posizione

                stop = true;

                //assegno l'array  z degli slot ma separo il codice per avere i requirements
                //cosi che lato server ritrovo la carta di cui verificare i requirements salvati in
                //array cards e so quali rimovere o assegnare al player
                while (counter >= 0 && counter <= 3) {
                    System.out.println("Do you want to activate a develop card?:[y/n]");
                    s = scanner.next();
                    counter++;

                    if (s.equals("y")) {
                        do {
                            System.out.println("Which production do you want to activate?[1,2,3]");
                            x = scanner.nextInt();
                        } while (x != 1 && x != 2 && x != 3);

                        z.add(x);//memorizzo lo slot

                        cards.add(DevelopCardProduction()); //memorizzo i requirements per attivare lo slot

                    } else {
                        counter = 4;//esce dall'if...else...
                    }
                }

                stop = true;


            } else if (s.equals("n")) {

                //ripeto azione per caso n

                while (counter >= 0 && counter <= 3) {
                    System.out.println("Do you want to activate a develop card?:[y/n]");
                    s = scanner.next();
                    counter++;

                    if (s.equals("y")) {

                        do {
                            System.out.println("Which production do you want to activate?[1,2,3]");
                            x = scanner.nextInt();
                        } while (x != 1 && x != 2 && x != 3);

                        z.add(x);
                        cards.add(DevelopCardProduction());

                    } else {
                        counter = 4;
                    }
                }

                stop = true;

            } else {
                System.out.println("Not a valid input. Try again.");
            }

        }

        //messages assegna e invia array
        //System.out.println("Here send messages.");

        //invio array con risorse per ricercare slot da attivare con risorse corrispondenti
        //e risorse produzione base
        SelectedProductionMsg msg = new SelectedProductionMsg(basic,cards,z,player);

        serverHandler.sendMsg(msg);

    }

    //-------------------------------------------------------------------------------------------------------------------



    //-----------------------Error messages-----------------------------------------------------------------------------
    @Override
    public void printError(String error){
        System.out.println(error);
    }

    @Override
    public void SlotError(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3,
                          String chosenIndex, String chosenSlotIndex,Player player) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You chose an inavlid slot index! Try again.");

        //in which slot do you wanna put this card?
        System.out.println("\nIn which card slot do you wanna put this card(1 to 3):");
        chosenSlotIndex = scanner.next();


        //rifaccio chiamata a metodo nel controller con un idice di slot diverso
        SelectedDevCardMsg msg = new SelectedDevCardMsg(lvl1,lvl2,lvl3,player,chosenIndex,chosenSlotIndex);
        serverHandler.sendMsg(msg);


    }





    @Override
    public void EndGame(Player player, int sumFinalPoints){

        System.out.println("GAME OVER" + "\uD83C\uDFC1" +
                player.getName()+", you scored "+ Colour.ANSI_YELLOW + sumFinalPoints +
                Colour.RESET + "points !");

    }






}
