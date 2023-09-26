import java.util.*;

public class DictionaryManagement {
    private Dictionary dictionary;

    // constructors
    public DictionaryManagement() {
        dictionary = new Dictionary();
    }
    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    //------------------METHOD-----------------

    // look up method
    public void Lookup() {
        System.out.println("Enter the word you want to lookup:");
        Scanner input = new Scanner(System.in);
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

    //insert method
    public void insertFromCommandline() {
        Word w = new Word();
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter English word: ");
        w.setWordTarget(input.nextLine());
        boolean endOfExplain = false;
        String explain = new String("");
        System.out.println("Give us the meaning of English word, press ENTER to save it.\n" +
                           "Enter # to end the process.");
        int i = 1;
        do {
            System.out.print(i + ". ");
            explain = input.nextLine();
            if (explain.equals("#")) endOfExplain = true;
            else w.getWord_explain().add(explain);
            i++;
        } while(!endOfExplain);
        dictionary.insertWord(w);
    }

    public void insertFromFile() {

    }

/*
    dictionaryLookup

    deleteWords

    editWord

    dictionaryExportToFile

     */
}