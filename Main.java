package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.Account;
import sample.model.Memory;

public class Main extends Application {

    public static void main(String[] args) {
        if (Memory.getInstance().isDebugMode()) {
            Account account1 = new Account();

            account1.setLoginCode("31000000");
            account1.setName("31000000");
            account1.setEmail("31000000@gmail.com");
            account1.setPassWord("31000000");

            Memory.getInstance().getAccounts().add(account1);

            Account account2 = new Account();

            account2.setLoginCode("32000000");
            account2.setName("32000000");
            account2.setEmail("32000000@gmail.com");
            account2.setPassWord("32000000");

            Memory.getInstance().getAccounts().add(account2);
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/sample/fileFXML/welcome.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
