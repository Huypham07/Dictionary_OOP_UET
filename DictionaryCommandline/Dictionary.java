import java.util.*;
public class Dictionary {
    private ArrayList<Word> Dict;

    private Trie TrieOfTargetWord;
    // Constructors
    public Dictionary() {
        Dict = new ArrayList<Word>();
        TrieOfTargetWord = new Trie();

        for (int i = 0; i < Dict.size(); i++) {
            TrieOfTargetWord.insert(Dict.get(i).getWord_target(), i);
        }
    }

    // getter
    public ArrayList<Word> getDict() {
        return this.Dict;
    }

    //-------------METHOD-------------

    public Word findWord(String w_target) {
        int id = TrieOfTargetWord.search(w_target);
        return (id >= 0) ? Dict.get(id) : null;
    }
    /*
    suggest:
    insertWord

    edit_word

    delete_word

     */
}
