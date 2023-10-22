package Dict;

import java.io.*;
import java.util.*;
import manageData.Datatype.Word;

public class DictionaryCommandline extends DictionaryManagement{
    private Scanner sc;
    // Constructor
    public DictionaryCommandline() {
        sc = new Scanner(System.in);
    }

    //------------------METHOD-----------------

    //clr screen
    private static void cls() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    // Show ALl
    public void showAllWords() {
        ArrayList<Word> allWords = new ArrayList<>(this.getDictionary().getDict());
        // check if dictionary is empty
        if (allWords.isEmpty()) {
            System.out.println("Dictionary is empty.\nPlease add new words first!");
            return;
        }

        // Exception handling
        try {
            // Sort option
            String userOption;

            do{
                userOption = getUserSortOption();
                if(userOption.equals("YES")) {
                    // Order option
                    System.out.print("You want to sort word list by Ascending (ASC) or Descending (DES)? ");
                    boolean sortOrder = getUserSortOrder();
                    sortWords(allWords, Comparator.comparing(Word::getWord_target), sortOrder);
                    System.out.println("Word list was sorted by " + (sortOrder ? "Ascending order" : "Descending order"));
                } else if (userOption.equals("NO")) {
                    System.out.println("Word list will be shown on default order");
                } else {
                    System.out.println("Invalid option!");
                }
            } while(!userOption.equals("YES") && !userOption.equals("NO"));

            // Page setting

            int pageSize = getUsertPageSize(); // Number of word per page
            int totalPages = (int)Math.ceil((double) allWords.size() / pageSize);

            for (int page = 1; page <= totalPages; page++) {
                System.out.println("Page " + page);
                displayHeader();
                for(int i = (page - 1) * pageSize; i < Math.min(page * pageSize, allWords.size()); i++){
                    Word word = allWords.get(i);
                    displayWord(word, i + 1);
                }
                if(page < totalPages){
                    System.out.print("Press Enter to continue to the next page....");
                    this.sc.nextLine();
                }

            }

        } catch (InputMismatchException e){
            System.out.println("Invalid sc. Please enter a valid option");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String getUserSortOption() {
        System.out.print("Do you want to sort word list? Please enter YES or NO: ");
        return this.sc.nextLine().toUpperCase();
    }

    private boolean getUserSortOrder(){
        try{
            String userOption = this.sc.nextLine().toUpperCase();
            if(userOption.equals("ASC")){
                return true;
            } else if(userOption.equals("DES")){
                return false;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e){
            System.out.print("Invalid option!\nPlease enter ASC or DES: ");
            return getUserSortOrder();
        }
    }

    private int getUsertPageSize() {
        int userInput = 0; // Number of word per page
        boolean isValidInput = false;
        System.out.print("Enter number of word per page: ");
        while(!isValidInput){
            try{
                userInput = Integer.parseInt(this.sc.nextLine());
                if(userInput <= 0){
                    System.out.print("Invalid input!\nPlease enter a positive number: ");
                } else {
                    isValidInput = true;
                }
            } catch (NumberFormatException e){
                System.out.print("Invalid input!\nPlease enter a positive number: ");
            }
        }
        return userInput;
    }

    private void sortWords(ArrayList<Word> words, Comparator<Word> comparator, boolean ascending){
        if(ascending){
            Collections.sort(words, comparator);
        } else {
            Collections.sort(words, comparator.reversed());
        }
    }

    private void displayHeader(){
        System.out.println("No | English         | Vietnamese");
        System.out.println("-----------------------------------");
    }

    private void displayWord(Word word, int index){
        System.out.printf("%-3s| %-15s |", index, word.getWord_target());

        ArrayList<String> explainWord = word.getWord_explain();
        for(String meaning : explainWord){
            System.out.printf(" %-20s", meaning);
        }

        System.out.println();
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

        Word foundWord = this.findWord(w_target);
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
            this.insertWord(w);
        }
    }

    // edit method
    public void updateWord() {
        System.out.print("Enter the English Word you want to update: ");
        String oldEnglishWord = this.sc.nextLine();

        while(!validWord(oldEnglishWord))
        {
            if (!oldEnglishWord.isEmpty()) {
                System.out.println("Please enter again!!!");
            }
            oldEnglishWord = this.sc.nextLine();
        }

        Word w = this.findWord(oldEnglishWord);
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

                this.deleteWord(oldEnglishWord);//
                this.insertWord(w);
            } else if (select == 2){
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

        if (this.deleteWord(English)) {
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
        ArrayList<String> result = this.findWordsWithPrefix(prefix);

        System.out.println("We found " + result.size() + " words beginning with " + prefix + ": ");

        if (result.isEmpty()) return;// not found

        System.out.println("Do you want to print the meaning of these words? YES or NO");

        String ans = this.sc.nextLine();

        if (ans.equalsIgnoreCase("yes")) {
            System.out.println(result.size() + " results are:");
            for (int i = 1; i <= result.size(); i++) {
                Word w = this.findWord(result.get(i-1));
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

    // Game mod
    public void GameMode() {
        System.out.println("Sorry");
    }

    // advanced
    public boolean dictionaryAdvanced() throws Exception{
        cls();
        System.out.println("Welcome to My Application!");
        System.out.println( "   [0] Exit\n" +
                "   [1] Add\n" +
                "   [2] Remove\n" +
                "   [3] Update\n" +
                "   [4] Display\n" +
                "   [5] Lookup\n" +
                "   [6] Search\n" +
                "   [7] Game\n" +
                "   [8] Import from file\n" +
                "   [9] Export to file");
        sc = new Scanner(System.in);

        int select = 0;
        boolean chooseNumber;
        do {
            // Exception handling
            try {
                System.out.print("Select a number between 0 and 9: ");
                select = Integer.parseInt(this.sc.nextLine());
                chooseNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Oops...!Action not supported.");
                System.out.println("Please Select again!");
                chooseNumber = false;
            }
        } while (!chooseNumber);

        switch (select) {
            case 0: {
                System.out.println("  --- Bye !!! ---");
                return false;
            }

            case 1: {
                cls();
                this.insertFromCommandline();
            } break;

            case 2: {
                cls();
                this.removeWord();
            } break;

            case 3: {
                cls();
                this.updateWord();
            } break;

            case 4: {
                cls();
                showAllWords();
            } break;

            case 5: {
                cls();
                this.Lookup();
            } break;

            case 6: {
                cls();
                this.searcher();
            } break;

            case 7: {
                cls();
                this.GameMode();
            } break;

            case 8: {
                cls();
                this.insertFromFile();
            } break;

            case 9: {
                cls();
                this.dictionaryExportToFile();
            } break;

            default:
            {
                System.out.println("Please Select again!");
                return true;
            }
        }

        System.out.println();
        System.out.print("Press ENTER to back to Menu");
        this.sc.nextLine();
        return true;
    }

}