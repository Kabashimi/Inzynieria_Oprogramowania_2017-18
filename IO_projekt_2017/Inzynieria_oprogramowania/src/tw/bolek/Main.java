package tw.bolek;

import JavaMasters.IO.User;
import JavaMasters.IO.UsersManager;
import Project_package.Project;
import Project_package.ProjectManager;
import ch.makery.shop.ITaskService;
import ch.makery.shop.TaskService;
import ch.makery.shop.model.Task;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    List<String> users;
    List<String> projects;

    public void testMetod(){

        //utworzenie obiektów
        ITaskService itask = new TaskService();
        ProjectManager projectManager = new ProjectManager();
        UsersManager usersManager = new UsersManager();

        //inicjalizacja
        ObservableList<Task> taskList = itask.getTaskList();
        projectManager.addProject(new Project());
        List<Project> projectList = projectManager.getProjectList();
        List<User> usersList = usersManager.getAllUsers();

        //getProject
        Project project = projectList.get(0);
        //getTask
        Task task = taskList.get(0);
        //getUser
        User user = usersList.get(0);

        //Print template:
        //Tytuł
        System.out.println(project.getProjectName());
        //Detale
        System.out.println(project.getProjectDetails());


        //Użytkownik
        //Imię
        System.out.println(user.getFirstName());
        //Email
        System.out.println(user.getEmail());
        //status
        System.out.println(user.getUserStatus());

        //Task
        //Tytuł
        System.out.println(task.getTitle());
        //Autor
        System.out.println(task.getAuthor());
        //Termin
        System.out.println(task.getDueDate());







        //lista użytkowników do wyświetlenia
        System.out.println("Wszyscy użytkownicy systemu:");
        ObservableList<String> usersStringList = FXCollections.observableArrayList();
        String tmpUserString;
        for (User u : usersList){
            tmpUserString = u.getFirstName() + " " + u.getLastName()+ " : "+u.getEmail();
            usersStringList.add(tmpUserString);
        }

        System.out.println(usersStringList.get(0));
    }


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/view.fxml"));
        primaryStage.setTitle("Inżynieria oprogramowania [tw.bolek]");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
        testMetod();
    }
}
