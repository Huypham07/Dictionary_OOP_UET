import java.io.IOException;
import java.util.*;

public class DictionaryCommandline {
    private Dictionary dictionary;
    private DictionaryManagement dict_manager;
    private Scanner sc;


    // Constructor
    public DictionaryCommandline() {
        dictionary = new Dictionary();
        dict_manager = new DictionaryManagement(dictionary);
        sc = new Scanner(System.in);
    }

    // METHODS

    //clr screen
    private static void cls() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void showAllWords() {
        ArrayList<Word> allWords = new ArrayList<>(dictionary.getDict());

        // check if dictionary is empty
        if (allWords.isEmpty()) {
            System.out.println("Dictionary is empty.");
            return;
        }

        // Exception handling
        try {
            // Sort option
            String userOption = getUserSortOption();

            if(userOption.equals("YES")) {
                // Order option
                boolean sortOrder = getUserSortOrder();
                sortWords(allWords, Comparator.comparing(Word::getWord_target), sortOrder);
                System.out.println("Word list was sorted by " + (sortOrder ? "Ascending order" : "Descending order"));
            } else if (userOption.equals("NO")) {
                System.out.println("Word list will be shown on default order");
            } else {
                System.out.println("Invalid option. Word list will be shown on default order");
            }

            // Page setting

            int pageSize = getUsertPageSize(); // Number of word per page
            int totalPages = (int)Math.ceil((double) allWords.size() / pageSize);

            for(int page = 1; page <= totalPages; page++){
                System.out.println("Page " + page);
                displayHeader();
                for(int i = (page - 1) * pageSize; i < Math.min(page * pageSize, allWords.size()); i++){
                    Word word = allWords.get(i);
                    displayWord(word, i + 1);
                }
                if(page < totalPages){
                    System.out.println("Press Enter to continue to the next page....");
                    sc.nextLine();
                }

            }

        } catch (InputMismatchException e){
            System.out.println("Invalid sc. Please enter a valid option");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String getUserSortOption() {
        System.out.println("Do you want to sort word list by English?\n Enter YES or NO: ");
        return sc.nextLine().toUpperCase();
    }

    private boolean getUserSortOrder(){
        System.out.println("You want to sort word list by Ascending (ASC) or Descending (DES)?");
        String order = sc.nextLine().toUpperCase();
        return order.equals("ASC");
    }

    private int getUsertPageSize() {
        System.out.println("Enter number of word per page: ");
        int pageSize = sc.nextInt();
        sc.nextLine();
        return pageSize;
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
        System.out.println("-------------------------------");
    }

    private void displayWord(Word word, int index){
        System.out.printf("%-3s| %-15s |", index, word.getWord_target());

        ArrayList<String> explainWord = word.getWord_explain();
        for(String meaning : explainWord){
            System.out.printf(" %-20s", meaning);
        }

        System.out.println();
    }

    public boolean dictionaryAdvanced() throws IOException, Exception{
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

        int select;

        // Exception handling
        try {
            System.out.print("Select a number between 0 and 9: ");
            select = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Oops...!Action not supported.");
            System.out.println("Please Select again!");
            return true;
        }

        switch (select) {
            case 0: return false;

            case 1: {
                cls();
                dict_manager.insertFromCommandline();
            }
            break;


            case 4: {
                cls();
                showAllWords();
            }
            break;

            case 5: {
                cls();
                dict_manager.Lookup();
            }
            break;

            case 8: return dict_manager.insertFromFile();

            default:
            {
                System.out.println("Please Select again!");
                return true;
            }
        }

        System.out.print("Press ENTER to back to Menu");
        sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
        return true;
    }
    /*
    dictionaryBasic

    dictionaryAdvanced

    dictionarySearcher

     */
}