package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void okClicked() {
        String userId = userIdField.getText();
        String password = passwordField.getText();
        int passwordLength = password.length();

        System.out.println("Identifiant Utilisateur: " + userId);
        System.out.println("Mot de passe: " + "*".repeat(passwordLength));
    }

    @FXML
    private void cancelClicked() {
        userIdField.clear();
        passwordField.clear();
    }
}
//exo8