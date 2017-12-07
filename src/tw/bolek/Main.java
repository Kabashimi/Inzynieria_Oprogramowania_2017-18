package tw.bolek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    List<String> users;
    List<String> projects;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/view.fxml"));
        primaryStage.setTitle("Inżynieria oprogramowania [tw.bolek]");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }
}
