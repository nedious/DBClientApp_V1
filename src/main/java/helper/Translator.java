package helper;

import java.util.HashMap;
import java.util.Map;


public class Translator {
    public static final Map<String, String> englishTranslations = new HashMap<>();
    public static final Map<String, String> frenchTranslations = new HashMap<>();

    static {
        // fx:id key and English translations
//        Map<String, String> englishTranslations = new HashMap<>();
        englishTranslations.put("loginSecureLoginLabel", "Secure Login");
        englishTranslations.put("loginUsernameLabel", "Username");
        englishTranslations.put("loginPasswordLabel", "Password");
        englishTranslations.put("loginUsernameTextField", "Username");
        englishTranslations.put("loginPasswordField", "Password");
        englishTranslations.put("loginLoginButton", "Login");
        englishTranslations.put("loginExitButton", "Exit");
        englishTranslations.put("loginTimeZoneLabel", "Time Zone");

        englishTranslations.put("loginLanguageLabel", "Language");
        englishTranslations.put("loginEnglishRadio", "English");
        englishTranslations.put("loginFrenchRadio", "French");


        // fx:id key and French translations
//        Map<String, String> frenchTranslations = new HashMap<>();
        frenchTranslations.put("loginSecureLoginLabel", "Connexion sécurisée");
        frenchTranslations.put("loginUsernameLabel", "Nom d'utilisateur");
        frenchTranslations.put("loginPasswordLabel", "Mot de passe");
        frenchTranslations.put("loginUsernameTextField", "Nom d'utilisateur");
        frenchTranslations.put("loginPasswordField", "Mot de passe");
        frenchTranslations.put("loginLoginButton", "Connexion");
        frenchTranslations.put("loginExitButton", "Sortie");
        frenchTranslations.put("loginTimeZoneLabel", "Fuseau horaire");

        frenchTranslations.put("loginLanguageLabel", "Langue");
        frenchTranslations.put("loginEnglishRadio", "Anglais");
        frenchTranslations.put("loginFrenchRadio", "Français");
    }
}

//
//public class Translator {
//    private Map<String, Map<String, String>> translations;
//
//    public Translator() {
//        // Initialize the translations
//        translations = new HashMap<>();
//
//        // fx:id key and English translations
//        Map<String, String> englishTranslations = new HashMap<>();
//        englishTranslations.put("loginSecureLoginLabel", "Secure Login");
//        englishTranslations.put("loginUsernameLabel", "Username");
//        englishTranslations.put("loginPasswordLabel", "Password");
//        englishTranslations.put("loginUsernameTextField", "Username");
//        englishTranslations.put("loginPasswordField", "Password");
//        englishTranslations.put("loginLoginButton", "Login");
//        englishTranslations.put("loginExitButton", "Exit");
//        englishTranslations.put("loginTimeZoneLabel", "Time Zone");
//
//        englishTranslations.put("loginLanguageLabel", "Language");
//        englishTranslations.put("loginEnglishRadio", "English");
//        englishTranslations.put("loginFrenchRadio", "French");
//
//
//        // fx:id key and French translations
//        Map<String, String> frenchTranslations = new HashMap<>();
//        frenchTranslations.put("loginSecureLoginLabel", "Connexion sécurisée");
//        frenchTranslations.put("loginUsernameLabel", "Nom d'utilisateur");
//        frenchTranslations.put("loginPasswordLabel", "Mot de passe");
//        frenchTranslations.put("loginUsernameTextField", "Nom d'utilisateur");
//        frenchTranslations.put("loginPasswordField", "Mot de passe");
//        frenchTranslations.put("loginLoginButton", "Connexion");
//        frenchTranslations.put("loginExitButton", "Sortie");
//        frenchTranslations.put("loginTimeZoneLabel", "Fuseau horaire");
//
//        frenchTranslations.put("loginLanguageLabel", "Langue");
//        frenchTranslations.put("loginEnglishRadio", "Anglais");
//        frenchTranslations.put("loginFrenchRadio", "Français");
//
//
//        // Add the translations to the main translations map
//        translations.put("English", englishTranslations);
//        translations.put("French", frenchTranslations);
//    }
//
//    public String translate(String key, String language) {
//        // Check if the translation exists for the given language
//        if (translations.containsKey(language)) {
//            Map<String, String> languageTranslations = translations.get(language);
//            // Return the translated value for the given key
//            return languageTranslations.getOrDefault(key, key);
//        }
//
//        // If translation is not available, return the original key
//        return key;
//    }
//}
