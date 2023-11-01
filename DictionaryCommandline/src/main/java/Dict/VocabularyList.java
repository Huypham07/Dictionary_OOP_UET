package Dict;
import java.io.*;
import java.util.*;

class VocabularyList {
    private List<Vocabulary> vocabularies = new ArrayList<>();
    
    public void addVocabulary(String topic, Vocabulary vocabulary) {
        try {
            String filePath = "data/WordsBySubject.txt";

            // Tạo danh sách tạm thời để lưu dữ liệu từ file
            LinkedList<String> lines = new LinkedList<>();

            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            boolean foundTopic = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);

                if (line.startsWith("# " + topic)) {
                    foundTopic = true;
                }

                if (foundTopic && line.isEmpty()) {
                    lines.add(vocabulary.getWord() + "   " + vocabulary.getMeaning() + "   " + vocabulary.getWordType());
                    foundTopic = false;
                }
            }

            scanner.close();
            
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while adding vocabulary to the file.");
            e.printStackTrace();
        }
    }


    public void loadVocabulary(String filePath, String topic) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isTopic = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("# " + topic)) {
                    isTopic = true;
                } else if (isTopic && !line.isEmpty()) {
                    String[] parts = line.split("  ");
                    if (parts.length >= 3) {
                        String word = parts[0];
                        String meaning = parts[1];
                        String wordType = parts[2];
                        vocabularies.add(new Vocabulary(word, meaning, wordType));
                    }
                } else if (isTopic && line.isEmpty()) {
                    break; 
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
