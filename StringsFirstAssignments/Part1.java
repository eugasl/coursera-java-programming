
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part1 {
    String findSimpleGene(String dna) {
        int atgIndexPosition = dna.indexOf("ATG");
        if (atgIndexPosition == -1) {
            return "";
        }
        
        int taaIndexPosition = dna.indexOf("TAA", atgIndexPosition + 3);
        if (taaIndexPosition == -1) {
            return "";
        }
        
        String stringBetween = dna.substring(atgIndexPosition + 3, 
                                             taaIndexPosition);
        if (stringBetween.length() % 3 == 0) {
            return dna.substring(atgIndexPosition, taaIndexPosition + 3);
        }
        return "";
    }
    
    void testSimpleGene() {
        //String test1 = "dsfasdfadsfdf";
        //String test2 = "dfaATGfdssadfadsfadf";
        //String test3 = "fasdTAAfasdfadATGsf";
        //String test4 = "dfdfdfATG123TAAasdfafd";
        //String test5 = "dfdfdfATG1234TAAasdfafd";
        //System.out.println(findSimpleGene(test1));
        //System.out.println(findSimpleGene(test2));
        //System.out.println(findSimpleGene(test3));
        //System.out.println(findSimpleGene(test4));
        //System.out.println(findSimpleGene(test5));
        System.out.println(findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC"));
    }
    
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testSimpleGene();
    }
}
