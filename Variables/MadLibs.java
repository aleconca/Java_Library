package Variables;

import java.util.*;

public class MadLibs {

        /*
          This program generates a mad libbed story.
          Author: Alessia
          Date: 28/10/2020
        */
        public static void main(String[] args){
            
            String name1="Alessia";
            String adjective1 = "Stupid";
            String adjective2 = "Individualist";
            String adjective3 = "Pallid";

            String verb1 ="live";

            String noun1 = "cat";
            String noun2 = "ehhhm";
            String noun3 = "poop";
            String noun4 = "piano";
            String noun5 = "I really don't know , sorry";
            String noun6 = "broccoli";

            String name2 = "Panzi";

            int number = 21;

            String place1 = "Pun de legn";

            //The template for the story
            String story = "This morning "+name1+
                    " woke up feeling "+adjective1+". 'It is going to be a "+adjective2+
                    " day!' Outside, a bunch of "+noun1+"s were protesting to keep "+noun2+
                    " in stores. They began to "+verb1+" to the rhythm of the "+noun3+
                    ", which made all the "+noun4+"s very "+adjective3+
                    ". Concerned, "+name1+" texted "+name2+", who flew "+name1+
                    " to "+place1+" and dropped "+name1+" in a puddle of frozen "+noun5+
                    ". "+name1+" woke up in the year "+number+", in a world where "+noun6+"s ruled the world.";

            System.out.println(story);

        }

}
