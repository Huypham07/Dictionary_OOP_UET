package Dict;
import java.io.*;
import java.util.*;
import manageData.Datatype.Word;

public class VocabularyList {
    private List<List<Word>> vocabularies = new ArrayList<>();
    private List<String> topics = new ArrayList<>();

    public List<String> getTopics() {
        return topics;
    }

    public List<List<Word>> getVocabularies() {
        return vocabularies;
    }
    
    public int addNewVocabulary(String topic, Word word) {
        saveFile = true;
        if (topics.contains(topic)) {
            vocabularies.get(topics.indexOf(topic)).add(word);
            return topics.indexOf(topic); // exist topic
        } else {
            topics.add(topic);
            List<Word> newList = new ArrayList<>();
            newList.add(word);
            vocabularies.add(newList);
            return topics.size() - 1;
        }
    }
    
    private boolean saveFile = false;

    public boolean isSaveFile() {
        return saveFile;
    }
    
    public void saveFileVocabulary() {
        if (saveFile) {
            try {
                String filePath = "src/data/WordsBySubject.txt";
                FileWriter fw = new FileWriter(filePath);
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < topics.size(); ++i) {
                    bw.write("# " + topics.get(i) + "\n");
                    
                    for (Word w : vocabularies.get(i)) {
                        if (w.getWord_target() != null && !w.getWord_target().isEmpty()) {
                            bw.write(w.getWord_target() + "  ");

                            bw.write(w.getWord_explain().get(0) + "  ");

                            bw.write(w.getWordType() + "  ");

                            bw.write("\n");
                        }
                    }
                    bw.write("\n");
                }

                System.out.println("successful !!");
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Export failed!!!");
                System.out.println("Sorry. An error occurred while exporting data.");
            }
        }
    }


    public void loadVocabulary(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("# ")) {
                    String topic = line.substring(2);
                    topics.add(topic);
                    vocabularies.add(new ArrayList<>());
                } else if (!line.isEmpty()) {
                    String[] parts = line.split("  ");
                    if (parts.length >= 3) {
                        String english = parts[0];
                        String meaning = parts[1];
                        String wordType = parts[2];
                        Word word = new Word();
                        word.setWordTarget(english);
                        word.setWordType(wordType);
                        word.addExplain(meaning);
                        vocabularies.get(topics.size() - 1).add(word);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void review(int wordCount, int topic) {
        Collections.shuffle(vocabularies.get(topic));
        int count = Math.min(wordCount, vocabularies.get(topic).size());
        for (int i = 0; i < count; i++) {
            Word vocabulary = vocabularies.get(topic).get(i);
            System.out.print("Word: " + vocabulary.getWord_target()+ " (" + vocabulary.getWordType() + ")\nPress Enter for the meaning.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            System.out.println("Meaning: " + vocabulary.getWord_explain().get(0));
        }
    }
}
