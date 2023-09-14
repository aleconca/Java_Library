package Project.ingsw.client.View;

import it.polimi.ingsw.server.Model.DevelopCard;

import java.util.ArrayList;

public class SearchCardsMethods2 {

    int i;

    //metodi ricerca carte per stamparle

    public int searchCardLvl3(ArrayList<DevelopCard> cards, int cardNum) {

        //cards==lvl3

        if (cards.size() == 0) {
            return -1;//array vuoto
        }


        //livello non vuoto
        if (cardNum == 1) {

            //cerco carta lvl3 verde
            for (int j = 0; j < cards.size(); ) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.G) ) {
                    return j;//ritorna inidce
                }else{
                    j++;
                }
            }


        } else if (cardNum == 4) {

            //cerco carta lvl3 azzurra
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.B)) {
                    return j;
                }else{
                    j++;
                }
            }


        } else if (cardNum == 7) {

            //cerco carta lvl3 gialla
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.Y)) {
                    return j;
                }else{
                    j++;
                }
            }


        } else if (cardNum == 10) {

            //cerco carta lvl2 viola
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.P)) {
                    return j;
                }else{
                    j++;
                }
            }

        }

        return -1;//cards finished


    }


    public int searchCardLvl2(ArrayList<DevelopCard> cards, int cardNum) {
        //cards==lvl2

        if (cards.size() == 0) {
            return -1;
        }


        //livello non vuoto
        if (cardNum == 2) {

            //cerco carta lvl2 verde
            for (int j = 0; j < cards.size(); ) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.G)) {
                    return j;
                }else{
                    j++;
                }
            }


        } else if (cardNum == 5) {

            //cerco carta lvl2 azzurra
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.B)) {
                    return j;
                }else{
                    j++;
                }
            }

        } else if (cardNum == 8) {

            //cerco carta lvl2 gialla
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.Y)) {
                    return j;
                }else{
                    j++;
                }
            }


        } else if (cardNum == 11) {

            //cerco carta lvl2 viola
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.P)) {
                   return j;
                }else {
                    j++;
                }
            }

        }

        return -1;
    }


    public int searchCardLvl1(ArrayList<DevelopCard> cards,int cardNum) {

        //cards==lvl1

        if (cards.size() == 0) {
            return -1;
        }

        //livello non vuoto
        if (cardNum == 3) {

            //cerco carta lvl1 verde
            for (int j = 0; j < cards.size();) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.G)) {
                    return j;

                }else {
                    j++;
                }
            }


        } else if (cardNum == 6) {

            //cerco carta lvl1 azzurra
            for (int j = 0; j < cards.size(); ) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.B)) {
                    return j;
                }else {
                    j++;
                }
            }

        } else if (cardNum == 9) {

            //cerco carta lvl1 gialla
            for (int j = 0; j < cards.size(); ) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.Y)) {
                    return j;
                }else {
                    j++;
                }
            }

        } else if (cardNum == 12) {

            //cerco carta lvl1 viola
            for (int j = 0; j < cards.size(); ) {
                if (cards.get(j).getColour().equals(DevelopCard.Colour.P)) {
                    return j;
                }else {
                    j++;
                }
            }


        }

        return -1;
    }






    }


