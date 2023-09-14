package Project.ingsw.client.View;

import it.polimi.ingsw.server.Model.DevelopCard;

import java.util.ArrayList;

public class DeckDevelopCardView {


    public DeckDevelopCardView(ArrayList<DevelopCard> lvl1, ArrayList<DevelopCard> lvl2, ArrayList<DevelopCard> lvl3) {
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
    }
}
