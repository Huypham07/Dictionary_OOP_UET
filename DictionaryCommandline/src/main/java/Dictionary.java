
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

    public void insertWord(Word w) {
        int check = TrieOfTargetWord.search(w.getWord_target());
        if(check == -1) {
            Dict.add(w);
            TrieOfTargetWord.insert(w.getWord_target(), Dict.size()-1);
        } else {
            ArrayList<String> tmp = w.getWord_explain();
            ArrayList<String> wordExist = Dict.get(check).getWord_explain();
            for (int i = 0; i < tmp.size(); i++){
                boolean existExplain = false;
                for (int j = 0; j < wordExist.size(); j++) {
                    if (tmp.get(i).equals(wordExist.get(j))) {
                        existExplain = true;
                        break;
                    }
                }
                if (!existExplain) {
                    wordExist.add(tmp.get(i));
                }
            }
        }
    }
    /*
    suggest:
    edit_word

    delete_word

     */
}
