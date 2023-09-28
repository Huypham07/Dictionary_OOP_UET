import java.util.*;
import java.io.*;
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
    // check valid word
    public boolean validWord(String s)
    {
        if (s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++)
        {
            if (!Character.isLetter(s.charAt(i))) {
                System.out.println("An English word can only have alphabet character!!!");
                return false;
            }
        }
        return true;
    }
    // look up method
    public void Lookup() {
        System.out.println("Enter the word you want to lookup:");
        Scanner sc = new Scanner(System.in);
        String w_target = sc.next();

        Word foundWord = dictionary.findWord(w_target);
        if (foundWord == null) {
            System.out.println("Sorry, We did not find your word in our Dictionary!");
        } else {
            ArrayList<String> ans = foundWord.getWord_explain();
            String add = (ans.size() > 1) ? "s" : "";
            System.out.println("We found " + ans.size() + " result" + add);

            for (String i : ans) {
                System.out.println("- " + i);
            }
        }
        sc.close();
    }

    //insert method
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        System.out.println("Enter number of words :");
        while (n < 0)
        {
            try
            {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e)
            {
                continue;
            }
            if (n < 0)
            {
                System.out.println("Sorry. You must enter a natural number !!!");
                System.out.println("Please sc again!!!");
            }
        }

        System.out.println();

        Word w = new Word();

        for (int i = 1; i <= n; i++) {

            System.out.print("Please enter English word: ");
            String English = sc.nextLine();
            while(!validWord(English))
            {
                if (!English.isEmpty()) {
                    System.out.println("Please sc again!!!");
                    English = sc.nextLine();
                }
            }
            w.setWordTarget(English);
            boolean endOfExplain = false;
            String explain;
            System.out.println("Give us the meaning of English word, press ENTER to save it.\n" +
                    "Enter # to end the process.");
            int cnt = 1;
            sc = new Scanner(System.in);
            do {
                System.out.print(cnt + ". ");
                explain = sc.nextLine();
                if (explain.equals("#")) endOfExplain = true;
                else if (!explain.isEmpty()) {
                    w.getWord_explain().add(explain);
                    cnt++;
                }
            } while(!endOfExplain);
            dictionary.insertWord(w);
        }
        sc.close();
    }

    public boolean insertFromFile() throws IOException, FileNotFoundException {
        try
        {
            FileReader fr = new FileReader("dictionary.txt");
            Scanner sc = new Scanner(fr);

            String lineWord = sc.nextLine();
            String[] parts = lineWord.split("\\t");
            if (parts.length == 2) {
                if (!validWord(parts[0]))
                {
                    System.out.println("Error!!! " + parts[0] + " is not a English word!!!. Can't import this word to dictionary.");
                    System.out.println();
                }
                else {
                    Word temp = new Word();
                    temp.setWordTarget(parts[0]);
                    temp.getWord_explain().add(parts[1]);
                }
            }

            fr.close();
            sc.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Import failed!!!");
            System.out.println("Sorry. We can't find 'dictionary.txt' file to inport data.");
            System.out.println("Please make sure that you have 'dictionary.txt' file in this folder and import again!!!");
            return false;
        }
    }

/*
    dictionaryLookup

    deleteWords

    editWord

    dictionaryExportToFile

     */
}