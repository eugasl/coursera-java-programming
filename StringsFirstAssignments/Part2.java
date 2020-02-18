
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String testDna = dna.toUpperCase();
        int atgIndexPosition = testDna.indexOf("ATG");
        if (atgIndexPosition == -1) {
            return "";
        }
        
        int taaIndexPosition = testDna.indexOf("TAA", atgIndexPosition + 3);
        if (taaIndexPosition == -1) {
            return "";
        }
        
        String stringBetween = testDna.substring(atgIndexPosition + 3, 
                                                 taaIndexPosition);
        if (stringBetween.length() % 3 == 0) {
            return dna.substring(atgIndexPosition, taaIndexPosition + 3);
        }
        return "";
    }
    
    void testSimpleGene() {
        String test1 = "ATGGGTTAAGTC";
        String test2 = "gatgctataat";
        System.out.println(findSimpleGene(test1, "", ""));
        System.out.println(findSimpleGene(test2, "", ""));
    }
    
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testSimpleGene();
    }
}
