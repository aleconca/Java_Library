package Polymorphism;

public class Language {

    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;



    public Language(String language, int speakers, String regions, String order){
        this.name=language;
        this.numSpeakers=speakers;
        this.regionsSpoken=regions;
        this.wordOrder=order;
    }

    public void getInfo(){
        System .out.println( this.name +"is spoken by" +numSpeakers+"people mainly in" +this.regionsSpoken+".");

        System.out.println("The language follows the word order: " + this.wordOrder);

    }

    public static void main(String[] args) {
        Language Francais = new Language("French", 275000000, "France", "subject+verb+object");

        Francais.getInfo();

        Mayan kiche = new Mayan("Ki'che'", 2330000);
        kiche.getInfo();


        SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 1110000000);
        mandarin.getInfo();
        SinoTibetan burmese = new SinoTibetan("Burmese", 43000000);
        burmese.getInfo();

    }


}

