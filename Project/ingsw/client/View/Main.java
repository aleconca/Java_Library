package Project.ingsw.client.View;

import it.polimi.ingsw.server.Model.DevelopCard;
import it.polimi.ingsw.server.Model.DevelopCardDeck;
import it.polimi.ingsw.server.Model.Resource;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args){
        Resource coin = new Resource("coin");
        Resource servant = new Resource("servant");
        Resource shield = new Resource("faith indicator");

        /*ArrayList<Resource> cost= new ArrayList<>();
        cost.add(coin);
        cost.add(servant);
        cost.add(shield);

        ArrayList<Resource> requires= new ArrayList<>();
        requires.add(coin);
        requires.add(servant);
        requires.add(shield);

        ArrayList<Resource> produces= new ArrayList<>();
        produces.add(coin);
        produces.add(servant);
        produces.add(shield);

        DevelopCard devCard= new DevelopCard(1,cost,1,requires,produces);
        devCard.setColour(DevelopCard.Colour.B);
        DevelopCard devCard2= new DevelopCard(2,cost,2,requires,produces);
        devCard2.setColour(DevelopCard.Colour.G);
        DevelopCard devCard3= new DevelopCard(3,cost,8,requires,produces);
        devCard3.setColour(DevelopCard.Colour.P);
        DevelopCard devCard4= new DevelopCard(2,cost,11,requires,produces);
        devCard4.setColour(DevelopCard.Colour.Y);*/


        //devCard  test = new devCard(devCard);
        /*ArrayList<DevelopCard> test = new ArrayList<>();
        test.add(devCard);
        test.add(devCard2);
        test.add(devCard3);
        test.add(devCard4);
        test.add(devCard);
        test.add(devCard2);
        test.add(devCard3);
        test.add(devCard4);



        ArrayList<DevelopCard> lvl1 = test;
        ArrayList<DevelopCard> lvl2 = test;
        ArrayList<DevelopCard> lvl3 = test;

        int cardNum = 0;


        Prova searchMethods = new Prova();
        int index;

        for (int i = 0; i < 4; i++) {

            cardNum++;
            //lvl3
            System.out.print("\ncard : " + cardNum);

            index = searchMethods.searchCardLvl3(lvl3,cardNum);

            if (index>=0) {
                devCard cardView = new devCard(lvl3.get(index));
            }else{
                System.out.println("\nCards finished.");
            }


            cardNum++;

            //lvl2
            System.out.print("\ncard : " + cardNum);

            index = searchMethods.searchCardLvl2(lvl2,cardNum);

            if (index>=0) {
                devCard cardView = new devCard(lvl2.get(index));
            }else{
                System.out.println("\nCards finished.");
            }

            cardNum++;

            //lvl1
            System.out.print("\ncard : " + cardNum);

            index = searchMethods.searchCardLvl1(lvl1,cardNum);

            if (index>=0) {
                devCard cardView = new devCard(lvl1.get(index));
            }else{
                System.out.println("\nCards finished.");
            }



        }*/


        DevelopCardDeck developCardDeck = DevelopCardDeck.getInstance();
        GridCardView gridCardView = new GridCardView(developCardDeck);
        gridCardView.showGrid();

        /*ArrayList<Resource> cost= new ArrayList<>();
        cost.add(coin);
        cost.add(servant);
        cost.add(shield);

        ArrayList<Resource> requires= new ArrayList<>();
        requires.add(coin);
        requires.add(servant);
        requires.add(shield);

        ArrayList<Resource> produces= new ArrayList<>();
        produces.add(coin);
        produces.add(servant);
        produces.add(shield);

        DevelopCard devCard= new DevelopCard(1,cost,1,requires,produces);
        devCard.setColour(DevelopCard.Colour.B);
        DevelopCard devCard2= new DevelopCard(2,cost,2,requires,produces);
        devCard2.setColour(DevelopCard.Colour.G);
        DevelopCard devCard3= new DevelopCard(3,cost,8,requires,produces);
        devCard3.setColour(DevelopCard.Colour.P);
        DevelopCard devCard4= new DevelopCard(2,cost,11,requires,produces);
        devCard4.setColour(DevelopCard.Colour.Y);



        ArrayList<DevelopCard> test = new ArrayList<>();
        test.add(devCard);
        test.add(devCard2);
        test.add(devCard3);
        test.add(devCard4);
        test.add(devCard);
        test.add(devCard2);
        test.add(devCard3);
        test.add(devCard4);



        ArrayList<DevelopCard> lvl1 = test;
        ArrayList<DevelopCard> lvl2 = test;
        ArrayList<DevelopCard> lvl3 = test;*/




    }
}
