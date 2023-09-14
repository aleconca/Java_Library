package Variables;

public class Strings {
    public static void main(String[] args){
        String dna1 = "ATGCGATACGCTTGA";
        String dna2 = "ATGCGATACGTGA";
        String dna3 = "ATTAATATGTACTGA";

        String dna = dna3;

        int length = dna.length();

        System.out.println("dna length:"+length);

        int start = dna.indexOf("ATG");

        System.out.println("starts with:"+start);

        int end = dna.indexOf("TGA");

        System.out.println("ends with:"+end);

        if(start != -1 && end != -1 && (end-start)%3==0){
            System.out.println("Start and end exist:");

            System.out.println("dna length is divisible by 3.");

            String protein = dna.substring(start, end+3);

            System.out.println(start);
            System.out.println(end);

            System.out.println("The found protein is "+ protein);
        }else{
            System.out.println("No protein");
        }
        System.out.println(dna.toString());

        char[] chars= dna.toCharArray();

        for (int i=0; i< chars.length; i++){
            System.out.println(chars[i]);
        }

    }
}
