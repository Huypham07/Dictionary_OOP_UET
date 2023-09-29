import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;

public class Dictionary {
  private Map<String , String > data = new HashMap<String, String>(); 
    public String addWord(String word, String meaning){
        return this.data.put(word, meaning);
    }
    public String delete(String word){
        return this.data.remove(word);
    }
    public void editMeaning(String word, String newMeaning){
        this.data.replace(word, newMeaning);
    }
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        int num = 0;
        Scanner sc = new Scanner(System.in);
        do { 
          System.out.println("------------");
          System.out.println("MENU");
          System.out.println("E-V Dictionary \n"+"1.Delete word \n" + "2.Edit word \n" + "0.Exit \n" );
          num=sc.nextInt(); sc.nextLine();
          if(num == 1){
                    System.out.println("Enter the word : ");
                    String word = sc.nextLine();
                    dictionary.delete(word);
          }else if(num == 2 ) {
                    System.out.println("Enter the wrong word: ");
                    String word = sc.nextLine();
                    System.out.println("3.Fix the word \n" + "4.Fix the meaning \n");
                    int number = 0;
                    number = sc.nextInt();
                    sc.nextLine();
                    if(number == 3) {
                        dictionary.delete(word);
                        System.out.println("Re-enter word: ");
                        String newWord = sc.nextLine();
                        System.out.println("Re-enter meaning: ");
                        String meaning = sc.nextLine();
                        dictionary.addWord(newWord, meaning);
                    }else {
                        System.out.println("Enter the correct meaning: ");
                        String newMeaning = sc.nextLine();
                        dictionary.editMeaning(word, newMeaning);
                        }
            }
        }while(num != 0);
    }
}
