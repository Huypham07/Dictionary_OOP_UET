package Services;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import Dict.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Translate {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final String API_URL = "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t";

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

    public void translateFile(String sourceLanguage, String targetLanguage, String sourceFilePath, String targetFilePath) throws IOException {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile(sourceFilePath);
        Dictionary dictionary = dictionaryManagement.getDictionary();
        for (Word word : dictionary.getDict()) {
            String translation = translateWord(word.getWord_target(), sourceLanguage, targetLanguage);
            word.getWord_explain().set(0, translation);
        }
        dictionaryManagement.dictionaryExportToFile(targetFilePath);
    }
}
