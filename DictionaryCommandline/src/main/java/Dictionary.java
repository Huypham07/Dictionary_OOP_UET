import java.util.*;

public class Dictionary {
    private ArrayList<Word> Dict;

    private Trie TrieOfTargetWord;
    // Constructors
    public Dictionary() {
        this.Dict = new ArrayList<>();
        this.TrieOfTargetWord = new Trie();

        for (int i = 0; i < this.Dict.size(); i++) {
            this.TrieOfTargetWord.insert(this.Dict.get(i).getWord_target(), i);
        }
    }

    // getter
    public ArrayList<Word> getDict() {
        return this.Dict;
    }

    public Trie getTrieOfTargetWord() {
        return this.TrieOfTargetWord;
    }

    //-------------METHOD-------------

    public Word findWord(String w_target) {
        int id = TrieOfTargetWord.search(w_target);
        return (id >= 0) ? this.Dict.get(id) : null;
    }

    public void insertWord(Word w) {
        int check = this.TrieOfTargetWord.search(w.getWord_target());

        if(check == -1) {
            this.Dict.add(w);
            this.TrieOfTargetWord.insert(w.getWord_target(), this.Dict.size()-1);
        } else {
            ArrayList<String> tmp = w.getWord_explain();
            ArrayList<String> wordExist = this.Dict.get(check).getWord_explain();

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
    /*
    suggest:
    edit_word

    delete_word

     */
}