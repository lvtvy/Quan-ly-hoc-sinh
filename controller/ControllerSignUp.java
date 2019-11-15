package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Account;
import sample.model.Memory;

import java.io.IOException;
import java.util.List;

public class ControllerSignUp {

    private List<Account> accounts = Memory.getInstance().getAccounts();

    @FXML
    private TextField passText;

    @FXML
    private TextField codeText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField emailText;

    public void Add(ActionEvent e) {
        Account account = new Account();
        account.setLoginCode(codeText.getText());
        account.setName(nameText.getText());
        account.setEmail(emailText.getText());
        account.setPassWord(passText.getText());
        accounts.add(account);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Register");
        alert.setHeaderText("Register Success ");
        alert.showAndWait();
    }

    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/fileFXML/welcome.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
        stage.setResizable(false);
    }
}