//package helper;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
//public class French {
//
//    import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.MenuItem;
//import javafx.scene.control.SplitMenuButton;
//
//    public class LoginController {
//        @FXML
//        private SplitMenuButton loginLanguageMenu;
//        @FXML
//        private MenuItem loginLanguageEnglish;
//        @FXML
//        private MenuItem loginLanguageFrench;
//
//        // Implement the translation logic for English language
//        private void translateToEnglish() {
//            // TODO: Translate the UI components and set the text to English
//            loginSecureLoginLabel.setText("Secure Login");      // secure login label
//            loginUsernameLabel.setText("Username");         // username label
//            loginPasswordLabel.setText("Password");         // password label
//
//            loginUsernameTextField.setText("Username"); // username text field
//            loginPasswordField.setText("Password");
//
//            loginLoginButton.setText("Login");          // login's login button
//            loginExitButton.setText("Exit");           // login's exit button
//
//            loginTimeZoneLabel.setText("Time Zone");
//        }
//
//        // Implement the translation logic for French language
//        private void translateToFrench() {
//            // TODO: Translate the UI components and set the text to French
//            loginSecureLoginLabel.setText("Connexion sécurisée");      // secure login label
//            loginUsernameLabel.setText("Nom d'utilisateur");         // username label
//            loginPasswordLabel.setText("Mot de passe");         // password label
//
//            loginUsernameTextField.setText("Nom d'utilisateur"); // username text field
//            loginPasswordField.setText("Mot de passe");
//
//            loginLoginButton.setText("Mot de passe");          // login's login button
//            loginExitButton.setText("Sortie");           // login's exit button
//
//            loginTimeZoneLabel.setText("Fuseau horaire");
//        }
//
//        @FXML
//        private void initialize() {
//            // Event handler for English language selection
//            loginLanguageEnglish.setOnAction((ActionEvent event) -> {
//                setLanguage("English");
//            });
//
//            // Event handler for French language selection
//            loginLanguageFrench.setOnAction((ActionEvent event) -> {
//                setLanguage("French");
//            });
//        }
//
//        public void setLanguage(String language) {
//            loginLanguageMenu.setText(language); // Update the SplitMenuButton text
//
//            // Perform language-specific translation
//            if (language.equals("English")) {
//                translateToEnglish();
//            } else if (language.equals("French")) {
//                translateToFrench();
//            }
//        }
//    }
//
//}
//
//


