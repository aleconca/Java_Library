package Variables;

public class MadLibs2 {
    /*this program generates a funny story, or at least I hope*/

    public static void main(String[] args){

        String name1 ="Alessia ";
        String name2 = "Panzi";

        String adj1="Fool";
        String adj2= "Senile";
        String adj3 = "ehm";

        String place = "vancuver";

        String story = "Hi,"+ name1+"and "+ name2+
        " you are "+adj1+" and "+adj2+" ... "+adj3+ "\\nand you live in"+place ;

        System.out.println(story);

        boolean result = name1.equals(name2);

        System.out.println(result);

        String one = "Prima stringa";
        String two = "Seconda stringa";

        one = two; //one punta a two

        System.out.println(one +"\n"+ two);

        result = name1.contains("P");

        System.out.println(result);

        String blankSpace = " Stringa con spazi ";

        System.out.println(blankSpace);

        blankSpace = blankSpace.trim();

        blankSpace.length();

        int num = name1.indexOf("e");//-1 se non presente
        char num1 = adj3.charAt(1);
        adj1=adj1.replace("Foo","P");

        adj2= adj2.substring(2);

        System.out.println(adj2);

    }
}
