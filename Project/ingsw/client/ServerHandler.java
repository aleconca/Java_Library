package Project.ingsw.client;

import it.polimi.ingsw.Exceptions.ArrayDontFitException;
import it.polimi.ingsw.Exceptions.IncorrectMoveException;
import it.polimi.ingsw.Network.MessageToClient.ActionSignalMsg;
import it.polimi.ingsw.Network.MessageToClient.MessageToClient;
import it.polimi.ingsw.Network.MessageToServer.MessageToServer;
import it.polimi.ingsw.client.View.ViewCLI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler implements Runnable {

    private Socket server;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private MessageToClient m;
    private ViewCLI viewCLI;
    private String username;

    public ServerHandler(Socket server, String username, ViewCLI viewCLI) {
        this.server = server;
        this.viewCLI = viewCLI;
        this.username = username;
    }

    @Override
    public void run() {
        //Creazione streams
        try {
            out = new ObjectOutputStream(server.getOutputStream());
            in = new ObjectInputStream(server.getInputStream());

            out.writeObject(username);
            String s = (String) in.readObject();
            System.out.println(s);
            if (s.equals("Login success... you are PLAYER 1 (HOST)")) {
                out.writeObject(sendPlayers());
            }
            /*boolean gs = (boolean) in.readObject();
            if (gs)
                System.out.println("\nGAME STARTED!");*/

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error on streams");
            e.printStackTrace();
        }


        //Ricezione messaggi input dal server
        while(true){
            try {
                m = (MessageToClient) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                m.process(viewCLI);

            } catch (IncorrectMoveException e) {
                e.printStackTrace();
            } catch (ArrayDontFitException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Invio dei messaggi
    //Try-catch ?
    public void sendMsg(MessageToServer msg) throws IOException {
        out.writeObject(msg);
    }

    private int sendPlayers() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;
        int y = 0;
        do {
            System.out.print("Number of players? [ 2 , 3 , 4 ]  for Multiplayer , [ 1 ] for Singleplayer  ");
            numberOfPlayers = scanner.nextInt();
            if (numberOfPlayers > 0 && numberOfPlayers < 5) {
                return numberOfPlayers;
            }
            y++;
            if (y > 0)
                System.out.println("Invalid number! Retry...");
        } while (numberOfPlayers < 1 || numberOfPlayers > 4);
        return -1;
    }
}
