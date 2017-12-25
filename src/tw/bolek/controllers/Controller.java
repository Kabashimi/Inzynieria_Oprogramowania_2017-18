package tw.bolek.controllers;

import JavaMasters.IO.User;
import JavaMasters.IO.UsersManager;

import Project_package.ProjectManager;
import ch.makery.shop.TaskService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import tw.bolek.Report;
import tw.bolek.ReportManager;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Controller implements Initializable {

    private boolean isRunning = true;

    @FXML
    ListView<String> projectsListView;

    @FXML
    Label currentDateLabel;

    @FXML
    Label reportGenerationDateLabel;

    ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //zegar w prawym dolnym rogu
        runClock();

        reportGenerationDateLabel.setText("Report generated on [...]");

        List<Report> reportList = new ArrayList<>();
        reportList.add(new Report(new UsersManager(), new ProjectManager(), new TaskService()));

        ReportManager.getInstance().setReports(reportList);

        String tmpUserString;
        ObservableList<String> usersStringList = FXCollections.observableArrayList();
        for(User u: ReportManager.getInstance().getReports().get(0).getUsersManager().getAllUsers()){
            tmpUserString = u.getFirstName() + " " + u.getLastName() + " : " + u.getEmail();
            usersStringList.add(tmpUserString);
            projectsListView.setItems(usersStringList);
        }

        //projectsListView.setItems(items);
        UsersManager usersManager = new UsersManager();
        List<User> usersList = usersManager.getAllUsers();
//lista użytkowników do wyświetlenia
        System.out.println("Wszyscy użytkownicy systemu:");
//        ObservableList<String> usersStringList = FXCollections.observableArrayList();
//        String tmpUserString;
//        for (User u : usersList) {
//            tmpUserString = u.getFirstName() + " " + u.getLastName() + " : " + u.getEmail();
//            usersStringList.add(tmpUserString);
//            projectsListView.setItems(usersStringList);
//        }
    }

    private void runClock() {
        Thread clock = new Thread() {
            public void run() {
                while (isRunning) {
                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    Date date = new Date();
                    //Calendar cal = Calendar.getInstance();

                    Platform.runLater(() -> currentDateLabel.setText(dateFormat.format(date)));
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        clock.start();
    }
}
