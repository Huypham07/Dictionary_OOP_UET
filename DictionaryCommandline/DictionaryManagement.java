import java.util.*;
import java.io.IOException;

public class DictionaryManagement {
    private Dictionary dictionary;

    // constructors
    public DictionaryManagement() {
    }

    //------------------METHOD-----------------

    // look up method
    public void Lookup() {
        System.out.println("Enter the word you want to lookup:");
        Scanner input  = new Scanner(System.in);
        String w_target = input.next();

        Word foundWord = dictionary.findWord(w_target);
        if (foundWord == null) {
            System.out.println("Sorry, We did not find your word in our Dictionary!");
        } else {
            ArrayList<String> ans = foundWord.getWord_explain();
            String add = (ans.size() > 1) ? "s" : "";
            System.out.println("We found " + ans.size() + " result" + add);

            for (String i : ans) {
                System.out.println(i);
            }
        }
    }
    /*
    insertFromCommandline

    insertFromFile

    dictionaryLookup

    deleteWords

    editWord

    dictionaryExportToFile


     */
}