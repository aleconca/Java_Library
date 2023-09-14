package Project.ingsw.client.View;


import it.polimi.ingsw.server.Model.Color;
import it.polimi.ingsw.server.Model.DevelopCard;
import java.util.ArrayList;
import java.util.List;


public class devCard {
    private static final int MAX_VP = 12;
    private  int MAX_VERT_BOARD = 6;
    private  int MAX_HORIZ_BOARD =  9;



    private String borders[][] = new String[MAX_VERT_BOARD][MAX_HORIZ_BOARD];

    private List<String> elements = new ArrayList<>();

    public devCard(DevelopCard devCard){

        setBorders();
        setFlagsandLevels(devCard);
        setCost(devCard);
        setVP(devCard);
        setRequiresandProduces(devCard);
        plot();

    }

    /*@ensures(*creates card's borders*)*/
    private void setBorders() {


        borders[0][0] = "--";
        for (int c = 1; c < MAX_HORIZ_BOARD - 1; c++) {
            borders[0][c] = "-";
        }

        borders[0][MAX_HORIZ_BOARD - 1] = "--";

        for (int r = 1; r < MAX_VERT_BOARD - 1; r++) {
            borders[r][0] = " ";
            for (int c = 1; c < MAX_HORIZ_BOARD - 1; c++) {
                borders[r][c] = "";
            }
            borders[r][MAX_HORIZ_BOARD - 1] = " ";
        }

        borders[MAX_VERT_BOARD - 1][0] = Color.RESET + "--";
        for (int c = 1; c < MAX_HORIZ_BOARD - 1; c++) {
            borders[MAX_VERT_BOARD - 1][c] = "-";
        }

        borders[MAX_VERT_BOARD - 1][MAX_HORIZ_BOARD - 1] = "--";

    }

    /*@requires(*devCard not Null*)
     *@ensures(*set level*)*/
    private void setFlagsandLevels(DevelopCard devCard) {

        DevelopCard.Colour color = devCard.getColour();
        String blackEscape = Colour.ANSI_BLACK.escape();

        switch (color) {

            case P:
                if (devCard.getLevel() == 1) {
                    borders[1][2] = Colour.ANSI_PURPLE.escape() + " level1" + blackEscape;
                } else if (devCard.getLevel() == 2) {
                    borders[1][2] = Colour.ANSI_PURPLE.escape() + " level2" + blackEscape;
                } else if (devCard.getLevel() == 3) {
                    borders[1][2] = Colour.ANSI_PURPLE.escape() + " level3" + blackEscape;
                }
                break;
            case G:
                if (devCard.getLevel() == 1) {
                    borders[1][2] = Colour.ANSI_GREEN.escape() + " level1" + blackEscape;
                } else if (devCard.getLevel() == 2) {
                    borders[1][2] = Colour.ANSI_GREEN.escape() + " level2" + blackEscape;
                } else if (devCard.getLevel() == 3) {
                    borders[1][2] = Colour.ANSI_GREEN.escape() + " level3" + blackEscape;
                }
                break;
            case Y:
                if (devCard.getLevel() == 1) {
                    borders[1][2] = Colour.ANSI_YELLOW.escape() + " level1" + blackEscape;
                } else if (devCard.getLevel() == 2) {
                    borders[1][2] = Colour.ANSI_YELLOW.escape() + " level2" + blackEscape;
                } else if (devCard.getLevel() == 3) {
                    borders[1][2] = Colour.ANSI_YELLOW.escape() + " level3" + blackEscape;
                }
                break;
            case B:
                if (devCard.getLevel() == 1) {
                    borders[1][2] = Colour.ANSI_BLUE.escape() + " level1" + blackEscape;
                } else if (devCard.getLevel() == 2) {
                    borders[1][2] = Colour.ANSI_BLUE.escape() + " level2" + blackEscape;
                } else if (devCard.getLevel() == 3) {
                    borders[1][2] = Colour.ANSI_BLUE.escape() + " level3" + blackEscape;
                }
                break;
        }
    }

    /*@requires(*devCard not Null*)
     *@ensures(*set cost*)*/
    private void setCost(DevelopCard devCard){
        int j = 2;
        String blackEscape = Colour.ANSI_BLACK.escape();

        for (int i=0; i<devCard.getCost().size()-1 ;i++) {
            if (devCard.getCost().get(i).getResourcename().equals("coin")) {
                borders[2][j] = Colour.ANSI_YELLOW.escape()  +  " \u24b8" + blackEscape;

            }else if(devCard.getCost().get(i).getResourcename().equals("stone")){
                borders[2][j] = Colour.ANSI_BLACK.escape() + "\u2b1f" + blackEscape;

            }else if(devCard.getCost().get(i).getResourcename().equals("servant")){
                borders[2][j] = Colour.ANSI_PURPLE.escape() + "\u26d1" + blackEscape;

            }else if(devCard.getCost().get(i).getResourcename().equals("shield")){
                borders[2][j] = Colour.ANSI_BLUE.escape() + "\u26e8" + blackEscape ;

            }
            j++;
        }
    }

    /*@requires(*devCard not Null*)
     *@ensures(*set victory points)0 to 12)*)*/
    public void setVP(DevelopCard devCard) {
        String blackEscape = Colour.ANSI_BLACK.escape();

        for (int i=1; i<=MAX_VP ;i++) {
            if (devCard.getVictoryPoints() == i) {

                borders[3][2] = "  -"+i ;
                borders[3][4] = Colour.ANSI_YELLOW.escape() +  "VP" + blackEscape;
                borders[3][6] = "-  ";

            }
        }
    }



    /*@requires(*devCard not Null*)
     *@ensures(*set symbols*)*/
    private void setRequiresandProduces(DevelopCard devCard) {
        int j = 0;
        String blackEscape = Colour.ANSI_BLACK.escape();

        for (int i = 0; i<=devCard.getRequires().size()-1; i++) {
            if (devCard.getRequires().get(i).getResourcename().equals("coin")) {
                borders[4][j] =  Colour.ANSI_YELLOW.escape()  + " \u24b8" + blackEscape;

            }else if(devCard.getRequires().get(i).getResourcename().equals("stone")){
                borders[4][j] = Colour.ANSI_BLACK.escape()  +  "\u2b1f" + blackEscape;

            }else if(devCard.getRequires().get(i).getResourcename().equals("servant")){
                borders[4][j] = Colour.ANSI_PURPLE.escape()  + "\u26d1" + blackEscape ;

            }else if(devCard.getRequires().get(i).getResourcename().equals("shield")){
                borders[4][j] = Colour.ANSI_BLUE.escape()  +  "\u26e8" + blackEscape ;

            }
            j++;
        }

        borders[4][j]="}";

        j++;



        for (int i = 0; i<=devCard.getProduces().size()-1; i++) {
            if (devCard.getProduces().get(i).getResourcename().equals("coin")) {
                borders[4][j] = Colour.ANSI_YELLOW.escape()  + "\u24b8" + blackEscape;

            }else if(devCard.getProduces().get(i).getResourcename().equals("stone")){
                borders[4][j] = Colour.ANSI_BLACK.escape()  +"\u2b1f" + blackEscape;

            }else if(devCard.getProduces().get(i).getResourcename().equals("servant")){
                borders[4][j] = Colour.ANSI_PURPLE.escape()  +"\u26d1" + blackEscape;

            }else if(devCard.getProduces().get(i).getResourcename().equals("shield")){
                borders[4][j] = Colour.ANSI_BLUE.escape()  +"\u26e8" + blackEscape ;

            }else {
                borders[4][j] = Colour.ANSI_RED.escape() + "\uD83D\uDD42" + blackEscape ;
            }
            j++;
        }

    }



    /*@requires(*devCard not Null*)
     *@ensures(*prints the card in the corresponding colour*)*/
    final void plot() {


        for (int r = 0; r < MAX_VERT_BOARD; r++) {
            System.out.println();
            for (int c = 0; c < MAX_HORIZ_BOARD; c++) {
                System.out.print(borders[r][c]);
            }
        }


    }

}


