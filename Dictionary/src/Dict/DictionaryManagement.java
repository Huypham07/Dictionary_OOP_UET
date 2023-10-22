package Dict;

import java.util.*;
import java.io.*;
import manageData.Datatype.Word;
import manageData.TrieTree.Trie;

public class DictionaryManagement {

    private Dictionary dictionary;
    private Trie TrieOfDict;

    // constructors
    public DictionaryManagement() {
        this.dictionary = new Dictionary();
        TrieOfDict = this.dictionary.getTrieOfTargetWord();
    }

    // getter
    public Dictionary getDictionary() {
        return this.dictionary;
    }
    public Trie getTrieOfDict() {
        return this.TrieOfDict;
    }

    //------------------METHOD-----------------

    // check valid word
    public boolean validWord(String s) {
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                System.out.println("An English word can only have alphabet character!!!");
                return false;
            }
        }
        return !s.isEmpty();
    }

    // Find a word
    public Word findWord(String w_target) {
        int id = this.TrieOfDict.search(w_target);
        return (id >= 0) ? this.dictionary.getDict().get(id) : null;
    }

    // Insert a word
    public void insertWord(Word w) {
        int check = this.TrieOfDict.search(w.getWord_target());

        if(check == -1) {
            this.dictionary.getDict().add(w);
            this.TrieOfDict.insert(w.getWord_target(), this.dictionary.getDict().size()-1);
        } else {
            ArrayList<String> tmp = w.getWord_explain();
            ArrayList<String> wordExist = this.dictionary.getDict().get(check).getWord_explain();

            for (String s : tmp) {
                boolean existExplain = false;

                for (String string : wordExist) {
                    if (s.equals(string)) {
                        existExplain = true;
                        break;
                    }
                }

                if (!existExplain) {
                    wordExist.add(s);
                }
            }
        }
    }

    // edit method
    public void editWord(String old_EnglishWord, Word new_word) {
        this.deleteWord(old_EnglishWord);
        this.insertWord(new_word);
    }

    //delete method
    public boolean deleteWord(String key) {
        int id = this.TrieOfDict.search(key);
        if (id < 0) return false;
        this.dictionary.getDict().remove(id);
        return this.TrieOfDict.remove(key);
    }
    
    //search prefix
    public ArrayList<String> findWordsWithPrefix(String key) {
        return this.TrieOfDict.findWordsWithPrefix(key);
    }
    
    //insert from file
    public boolean insertFromFile() {
        try {
            FileReader fr = new FileReader("src/data/dictionary.txt");
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
                        for (int i = 1; i < parts.length-1; i++) {
                            w_explain.add(parts[i]);
                        }
                        temp.setWordExplain(w_explain);
                        
                        temp.setWordType(parts[parts.length-1]);
                    }

                    if (validWord(w_target)) {
                        this.insertWord(temp);
                    } else {
                        System.out.println("Error!!! " + w_target + " is not an English word!!!. Can't import this word to the dictionary.");
                        System.out.println();
                    }
                }
            }

            System.out.println("Import successful !!");
            System.out.println("The dictionary have " + this.getDictionary().getDict().size() + " words");
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
            FileWriter fw = new FileWriter("src/data/exported_dictionary.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (Word w : this.getDictionary().getDict()) {
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
    public static void main(String[] args) {
        DictionaryManagement dc = new DictionaryManagement();
        System.out.println(dc.validWord("ư"));
    }
}