package Dict;

import java.util.*;
import java.io.*;
import manageData.Datatype.Word;
import manageData.TrieTree.Trie;

public class DictionaryManagement {

    private Dictionary dictionary;
    private Trie TrieOfDict;

    // constructors
    public DictionaryManagement() {}
    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
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
            if (!Character.isLetter(s.charAt(i))) {
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
}