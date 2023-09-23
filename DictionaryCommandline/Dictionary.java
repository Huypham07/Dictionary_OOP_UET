import java.util.*;
public class Dictionary {
    private ArrayList<Word> Dict;

    // Constructors
    public Dictionary() {
    }

    // getter
    public ArrayList<Word> getDict() {
        return this.Dict;
    }

    //-------------METHOD-------------

    public Word findWord(String w_target) {
        for (Word w : getDict()) {
            if (w.getWord_target().equalsIgnoreCase(w_target)) {
                return w;
            }
        }
        return null;
    }
    /*
    suggest:
    insertWord

    edit_word

    delete_word

     */
}
