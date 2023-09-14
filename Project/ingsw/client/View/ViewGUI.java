package Project.ingsw.client.View;


import it.polimi.ingsw.server.Controller.Game;
import it.polimi.ingsw.server.Model.*;

import java.util.ArrayList;

public class ViewGUI implements View //extends Application (perchè deve essere in JavaFX)
{
    @Override
    public String startTurn(Market market, DevelopCardDeck developCardDeck) {
        return null;
    }


    @Override
    public void initGame(Player player,ArrayList<LeaderCard> cards) { }

    @Override
    public void ShowDevCards(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3, Player player) {

    }


    @Override
    public void ShowMarket(Market market) {

    }

    @Override
    public void ShowDashboardSingle(Player player) {

    }

    @Override
    public void ShowActionSignal(Game game) {

    }

    @Override
    public void printError(String error) {

    }


    @Override
    public void ActivateProduction(Player player) {

    }

    @Override
    public void SlotError(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3,
                          String chosenIndex, String chosenSlotIndex,Player player) {

    }
}
