package Project.ingsw.client.View;



public enum Colour {
    ANSI_GREEN("\u001B[32m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_ORANGE("\u001B[33m"),
    ANSI_WHITE("\u001B[97m"),
    ANSI_GREY("\u001B[90m");


    static final String RESET = "\u001B[0m";

    private String escape;

    Colour(String escape) {
        this.escape = escape;
    }
    public String escape(){
        return escape;
    }

    @Override
    public String toString() {
        return escape;
    }
}