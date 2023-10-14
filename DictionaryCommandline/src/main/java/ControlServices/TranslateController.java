package ControlServices;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Services.*;


public class TranslateController {
    private final List<String> languages = new ArrayList<>();

    public TranslateController() {
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

    public String translateWord(String word, String sourceLanguage, String targetLanguage) throws IOException {
        String sourceLanguageCode = getLanguageCode(sourceLanguage);
        String targetLanguageCode = getLanguageCode(targetLanguage);
        String translation = Translate.translateWord(word, sourceLanguageCode, targetLanguageCode);
        return translation;
    }

    public void translateFile(String sourceLanguage, String targetLanguage, String sourceFilePath, String targetFilePath) throws IOException {
        String sourceLanguageCode = getLanguageCode(sourceLanguage);
        String targetLanguageCode = getLanguageCode(targetLanguage);
        Translate.translateFile(sourceLanguageCode, targetLanguageCode, sourceFilePath, targetFilePath);
    }
}
