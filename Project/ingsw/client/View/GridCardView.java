package Project.ingsw.client.View;

import it.polimi.ingsw.server.Model.ActionSignal;
import it.polimi.ingsw.server.Model.Color;
import it.polimi.ingsw.server.Model.DevelopCard;
import it.polimi.ingsw.server.Model.DevelopCardDeck;

import java.util.ArrayList;
import java.util.Collections;

public class GridCardView {

    private ArrayList<DevelopCard> lev1;
    private ArrayList<DevelopCard> lev2;
    private ArrayList<DevelopCard> lev3;

    private ArrayList<DevelopCard> mazzoGiallo1;
    private ArrayList<DevelopCard> mazzoVerde1;
    private ArrayList<DevelopCard> mazzoViola1;
    private ArrayList<DevelopCard> mazzoBlu1;

    private ArrayList<DevelopCard> mazzoGiallo2;
    private ArrayList<DevelopCard> mazzoVerde2;
    private ArrayList<DevelopCard> mazzoViola2;
    private ArrayList<DevelopCard> mazzoBlu2;

    private ArrayList<DevelopCard> mazzoGiallo3;
    private ArrayList<DevelopCard> mazzoVerde3;
    private ArrayList<DevelopCard> mazzoViola3;
    private ArrayList<DevelopCard> mazzoBlu3;

    public GridCardView(DevelopCardDeck developCardDeck) {
        this.lev1 = new ArrayList<>(16);
        this.lev2 = new ArrayList<>(16);
        this.lev3 = new ArrayList<>(16);
        this.mazzoBlu1 = new ArrayList<>(4);
        this.mazzoGiallo1 = new ArrayList<>(4);
        this.mazzoVerde1 = new ArrayList<>(4);
        this.mazzoViola1 = new ArrayList<>(4);
        this.mazzoBlu2 = new ArrayList<>(4);
        this.mazzoGiallo2 = new ArrayList<>(4);
        this.mazzoVerde2 = new ArrayList<>(4);
        this.mazzoViola2 = new ArrayList<>(4);
        this.mazzoBlu3 = new ArrayList<>(4);
        this.mazzoGiallo3 = new ArrayList<>(4);
        this.mazzoVerde3 = new ArrayList<>(4);
        this.mazzoViola3 = new ArrayList<>(4);
        mazzetti(developCardDeck);
    }

    private void mazzetti(DevelopCardDeck developCardDeck){
        addLev1(developCardDeck);
        addLev2(developCardDeck);
        addLev3(developCardDeck);
    }

    private void addLev1(DevelopCardDeck developCardDeck){

        for (int i=0; i<developCardDeck.getLvl1().size(); i++){
            lev1.add(developCardDeck.getLvl1().get(i));
            if (lev1.get(i).getColour().equals(DevelopCard.Colour.B)){
                mazzoBlu1.add(lev1.get(i));
            }
            else if (lev1.get(i).getColour().equals(DevelopCard.Colour.Y))
                mazzoGiallo1.add(lev1.get(i));
            else if (lev1.get(i).getColour().equals(DevelopCard.Colour.P))
                mazzoViola1.add(lev1.get(i));
            else if (lev1.get(i).getColour().equals(DevelopCard.Colour.G))
                mazzoVerde1.add(lev1.get(i));
        }
        shuffleMazzetto(mazzoBlu1);
        shuffleMazzetto(mazzoVerde1);
        shuffleMazzetto(mazzoViola1);
        shuffleMazzetto(mazzoGiallo1);
    }

    private void addLev2(DevelopCardDeck developCardDeck){

        for (int i=0; i<developCardDeck.getLvl2().size(); i++){
            lev2.add(developCardDeck.getLvl2().get(i));
            if (lev2.get(i).getColour().equals(DevelopCard.Colour.B)){
                mazzoBlu2.add(lev2.get(i));
            }
            else if (lev2.get(i).getColour().equals(DevelopCard.Colour.Y))
                mazzoGiallo2.add(lev2.get(i));
            else if (lev2.get(i).getColour().equals(DevelopCard.Colour.P))
                mazzoViola2.add(lev2.get(i));
            else if (lev2.get(i).getColour().equals(DevelopCard.Colour.G))
                mazzoVerde2.add(lev2.get(i));
        }
        shuffleMazzetto(mazzoBlu2);
        shuffleMazzetto(mazzoVerde2);
        shuffleMazzetto(mazzoViola2);
        shuffleMazzetto(mazzoGiallo2);
    }

    private void addLev3(DevelopCardDeck developCardDeck){

        for (int i=0; i<developCardDeck.getLvl3().size(); i++){
            lev3.add(developCardDeck.getLvl3().get(i));
            if (lev3.get(i).getColour().equals(DevelopCard.Colour.B)){
                mazzoBlu3.add(lev3.get(i));
            }
            else if (lev3.get(i).getColour().equals(DevelopCard.Colour.Y))
                mazzoGiallo3.add(lev3.get(i));
            else if (lev1.get(i).getColour().equals(DevelopCard.Colour.P))
                mazzoViola3.add(lev3.get(i));
            else if (lev1.get(i).getColour().equals(DevelopCard.Colour.G))
                mazzoVerde3.add(lev3.get(i));
        }
        shuffleMazzetto(mazzoBlu3);
        shuffleMazzetto(mazzoVerde3);
        shuffleMazzetto(mazzoViola3);
        shuffleMazzetto(mazzoGiallo3);
    }

    public void showGrid(){
        System.out.println(Color.ANSI_RED + "**"+ Color.RESET + " DEV CARDS GRID " + Color.ANSI_RED+" **\n" + Color.RESET);
        System.out.println(Color.ANSI_RED + "--"+ Color.RESET +" LEVEL 1 " + Color.ANSI_RED +"--" + Color.RESET);
        devCard devCard1 = new devCard(mazzoVerde1.get(0));
        devCard devCard2 = new devCard(mazzoBlu1.get(0));
        devCard devCard3 = new devCard(mazzoGiallo1.get(0));
        devCard devCard4 = new devCard(mazzoViola1.get(0));

        System.out.println(Color.ANSI_RED + "\n\n--"+ Color.RESET +" LEVEL 2 " + Color.ANSI_RED +"--" + Color.RESET);

        devCard devCard5 = new devCard(mazzoVerde2.get(0));
        devCard devCard6 = new devCard(mazzoBlu2.get(0));
        devCard devCard7 = new devCard(mazzoGiallo2.get(0));
        devCard devCard8 = new devCard(mazzoViola2.get(0));

        System.out.println(Color.ANSI_RED + "\n\n--"+ Color.RESET +" LEVEL 3 " + Color.ANSI_RED +"--" + Color.RESET);

        devCard devCard9 = new devCard(mazzoVerde3.get(0));
        devCard devCard10 = new devCard(mazzoBlu3.get(0));
        devCard devCard11= new devCard(mazzoGiallo3.get(0));
        devCard devCard12 = new devCard(mazzoViola3.get(0));
    }

    private void shuffleMazzetto(ArrayList<DevelopCard> mazzetto){
        Collections.shuffle(mazzetto);
    }

}


