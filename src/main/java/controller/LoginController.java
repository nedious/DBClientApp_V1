package controller;

import DAO.UserDaoImpl;
import helper.Translator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import helper.Alert;
/**
 * Class: LoginController: 1) validates login credentials, 2)
 * */
public class LoginController implements Initializable {

    @FXML private Label loginSecureLoginLabel;      // secure login label
    @FXML private Label loginUsernameLabel;         // username label
    @FXML private Label loginPasswordLabel;         // password label

    @FXML private TextField loginUsernameTextField; // username text field
    @FXML private TextField loginPasswordField;     // password, password field

    @FXML private Button loginLoginButton;          // login's login button
    @FXML private Button loginExitButton;           // login's exit button

// ----------- //
    @FXML private Label loginTimeZoneLabel;         // time zone label
    @FXML private Label loginTimeZoneDynamicUpdate; // dynamic local time zone

// ----------- //
    @FXML private Label loginLanguageLabel;         // language label
    @FXML private RadioButton loginEnglishRadio;    // English radio
    @FXML private RadioButton loginFrenchRadio;     // French radio

//    private Translator translator;                  // to translate login page

    /**
     * Method: initialize.
     * Class 'LoginController' must either be declared abstract or implement abstract method 'initialize(URL, ResourceBundle)' in 'Initializable'
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onLanguageSelectionChanged(ActionEvent event) {
        if (loginEnglishRadio.isSelected()) {
            applyTranslations(Translator.englishTranslations);
        } else if (loginFrenchRadio.isSelected()) {
            applyTranslations(Translator.frenchTranslations);
        }
    }

    private void applyTranslations(Map<String, String> translations) {
        // Update the text on LoginView.fxml using the translations map
        loginSecureLoginLabel.setText(translations.get("loginSecureLoginLabel"));
        loginUsernameLabel.setText(translations.get("loginUsernameLabel"));
        loginPasswordLabel.setText(translations.get("passwordLabel"));
        // TODO: add remaining loginView items

    }


    /**
     * Login button, on click confirms user and if valid enters program
     * @param event clicking of login button
     * @throws SQLException
     * @throws IOException
     * @throws Exception
     */
    @FXML private void loginLoginButtonOnAction(ActionEvent event) throws SQLException, IOException, Exception {
        try {

//            ObservableList<Appointments> getAllAppointments = AppointmentsDAO.getAllAppointments();
//            LocalDateTime earlyApptTimeCheck = LocalDateTime.now().minusMinutes(15);
//            LocalDateTime lateApptTimeCheck = LocalDateTime.now().plusMinutes(15);
//            LocalDateTime apptStart;
//            int getAppointmentID = 0;
//            LocalDateTime timeView = null;
//            boolean validApptTime = false;

            String userName = loginUsernameTextField.getText();     // get username text
            String password = loginPasswordField.getText();     // get password field

            boolean validUser = UserDaoImpl.validateLogin(userName,password);      // use UserDaoImpl.validateLogin() method. returns true / false

            System.out.println("validUser: " + validUser);

            FileWriter loginReport = new FileWriter("login_activity.txt", true);    // creates new FileWriter object. true = new data should be appended to existing file, NOT overwrite it
            PrintWriter printOutput = new PrintWriter(loginReport);                                 // writes output to loginReport file

            if (validUser) {
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(getClass().getResource("AppointmentsView.fxml"));
//                Parent parent = loader.load();
//                Stage stage = (Stage) loginLoginButton.getScene().getWindow();
//                Scene scene = new Scene(parent);
//                stage.setScene(scene);
//                stage.show();

                System.out.println("validUser: " + validUser);
                printOutput.print("Valid login for: '" + userName + "' at: " + Timestamp.valueOf(LocalDateTime.now()) + "\n"); // write to loginReport object

//                for (Appointments appt: getAllAppointments) {
//                    apptStart = appt.getApptStart();
//                    if ((apptStart.isAfter(earlyApptTimeCheck) || apptStart.isEqual(earlyApptTimeCheck)) && (apptStart.isBefore(lateApptTimeCheck) || (apptStart.isEqual(lateApptTimeCheck)))) {
//                        getAppointmentID = appt.getAppointmentID();
//                        timeView = apptStart;
//                        validApptTime = true;
//                    }
//                }
//                if (validApptTime !=false){
//                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Appointment starts within 15 minutes: " + getAppointmentID + " appointment starts: " + timeView);
//                    Optional<ButtonType> confirm = alert.showAndWait();
//                    System.out.println("Appointment scheduled within 15 minutes");
//                }
//                else {
//                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "There is not a scheduled appointment.");
//                    Optional<ButtonType> confirm = alert.showAndWait();
//                    System.out.println("There is not a scheduled appointment.");
//                }
            } else {
                Alert.displayAlert(1);       // Alert: Invalid Values. Inherited from helper.Alert.

                printOutput.print("Invalid login for: '" + userName + "' at: " + Timestamp.valueOf(LocalDateTime.now()) + "\n");  // write to loginReport object
            }
            printOutput.close();    // close PrintWriter object to ensure proper cleanup.
            loginReport.close();     // close FileWriter object to ensure proper cleanup.
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    /**
     * Method: loginCancelButtonOnAction exits application.
     *
     * @param e  when user clicks 'Cancel' button, the application is closed.
     */
    public void loginExitButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) loginExitButton.getScene().getWindow();
        stage.close();
    }


//
//
//    /**
//     * Initialize login screen
//     * @param url
//     * @param resourceBundle
//     */
//    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            Locale locale = Locale.getDefault();
//            Locale.setDefault(locale);
//            ZoneId zoneId = ZoneId.systemDefault();
//            loginLocation.setText(String.valueOf(zoneId));
//
//            resourceBundle = ResourceBundle.getBundle("Languages/login", Locale.getDefault());
//            loginSecureLoginLabel.setText(resourceBundle.getString("login"));
//            loginUsernameLabel.setText(resourceBundle.getString("username"));
//            passwordLabel.setText(resourceBundle.getString("password"));
//            loginLoginButton.setText(resourceBundle.getString("loginButton"));
//            loginExitButton.setText(resourceBundle.getString("exitButton"));
//            loginTimeZoneLabel.setText(resourceBundle.getString("location"));
//
//        }catch (MissingResourceException e) {
//            System.out.println("Resource Bundle missing: " + e);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }



}






