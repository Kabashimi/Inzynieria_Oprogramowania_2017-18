package tw.bolek.controllers;

import JavaMasters.IO.User;
import JavaMasters.IO.UsersManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ListView<String> projectsListView;

    ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //projectsListView.setItems(items);

        UsersManager usersManager = new UsersManager();
        List<User> usersList = usersManager.getAllUsers();
//lista użytkowników do wyświetlenia
        System.out.println("Wszyscy użytkownicy systemu:");
        ObservableList<String> usersStringList = FXCollections.observableArrayList();
        String tmpUserString;
        for (User u : usersList) {
            tmpUserString = u.getFirstName() + " " + u.getLastName() + " : " + u.getEmail();
            usersStringList.add(tmpUserString);
            projectsListView.setItems(usersStringList);
        }
    }
}
