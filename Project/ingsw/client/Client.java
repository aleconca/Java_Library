package Project.ingsw.client;

import it.polimi.ingsw.client.View.ViewCLI;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        ServerHandler serverHandler;
        ViewCLI viewCLI;
        boolean stop = false;
        int porta;
        Socket socket;
        int numberOfPlayers=0;

        //TODO titolo gioco in rosso
        try {
            //Login();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to MASTER OF RENAISSANCE Game!");
            System.out.println("To create a game or connect with your friends, please fill the following fields ^_^ ");

            System.out.print("Type username: ");
            String username = scanner.nextLine();

            System.out.print("Type ip server: ");
            String ip = scanner.nextLine();

            System.out.print("Type port number: ");
            porta = scanner.nextInt();
            socket = new Socket(ip, porta);

            viewCLI = new ViewCLI();
            serverHandler = new ServerHandler(socket, username, viewCLI);
            viewCLI.setServerHandler(serverHandler);
            Thread sHThread = new Thread(serverHandler);
            sHThread.start();



            /*out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());


            out.writeObject(username);

            String LoginResult = (String) in.readObject();
            System.out.println(LoginResult);

            String gamestarted = "Login success... you are PLAYER 1 (HOST)";


            if (gamestarted.equals(LoginResult)) {

                int y = 0;
                do {
                    System.out.print("Number of players? [ 2 , 3 , 4 ]  for Multiplayer , [ 1 ] for Singleplayer  ");
                    numberOfPlayers = scanner.nextInt();
                    if (numberOfPlayers > 0 && numberOfPlayers < 5) {
                        out.writeObject(numberOfPlayers);
                        break;
                    }
                    y++;
                    if (y > 0)
                        System.out.println("Invalid number! Retry...");
                } while (numberOfPlayers < 1 || numberOfPlayers > 4);
            }

            //WaitForGameStarted();
            boolean gamestartedBool = (boolean) in.readObject();
            if (gamestartedBool)
                System.out.println("\nGAME STARTED!");

            //VIEW
            ViewCLI view = new ViewCLI();

            Object ob = in.readObject();
            InitGameMsg obj = (InitGameMsg) ob;

            if(obj != null){
                obj.process(view);
            }

            //palyer ha scelto le leader cards
            InitGameResponse response = new InitGameResponse();
            response.setChosenleaderCrads(obj.getChosenLeaderCards());

            out.writeObject(response);

            //RAMO SINGLEPLAYER
            if (numberOfPlayers==1){

                while(!stop) {

                    Object msg = in.readObject();

                    if (msg instanceof StartTurnMsg) {

                        //richiedo azione
                        ((StartTurnMsg) msg).process(view);

                        //metto la risposta nel messaggio
                        SelectedTurnMsg turn = new SelectedTurnMsg();
                        turn.setAction(((StartTurnMsg) msg).getAction());

                        out.writeObject(turn);
                    }

                    else if (msg instanceof PrintEveryThingMsg){
                        ((PrintEveryThingMsg) msg).process(view);//vanno aggiunte devCard grid e cardslot
                    }
                    else if (msg instanceof ActionSignalMsg){
                        ((ActionSignalMsg) msg).process(view);
                    }
                }
            }



            //RAMO MULITPLAYER
            else {
                //ricezione messaggi
                while (!stop) {

                    //leggo messaggio turno
                    Object obj1 = in.readObject();

                    if (obj1 instanceof StartTurnMsg) {

                        //richiedo azione
                        ((StartTurnMsg) obj1).process(view);

                        //metto la risposta nel messaggio
                        SelectedTurnMsg turn = new SelectedTurnMsg();
                        turn.setAction(((StartTurnMsg) obj1).getAction());

                        out.writeObject(turn);


                        //inizio opt turno
                        //in base all' azione cheaveva scelto l'azione x entro in un ramo dell'if...else... diffrente
                        if (turn.getAction().equals("buy develop card")) {

                            obj1 = in.readObject();

                            if (obj1 instanceof BuyDevelopCardMsg) {

                                ((BuyDevelopCardMsg) obj1).process(view);

                                SelectedDevCardMsg BuyDevCard = new SelectedDevCardMsg();
                                BuyDevCard.setChosenIndex(((BuyDevelopCardMsg) obj1).getChosenIndex());
                                BuyDevCard.setLvl1(((BuyDevelopCardMsg) obj1).getLvl1());
                                BuyDevCard.setLvl2(((BuyDevelopCardMsg) obj1).getLvl2());
                                BuyDevCard.setLvl3(((BuyDevelopCardMsg) obj1).getLvl3());

                                out.writeObject(BuyDevCard);

                                boolean validSlot = false;

                                //finchè lo slot è invalido lo richiedo
                                while (validSlot) {

                                    obj1 = in.readObject();

                                    if (obj1 instanceof SlotForDevCardMsg) {
                                        //inizialmente falso
                                        if (!((SlotForDevCardMsg) obj1).getValidSlot()) {

                                            ((SlotForDevCardMsg) obj1).process(view);

                                            SelectedSlotMsg slotResponse = new SelectedSlotMsg();
                                            slotResponse.setChosenSlot(((SlotForDevCardMsg) obj1).getChosenSlot());
                                            slotResponse.setPlayer(((SlotForDevCardMsg) obj1).getPlayer());

                                            out.writeObject(slotResponse);
                                        } else if (((SlotForDevCardMsg) obj1).getValidSlot()) {
                                            validSlot = true;
                                        }

                                    } else if (!(obj1 instanceof SlotForDevCardMsg)) {
                                        validSlot = true; // esce
                                    }

                                }


                            }

                        }
                        //Ho messo sia "m" che "M" come stringa valida
                        else if(view.startTurn(((StartTurnMsg) obj1).getMarket(), ((StartTurnMsg) obj1).getDevDeck()).equals("m") || view.startTurn(((StartTurnMsg) obj1).getMarket(), ((StartTurnMsg) obj1).getDevDeck()).equals("M")){
                            out.writeObject(view.goToMarket(((StartTurnMsg) obj1).getMarket()));
                        }


                    }
                }
                else if(obj1 instanceof ) {

                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connection failed. Port Number Invalid");
        }


    }

}