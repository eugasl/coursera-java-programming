
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences(String stringa, String stringb) {
        int firstIndexOfStringa = stringb.indexOf(stringa);
        int indexOfSecondStringa = stringb.indexOf(
            stringa, 
            stringb.indexOf(stringa) + stringa.length());
        return indexOfSecondStringa != -1;
    }
    
    String lastPart(String stringa, String stringb) {
        int indexOfStringA = stringb.indexOf(stringa);
        if (indexOfStringA == -1) {
            return stringb;
        }
        return stringb.substring(indexOfStringA + stringa.length());
    }
    
    void testTwoOccurrences() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
    }
    
    void testLastPart() {
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest"));
    }
    
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        //part3.testTwoOccurrences();
        part3.testLastPart();
    }
}
