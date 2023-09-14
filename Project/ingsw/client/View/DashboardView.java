package Project.ingsw.client.View;

import it.polimi.ingsw.server.Model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DashboardView {

    private Player player;

    private final String BOX = "\u25a1 ";
    private final String POPEBOX = "\u26ea";
    private final String FAITHINDICATOR = "\u271d";
    private final String PFC2 = "\u2461";

    private final String[] COIN = {"\u24b8"};
    private final String[] STONE = {"\u2b1f"};
    private final String[] SHIELD = {"\u26e8"};
    private final String[] SERVANT = {"\u26d1"};

    /**
     * When creating a dashboard, it will be associated to a specific player
     * @param p is the player owner of the dashboard
     * */
    public DashboardView(Player p) {
        this.player = p;
    }

    /**
     * This will print out all the components of the dashboard
     */
    public void visualizePerMulti() {
        System.out.println("This is your DASHBOARD:");
        visualizeFaithRoute(player.getDashboard().getFaithRoute());
        System.out.println("--------------------------------------------------");
        visualizeStorage(player.getDashboard().getStorage());
        System.out.println("--------------------------------------------------");
        visualizeCoffer(player.getDashboard().getCoffer());
        System.out.println("--------------------------------------------------");
        //p.getCardSlot().visualizeCardSlots();
    }
    public void visualizePerSingle() {
        System.out.println("This is your DASHBOARD:");
        visualizeFaithRouteSingle(player.getDashboard().getFaithRoute());
        System.out.println("--------------------------------------------------");
        visualizeStorage(player.getDashboard().getStorage());
        System.out.println("--------------------------------------------------");
        visualizeCoffer(player.getDashboard().getCoffer());
        System.out.println("--------------------------------------------------");
        //p.getCardSlot().visualizeCardSlots();
    }

    /**
     * Method to visualize the faithroute
     */
    public void visualizeFaithRoute(FaithRoute faithRoute){
        System.out.println("\n\n** FAITH ROUTE **\n");
        for (int i=0; i<faithRoute.getRoute().size(); i++){
            if (faithRoute.getRoute().get(i).getReportBox() != 0 && !faithRoute.getRoute().get(i).isPopeBox())
                System.out.print(Colour.ANSI_ORANGE + POPEBOX + Colour.RESET);
            else if (faithRoute.getRoute().get(i).getReportBox() != 0 && faithRoute.getRoute().get(i).isPopeBox())
                System.out.print(Colour.ANSI_RED + POPEBOX + Colour.RESET);
            else
                System.out.print(BOX);
        }
        System.out.println();
        for (int i=0; i<=faithRoute.getFaithIndicator(); i++){
            if (i==faithRoute.getFaithIndicator())
                System.out.println(Colour.ANSI_RED + FAITHINDICATOR + Colour.RESET);
            else
                System.out.print("  ");
        }
        System.out.println();
    }
    // Dite che serve aggiungere degli indicatori per far vedere a che punto sono gli avversari? O chissene?

    /**
     * Method to visualize the faithroute for singleplayer
     */
    // Andrà bene uguale?
    // DA TESTARE SE STAMPA GIUSTO!
    public void visualizeFaithRouteSingle(FaithRoute faithRoute){
        visualizeFaithRoute(faithRoute);
        for (int i=0; i<=faithRoute.getFaithIndicatorLorenzo(); i++){
            if (i==faithRoute.getFaithIndicatorLorenzo())
                System.out.println(Colour.ANSI_BLACK + FAITHINDICATOR + Colour.RESET);
            else
                System.out.print("  ");
        }
        System.out.println();
    }

    /**
     * Method to print the storage
     */
    public void visualizeStorage(Storage s){
        System.out.println("\n\n\n** STORAGE **\n");
        ArrayList<Resource> level;
        level = s.getLvl1();
        if (s.getLvl1().isEmpty() && s.getLvl2().isEmpty() && s.getLvl3().isEmpty()) {
            System.out.println("STORAGE IS EMPTY\n");
        }
        else {
            if (!s.getLvl1().isEmpty()){
                System.out.print("1 ->  ");
                PrintResource(level.get(0).getResourcename());
            }
            else
                System.out.print("1 -> EMPTY");
            if (!s.getLvl2().isEmpty()) {
                level = s.getLvl2();
                System.out.print("\n\n2 ->  ");
                for (int i = 0; i < level.size(); i++) {
                    PrintResource(level.get(i).getResourcename());
                    System.out.print("  ");
                }
            }
            else
                System.out.print("\n\n2 -> EMPTY");
            if (!s.getLvl3().isEmpty()) {
                level = s.getLvl3();
                System.out.print("\n\n3 ->  ");
                for (int i = 0; i < level.size(); i++) {
                    PrintResource(level.get(i).getResourcename());
                    System.out.print("  ");
                }
            }
            else
                System.out.print("\n\n3 -> EMPTY\n\n");
        }
    }

    private void PrintResource(String res){
        switch (res) {
            case "coin" -> System.out.print(Colour.ANSI_YELLOW + Arrays.toString(COIN) + Colour.RESET);
            case "stone" -> System.out.print(Colour.ANSI_GREY + Arrays.toString(STONE) + Colour.RESET);
            case "servant" -> System.out.print(Colour.ANSI_PURPLE + Arrays.toString(SERVANT) + Colour.RESET);
            case "shield" -> System.out.print(Colour.ANSI_BLUE + Arrays.toString(SHIELD) + Colour.RESET);
        }
    }


    /**
     * Method to visualize the coffer
     * @param c coffer took from the player instance
     */
    public void visualizeCoffer(Coffer c) {
        System.out.println("** COFFER **");
        System.out.println("Coins" + Colour.ANSI_YELLOW + Arrays.toString(COIN) + Colour.RESET + " : " + c.numberOf("coin") + ",");
        System.out.println("Servants" + Colour.ANSI_PURPLE + Arrays.toString(SERVANT) + Colour.RESET + " : " + c.numberOf("servant") + ",");
        System.out.println("Shields" + Colour.ANSI_BLUE + Arrays.toString(SHIELD) + Colour.RESET + " : " + c.numberOf("shield") + ",");
        System.out.println("Stones" + Colour.ANSI_GREY + Arrays.toString(STONE) + Colour.RESET + " : " + c.numberOf("stone") + ",");
        System.out.println("--------------\n");
        System.out.println("Total = " + c.getTotal()); //forse inutile
    }
}
