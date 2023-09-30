import java.util.*;
import java.io.*;
public class DictionaryManagement {
    private Dictionary dictionary;
    
    private Scanner sc;

    // constructors
    public DictionaryManagement() {
        this.dictionary = new Dictionary();
        sc = new Scanner(System.in);
    }
    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
        sc = new Scanner(System.in);
    }

    //------------------METHOD-----------------
    // check valid word
    public boolean validWord(String s) {
        for(int i = 0; i < s.length(); i++)
        {
            if (!Character.isLetter(s.charAt(i))) {
                System.out.println("An English word can only have alphabet character!!!");
                return false;
            }
        }
        return !s.isEmpty();
    }
    // look up method
    public void Lookup() {
        System.out.println("Enter the word you want to lookup:");

        String w_target = sc.nextLine();
        while(!validWord(w_target))
        {
            if (!w_target.isEmpty()) {
                System.out.println("Please enter again!!!");
            }
            w_target = sc.nextLine();
        }

        Word foundWord = this.dictionary.findWord(w_target);
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
    }

    //insert method
    public void insertFromCommandline() {
        
        int n = -1;
        System.out.println("Enter number of words :");
        while (n < 0)
        {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n < 0) {
                    System.out.println("Sorry. You must enter a natural number !!!");
                    System.out.println("Please enter again!!!");
                }
            } catch (NumberFormatException e) {
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
                    System.out.println("Please enter again!!!");
                }
                English = sc.nextLine();
            }
            w.setWordTarget(English);
            boolean endOfExplain = false;
            String explain;
            System.out.println("Give us the meaning of English word, press ENTER to save it.\n" +
                    "Enter # to end the process.");
            int cnt = 1;
            do {
                System.out.print(cnt + ". ");
                explain = sc.nextLine();
                if (explain.equals("#")) endOfExplain = true;
                else if (!explain.isEmpty()) {
                    w.getWord_explain().add(explain);
                    cnt++;
                }
            } while(!endOfExplain);
            this.dictionary.insertWord(w);
        }
    }

    public boolean insertFromFile() {
        try {
            FileReader fr = new FileReader("data/dictionary.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");

                if (parts.length >= 1) {
                    String w_target = parts[0];
                    ArrayList<String> w_explain = new ArrayList<>();
                    Word temp = new Word();
                    temp.setWordTarget(w_target);

                    if (parts.length > 1) {
                        for (int i = 1; i < parts.length; i++) {
                            w_explain.add(parts[i]);
                        }
                        temp.setWordExplain(w_explain);
                    }

                    if (validWord(w_target)) {
                        this.dictionary.insertWord(temp);
                    } else {
                        System.out.println("Error!!! " + w_target + " is not an English word!!!. Can't import this word to the dictionary.");
                        System.out.println();
                    }
                }
            }

            fr.close();
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("Import failed!!!");
            System.out.println("Sorry. An error occurred while importing data.");
            return false;
        }
    }


    public boolean dictionaryExportToFile(){
        try {
            FileWriter fw = new FileWriter("data/exported_dictionary.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (Word w : this.dictionary.getDict()) {
                bw.write(w.getWord_target() + "\t");

                ArrayList<String> w_explain = w.getWord_explain();
                for (String meaning : w_explain) {
                    bw.write(meaning + "\t");
                }

                bw.write("\n");
            }

            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println("Export failed!!!");
            System.out.println("Sorry. An error occurred while exporting data.");
            return false;
        }
    }

    /*
    deleteWords

    editWord

     */
}