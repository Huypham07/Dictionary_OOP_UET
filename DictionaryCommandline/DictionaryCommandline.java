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

    public void showAllWords() {
        ArrayList<Word> allWords = dictionary.getDict();

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
            System.out.println("Invalid input. Please enter a valid option");
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

    /*
    dictionaryBasic

    dictionaryAdvanced

    dictionarySearcher

     */
}