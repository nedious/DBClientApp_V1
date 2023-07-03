package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class: LoginController: 1) validates login credentials, 2)
 * */
public class LoginController implements Initializable {
    @FXML private TextField loginUsernameTextField;
    @FXML private PasswordField loginPasswordField;

    @FXML private Button loginLoginButton;
    @FXML private Button loginExitButton;

    @FXML private Label loginErrorMessageLabel;



// --------------------- Methods ---------------------- //

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Method: loginErrorMessageLabelOnAction checks if username or password are valid and connect user to database.
     *
     * @param e  when user clicks 'Login' button, the application is closed.
     */
    public void loginLoginButtonOnAction(ActionEvent e){

        if ((loginUsernameTextField.getText().isBlank() == false) && loginPasswordField.getText().isBlank() == false) {
            // if username || password is blank (true), then true != false -> go to else
            loginErrorMessageLabel.setText("Loading ...");

//            validateLogin();

        } else {
            loginErrorMessageLabel.setText("Please enter Username and Password");
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
}









