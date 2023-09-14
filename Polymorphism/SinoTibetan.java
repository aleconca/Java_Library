package Polymorphism;

public class SinoTibetan extends Language{


    public  SinoTibetan(String languageName, int speakers) {
        super(languageName, speakers, "Asia", "subject-object-verb");
        if (languageName.contains("Chinese")) {
            this.wordOrder = "subject-verb-object";
        }
    }

}
