package manageData.Datatype;

import java.util.*;

public class Word {
    private String word_target;
    private ArrayList<String> word_explain;
    private String wordType;

    //constructors
    public Word() {
        word_target = "";
        word_explain = new ArrayList<>();
        wordType = "";
    }

    // setters
    public void copy(Word other) {
        this.word_explain = new ArrayList<>(other.word_explain);
        this.word_target = new String(other.word_target);
        this.wordType = new String(other.wordType);
    }
    
    public void setWordTarget(String word_target) {
        this.word_target = new String(word_target);
    }

    public void setWordExplain(ArrayList<String> word_explain) {
        this.word_explain = new ArrayList<>(word_explain);
    }
    
    
    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public void addExplain(String newExplain) {
        if (this.word_explain == null)
            this.word_explain = new ArrayList<>();
        this.word_explain.add(newExplain);
    }

    // getters
    public String getWord_target() {
        return new String(this.word_target);
    }

    public ArrayList<String> getWord_explain() {
        return this.word_explain;
    }
    
    public String getWordType() {
        return wordType;
    }
}