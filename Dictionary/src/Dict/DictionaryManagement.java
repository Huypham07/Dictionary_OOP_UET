package Dict;

import java.util.*;
import java.io.*;
import manageData.Datatype.Word;
import manageData.TrieTree.Trie;
import java.sql.*;
import manageData.Datatype.WordExplain;

public class DictionaryManagement {

    private Dictionary dictionary;
    private Trie TrieOfDict;
    VocabularyList vocabs;

    // constructors
    public DictionaryManagement() {
        this.dictionary = new Dictionary();
        TrieOfDict = this.dictionary.getTrieOfTargetWord();
        vocabs = new VocabularyList();
        setupFromDB();
        GetListVocabFromDB();
    }

    // getter
    public Dictionary getDictionary() {
        return this.dictionary;
    }
    public Trie getTrieOfDict() {
        return this.TrieOfDict;
    }
    
    public VocabularyList getVocabs() {
        return this.vocabs;
    }

    //------------------METHOD-----------------

    // check valid word
    public static boolean validWord(String s) {
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
            ArrayList<WordExplain> tmp = w.getWord_explain();
            ArrayList<WordExplain> wordExist = this.dictionary.getDict().get(check).getWord_explain();

            for (WordExplain i : tmp) {
                boolean existExplain = false;

                for (WordExplain j : wordExist) {
                    if (i.equals(j)) {
                        existExplain = true;
                    }
                }

                if (!existExplain) {
                    wordExist.add(i);
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

        boolean check = false;
        for (int i = 0; i < vocabs.getVocabularies().size(); i++) {
            if (check) {
                break;
            }
            for (Word w : vocabs.getVocabularies().get(i)) {
                if (key.equals(w.getWord_target())) {
                    vocabs.getVocabularies().remove(w);
                    check = true;
                }
            }
        }
        
        this.dictionary.getDict().get(id).setWordTarget("");
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
                    String pronounce = parts[1];
                    String type = parts[2];
                    String define = parts[3];
                    String meaning = parts[4];

                    Word temp = new Word();
                    temp.setWordTarget(w_target);
                    temp.setPronounce(pronounce);
                    temp.addExplain(new WordExplain(type, define, meaning));

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
    public boolean dictionaryExportToFile(String path){
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Word w : this.getDictionary().getDict()) {
                if (w.getWord_target() != null && !w.getWord_target().isEmpty()) {

                    ArrayList<WordExplain> w_explain = w.getWord_explain();
                    for (WordExplain ex : w_explain) {
                        bw.write(w.getWord_target() + "\t" + w.getPronounce()+ "\t" + ex.getType() + "\t" + ex.getDefinition() + "\t" + ex.getMeaning() + "\n");
                    }
                }
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
    
//    private static final String port = "3306";
    private static final String port = "3307";
    private static final String dbConn = "jdbc:mysql://localhost:" + port + "/dictionary";
    private static final String username = "root";
    private static final String password = "nhienhy6714";
//    private static final String password = "";
    
    private Connection sqlConn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    private void setupFromDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn, username, password);
            pst = sqlConn.prepareStatement("select * from words natural join worddefinitions;");
            
            rs = pst.executeQuery();
            while (rs.next()) {
                Word word = new Word();
                word.setWordTarget(rs.getString(1));
                word.setPronounce(rs.getString(2));
                word.addExplain(new WordExplain(rs.getString(3), rs.getString(4), rs.getString(5)));
                insertWord(word);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void GetListVocabFromDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn, username, password);
            pst = sqlConn.prepareStatement("select * from WordTopics;");
            
            rs = pst.executeQuery();
            while (rs.next()) {
                String topic = rs.getString(1);
                Word word = findWord(rs.getString(2));
                vocabs.addNewVocabulary(topic, word);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteInDB(String key, boolean wordInTopic) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn, username, password);
            if (wordInTopic) {
                String deleteSql = "DELETE FROM wordDefinitions WHERE english = ?; " +
                                   "DELETE FROM wordtopics WHERE english = ?; " +
                                   "DELETE FROM words WHERE english = ?;";

                pst = sqlConn.prepareStatement(deleteSql);
                pst.setString(1, key);
                pst.setString(2, key);
                pst.setString(3, key);
                pst.executeUpdate();
            } else {
                String deleteSql = "DELETE FROM wordDefinitions WHERE english = ?; " +
                                   "DELETE FROM words WHERE english = ?;";

                pst = sqlConn.prepareStatement(deleteSql);
                pst.setString(1, key);
                pst.setString(2, key);
                pst.executeUpdate();
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertWordIntoDB(Word word) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn, username, password);
            // Insert into Words table
            pst = sqlConn.prepareStatement("INSERT INTO Words (English, pronounce) VALUES (?, ?)");
            pst.setString(1, word.getWord_target());
            pst.setString(2, word.getPronounce());
            pst.executeUpdate();

            // Insert into WordDefinitions table
            for (WordExplain we : word.getWord_explain()) {
                pst = sqlConn.prepareStatement("INSERT INTO WordDefinitions (English, type, Definition, Meaning) VALUES (?, ?, ?, ?)");
                pst.setString(1, word.getWord_target());
                pst.setString(2, we.getType());
                pst.setString(3, we.getDefinition());
                pst.setString(4, we.getMeaning());
                pst.executeUpdate();
            }    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertWordTopicIntoDB(String topic, Word word) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dbConn, username, password);
            pst = sqlConn.prepareStatement("INSERT INTO WordTopics (TopicName, english) VALUES (?, ?);");
            pst.setString(1, topic);
            pst.setString(2, word.getWord_target());
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertWordTopic(String topic, Word word) {
        vocabs.addNewVocabulary(topic, word);
    }
    public String getTopicOfWord(String key) {
        for (int i = 0; i < vocabs.getVocabularies().size(); i++) {
            for (Word w : vocabs.getVocabularies().get(i)) {
                if (key.equals(w.getWord_target())) {
                    return vocabs.getTopics().get(i);
                }
            }
        }
        return null;
    }
}