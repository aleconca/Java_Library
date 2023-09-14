package Project.ingsw.client.View;

import it.polimi.ingsw.Exceptions.ArrayDontFitException;
import it.polimi.ingsw.Exceptions.IncorrectMoveException;
import it.polimi.ingsw.server.Controller.Game;
import it.polimi.ingsw.server.Model.*;

import java.io.IOException;
import java.util.ArrayList;

public interface View {

    //metodi per messaggi implementati diversamente in CLI e GUI
    /**
     * Method to prepare the Pre Game:
     * - let players draw Leader Cards
     * - let players choose resources
     */
    void initGame(Player player,ArrayList<LeaderCard> cards) throws IncorrectMoveException, ArrayDontFitException, IOException;

    /**
     * The start of each turn; user can choose the action to do as first
     * @return the enum/string representing the action chosen
     * */
    String startTurn(Market market, DevelopCardDeck developCardDeck);

    void  ShowDevCards(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3, Player player) throws IOException;

    void ShowMarket(Market market); //Si potrebbe togliere

    void ShowDashboardSingle(Player player);

    void ShowActionSignal(Game game);

    void printError(String error);

    void ActivateProduction(Player player) throws IOException;

    void SlotError(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3,
                   String chosenIndex, String chosenSlotIndex,Player player) throws IOException;

    void EndGame(Player player);
}
