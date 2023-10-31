package Dict;

public class Vocabulary {
    private String word;
    private String meaning;
    private String wordType;

    public Vocabulary(String word, String meaning, String wordType) {
        this.word = word;
        this.meaning = meaning;
        this.wordType = wordType;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWordType() {
        return wordType;
    }
}
