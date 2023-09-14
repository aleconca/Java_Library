package Variables;

public class ClassString {

    //metodi della classe String per stringhe:
    //toUpperCase(), toLowerCase()
    //indexOf("TGA) ritoena inizio sequenza
    //charAt(4) indica il carattere
    //subString(0,3) printa sottostringa, ricorda di fare +1
    

        public static void main(String[] args) {

            //  -. .-.   .-. .-.   .
            //    \   \ /   \   \ /
            //   / \   \   / \   \
            //  ~   `-~ `-`   `-~ `-

            //finds out sequences starting with ATG and ending with TGA which length is divisible by 3

            String dna1 = "ATGCGATACGCTTGA";
            String dna2 = "ATGCGATACGTGA";
            String dna3 = "ATTAATATGTACTGA";

            String dna = dna3;

            int length=  dna.length();

            System.out.println("dna length:" + length);

            int start = dna.indexOf("ATG");

            System.out.println("starts with:" + start);

            int end = dna.indexOf("TGA");

            System.out.println("index of TGA:"+ end );

            if(start!=-1 && end != -1 && (end-start)%3==0){
                System.out.println("Start and end exist :)");
                System.out.println("dna length is divisible by 3.");
                String protein = dna.substring(start,end+3); //perche
                //quando cerco TGA mi restituisce un numero che     corrisponede alla prima lettera della sequenza
                System.out.println("The found protein is :"+ protein);

            }else{
                System.out.println("No protein");
            }



        }


}
