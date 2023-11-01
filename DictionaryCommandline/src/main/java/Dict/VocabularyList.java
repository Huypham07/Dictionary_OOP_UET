package Dict;
import java.io.*;
import java.util.*;

class VocabularyList {
    private List<Vocabulary> vocabularies = new ArrayList<>();

    public void loadVocabulary(String filePath, String topic) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isTopic = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("# " + topic)) {
                    isTopic = true;
                } else if (isTopic && !line.isEmpty()) {
                    String[] parts = line.split(" ");
                    if (parts.length >= 3) {
                        String word = parts[0];
                        String meaning = parts[1];
                        String wordType = parts[2];
                        vocabularies.add(new Vocabulary(word, meaning, wordType));
                    }
                } else if (isTopic && line.isEmpty()) {
                    break; // Kết thúc khi gặp dòng trống
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void review(int wordCount) {
        Collections.shuffle(vocabularies);
        int count = Math.min(wordCount, vocabularies.size());
        for (int i = 0; i < count; i++) {
            Vocabulary vocabulary = vocabularies.get(i);
            System.out.print("Word: " + vocabulary.getWord() + " (" + vocabulary.getWordType() + ")\nPress Enter for the meaning.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            System.out.println("Meaning: " + vocabulary.getMeaning());
        }
    }
}
