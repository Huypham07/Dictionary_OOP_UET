package Services;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;


import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Translate {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final String API_URL = "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t";

    private final List<String> languages = new ArrayList<>();

    public Translate() {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Spanish");
        languages.add("French");
        languages.add("Japanese");
    }

    public List<String> getLanguages() {
        return languages;
    }

    public String getLanguageCode(String language) {
        switch (language) {
            case "English":
                return "en";
            case "Vietnamese":
                return "vi";
            case "Spanish":
                return "es";
            case "French":
                return "fr";
            case "Japanese":
                return "ja";
            default:
                return "en";
        }
    }


    public static String translateWord(String textToTranslate, String sourceLanguage, String targetLanguage) throws IOException {
        String encodedText = URLEncoder.encode(textToTranslate, StandardCharsets.UTF_8);
        String apiUrl = String.format("%s&sl=%s&tl=%s&text=%s", API_URL, sourceLanguage, targetLanguage, encodedText);

        HttpGet httpGet = new HttpGet(apiUrl);
        String jsonResponse = EntityUtils.toString(httpClient.execute(httpGet).getEntity());

        return parseTranslationResponse(jsonResponse);
    }

    public static String parseTranslationResponse(String jsonResponse) {
        JSONArray jsonArray = new JSONArray(jsonResponse);
        JSONArray jsonArray2 = jsonArray.getJSONArray(0);
        StringBuilder translatedText = new StringBuilder();
        for (int i = 0; i < jsonArray2.length(); i++) {
            translatedText.append(jsonArray2.getJSONArray(i).get(0).toString());
        }
        return translatedText.toString();
    }

    public void translateFile(String sourceLanguage, String targetLanguage, File sourceFile, File targetFile) throws IOException {
        String sourceLanguageCode = getLanguageCode(sourceLanguage);
        String targetLanguageCode = getLanguageCode(targetLanguage);

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String translatedLine = translateWord(line, sourceLanguageCode, targetLanguageCode);
                bw.write(translatedLine);
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // test translateFile
        Translate translate = new Translate();
        File sourceFile = new File("C:/IntelliJ Projects/Dictionary_OOP_UET/DictionaryCommandline/src/main/java/data/dictionary.txt");
        File targetFile = new File("C:/IntelliJ Projects/Dictionary_OOP_UET/DictionaryCommandline/src/main/java/data/dictionary2.txt");
        translate.translateFile("English", "Vietnamese", sourceFile, targetFile);

    }
}
