package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Account;
import sample.model.Memory;

import java.io.IOException;
import java.util.List;

public class ControllerWelcome {

    @FXML
    private TextField loginCodeText;

    @FXML
    private PasswordField passWordText;

    private List<Account> accounts = Memory.getInstance().getAccounts();

    @FXML
    public void SignUp(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/fileFXML/SignUp.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    public void SignIn(ActionEvent e) throws IOException {
        String user = loginCodeText.getText();
        String pass = passWordText.getText();
        System.out.println(accounts);
        boolean isSuccess = false;
        if (accounts.size() == 0) {
            isSuccess = false;
        } else {
            for (Account account : accounts) {
                if (account.getLoginCode().equals(user) && account.getPassWord().equals(pass)) {
                    isSuccess = true;

                    if (account.setLoginCode(user)) {
                        if (user.startsWith("3100")) {

                            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/sample/fileFXML/teacher.fxml"));
                            Parent view = loader.load();
                            Scene scene = new Scene(view);
                            stage.setScene(scene);
                            stage.setResizable(false);
                        } else if (user.startsWith("3200")) {
                            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/sample/fileFXML/student.fxml"));
                            Parent view = loader.load();
                            Scene scene = new Scene(view);
                            stage.setScene(scene);
                            stage.setResizable(false);
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("LOGIN");
                            alert.setHeaderText("LOGIN FAIL");
                            alert.showAndWait();
                        }
                    }
                }
            }
        }
    }
}

