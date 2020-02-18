/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.URLResource;

public class Part4 {
    
    void searchYoutubeLinks() {
        URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String string: urlResource.lines()) {
            int indexOfYoutubeWord = string.indexOf("youtube.com");
            if (indexOfYoutubeWord != -1) {
                int indexOfQuote1 = string.lastIndexOf("\"", indexOfYoutubeWord);
                int indexOfQuote2 = string.indexOf("\"", indexOfYoutubeWord);
                System.out.println(string.substring(indexOfQuote1+1, indexOfQuote2));
            }
        }
    }
    
    public static void main(String[] args) {
        Part4 part4 = new Part4();
        part4.searchYoutubeLinks();
    }
}
