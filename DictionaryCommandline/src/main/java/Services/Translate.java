package Services;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;


import java.io.File;
import java.io.IOException;
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

    public static String parseTranslationResponse(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);
            JSONArray translationArray = jsonArray.getJSONArray(0);

            StringBuilder translatedTextBuilder = new StringBuilder();
            for (int i = 0; i < translationArray.length(); i++) {
                String translationSegment = translationArray.getJSONArray(i).getString(0);
                translatedTextBuilder.append(translationSegment);
            }

            return translatedTextBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Unable to parse the translation response.";
        }
    }

    public void translateFile(String sourceLanguage, String targetLanguage, File sourceFile, File targetFile) throws IOException {
        String sourceLanguageCode = getLanguageCode(sourceLanguage);
        String targetLanguageCode = getLanguageCode(targetLanguage);

        String sourceText = FileService.readFile(sourceFile);
        String translatedText = translateWord(sourceText, sourceLanguageCode, targetLanguageCode);

        FileService.writeFile(targetFile, translatedText);
    }

    public static void main(String[] args) throws IOException {
        // test translateFile
        Translate translate = new Translate();
        File sourceFile = new File("source/main/java/data/words_dictionary.json");
        File targetFile = new File("source/main/java/data/words_dictionary_vi.json");
        translate.translateFile("English", "Vietnamese", sourceFile, targetFile);

    }
}
