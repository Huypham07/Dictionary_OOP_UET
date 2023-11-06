package Dict;

import Dict.Dictionary;
import Dict.Word;
import ControlServices.*;

import java.util.*;
import java.io.*;
public class DictionaryManagement {

    private Dict.Dictionary dictionary;
    protected Scanner sc;

    // constructors
    public DictionaryManagement() {
        this.sc = new Scanner(System.in);
        this.dictionary = new Dict.Dictionary();
    }

    //------------------METHOD-----------------
    public Dictionary getDictionary() {
        return this.dictionary;
    }
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

        String w_target = this.sc.nextLine();
        while(!validWord(w_target))
        {
            if (!w_target.isEmpty()) {
                System.out.println("Please enter again!!!");
            }
            w_target = this.sc.nextLine();
        }

        Word foundWord = this.dictionary.findWord(w_target);
        if (foundWord == null) {
            System.out.println("Sorry, We did not find your word in our Dict.Dictionary!");
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
                n = Integer.parseInt(this.sc.nextLine());
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

        for (int i = 1; i <= n; i++) {

            Word w = new Word();
            System.out.print("Please enter English word: ");
            String English = this.sc.nextLine();
            while(!validWord(English))
            {
                if (!English.isEmpty()) {
                    System.out.println("Please enter again!!!");
                }
                English = this.sc.nextLine();
            }
            w.setWordTarget(English);
            boolean endOfExplain = false;
            String explain;
            System.out.println("Give us the meaning of English word, press ENTER to save it.\n" +
                    "Enter # to end the process.");
            int cnt = 1;
            do {
                System.out.print(cnt + ". ");
                explain = this.sc.nextLine();
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

            System.out.println("Import successful !!");
            System.out.println("The dictionary have " + this.dictionary.getDict().size() + " words");
            fr.close();
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("Import failed!!!");
            System.out.println("Sorry. An error occurred while importing data.");
            return false;
        }
    }

    //export to file
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

            System.out.println("Export successful !!");
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println("Export failed!!!");
            System.out.println("Sorry. An error occurred while exporting data.");
            return false;
        }
    }

    // edit method
    public void updateWord() {
        System.out.print("Enter the English Dict.Word you want to update: ");
        String oldEnglishWord = this.sc.nextLine();

        while(!validWord(oldEnglishWord))
        {
            if (!oldEnglishWord.isEmpty()) {
                System.out.println("Please enter again!!!");
            }
            oldEnglishWord = this.sc.nextLine();
        }

        Word w = this.dictionary.findWord(oldEnglishWord);
        if (w == null) {
            System.out.println("We didn't find the word " + oldEnglishWord);
        } else {
            System.out.println("We found:\n");
            System.out.printf("%-15s |", w.getWord_target());

            for(String meaning : w.getWord_explain()){
                System.out.printf(" %-20s", meaning);
            }
            System.out.println("\n");
            System.out.println("Enter '1' to edit the English word\nEnter '2' to add the meaning\nEnter other number to reset the meaning");

            int select = 0;
            boolean chooseNumber;
            do {
                // Exception handling
                try {
                    select = Integer.parseInt(this.sc.nextLine());
                    chooseNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("Oops...!Action not supported.");
                    System.out.println("Please Select again!");
                    chooseNumber = false;
                }
            } while (!chooseNumber);

            if (select == 1) {
                System.out.println("Give us the new English word");
                String newEnglishWord = this.sc.nextLine();
                w.setWordTarget(newEnglishWord);

                this.dictionary.getTrieOfTargetWord().remove(oldEnglishWord);
                this.dictionary.insertWord(w);
            } if (select == 2){
                System.out.println("Give us the new meaning of English word");
                String newMeaning = this.sc.nextLine();
                w.addExplain(newMeaning);
            } else {
                ArrayList<String> newMeaning = new ArrayList<>();
                boolean endOfExplain = false;
                String explain;
                System.out.println("Give us the meaning of English word, press ENTER to save it.\n" +
                        "Enter # to end the process.");
                int cnt = 1;
                do {
                    System.out.print(cnt + ". ");
                    explain = this.sc.nextLine();
                    if (explain.equals("#")) endOfExplain = true;
                    else if (!explain.isEmpty()) {
                        newMeaning.add(explain);
                        cnt++;
                    }
                } while(!endOfExplain);
                w.setWordExplain(newMeaning);
            }
            System.out.println("Successful");
        }
    }

    //remove method
    public void removeWord() {
        System.out.println("Enter the English word : ");
        String English = this.sc.nextLine();
        while(!validWord(English))
        {
            if (!English.isEmpty()) {
                System.out.println("Please enter again!!!");
            }
            English = this.sc.nextLine();
        }

        if (this.dictionary.deleteWord(English)) {
            System.out.println("Successful");
            System.out.println("The word " + English + " has been removed!");
        } else {
            System.out.println("Can't remove this word !! You can try again. Thanks!");
        }
    }

    // search with prefix
    public void searcher() {
        System.out.print("You want to find words beginning with: ");
        String prefix = this.sc.nextLine();
        while(!validWord(prefix))
        {
            if (!prefix.isEmpty()) {
                System.out.println("Please enter again!!!");
            }
            prefix = this.sc.nextLine();
        }
        ArrayList<String> result = this.dictionary.getTrieOfTargetWord().findWordsWithPrefix(prefix);

        System.out.println("We found " + result.size() + " words beginning with " + prefix + ": ");

        if (result.size() <= 0) return;// not found

        System.out.println("Do you want to print the meaning of these words? YES or NO");

        String ans = this.sc.nextLine();

        if (ans.toLowerCase().equals("yes")) {
            System.out.println(result.size() + " results are:");
            for (int i = 1; i <= result.size(); i++) {
                Word w = this.dictionary.findWord(result.get(i-1));
                System.out.printf("%-3s| %-15s |", i, w.getWord_target());

                for(String meaning : w.getWord_explain()){
                    System.out.printf(" %-20s", meaning);
                }
                System.out.println();
            }
        } else {
            System.out.println(result.size() + " Words are:");

            for (int i = 1; i <= result.size(); i++) {
                System.out.println(i + ". " + result.get(i-1));
            }
        }
    }
    // review vocabulary
    public void VocabularyReview() {
        Scanner scanner = new Scanner(System.in);
        VocabularyList vocabularyList = new VocabularyList();

        System.out.println("Choose a vocabulary topic to review:");
        System.out.println("1. Foods");
        System.out.println("2. Jobs");
        System.out.println("3. Animals");
        System.out.println("4. Transportations");
        System.out.println("5. Holidays");
        System.out.println("6. Family");
        System.out.println("7. School");
        System.out.println("8. Sport");
        System.out.println("9. Weather");
        System.out.println("10. Entertainment");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự xuống dòng sau lựa chọn
    
        String topic;
        switch (choice) {
            case 1:
                topic = "Foods";
                break;
            case 2:
                topic = "Jobs";
                break;
            case 3:
                topic = "Animals";
                break;
            case 4:
                topic = "Transportations";
                break;
            case 5:
                topic = "Holidays";
                break;
            case 6:
                topic = "Family";
                break;
            case 7:
                topic = "School";
                break;
            case 8:
                topic = "Sport";
                break;
            case 9:
                topic = "Weather";
                break;
            case 10:
                topic = "Entertainment";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Choose review mode:");
        System.out.println("1. Quick Review (10 words)");
        System.out.println("2. Review (30 words)");

        int reviewMode = scanner.nextInt();
        scanner.nextLine();

        if (reviewMode == 1) {
            vocabularyList.loadVocabulary("data/WordsBySubject.txt", topic);
            vocabularyList.review(10);
        } else if (reviewMode == 2) {
            vocabularyList.loadVocabulary("data/WordsBySubject.txt", topic);
            vocabularyList.review(30);
        } else {
            System.out.println("Invalid review mode.");
        }
    }
}
