package tw.bolek;

import JavaMasters.IO.User;
import JavaMasters.IO.UsersManager;
import Project_package.Project;
import Project_package.ProjectManager;
import ch.makery.shop.ITaskService;
import ch.makery.shop.TaskService;
import ch.makery.shop.model.Task;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tw.bolek.controllers.Controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    List<String> users;
    List<String> projects;

    public void testMetod() {

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

        //Print template:
        //Tytuł
        System.out.println(project.getProjectName());
        //Detale
        System.out.println(project.getProjectDetails());


        for (Task task1 : taskList) {
            System.out.println(task1.getTitle());
        }

        for (Project pr : projectList) {
            System.out.println(pr.getProjectName());
            System.out.println(pr.getProjectDetails());
        }

        for (User u : usersList) {
            System.out.println(u.getFirstName());
            System.out.println(u.getLastName());
        }


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
