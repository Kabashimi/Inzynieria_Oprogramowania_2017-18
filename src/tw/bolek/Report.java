package tw.bolek;

import JavaMasters.IO.User;
import JavaMasters.IO.UsersManager;
import Project_package.ProjectManager;
import ch.makery.shop.TaskService;

import java.util.List;

public class Report {
    private UsersManager usersManager;
    private ProjectManager projectManager;
    private TaskService taskService;

    public Report(UsersManager usersManager, ProjectManager projectManager, TaskService taskService) {
        this.usersManager = usersManager;
        this.projectManager = projectManager;
        this.taskService = taskService;
    }

    public Report() {

    }

    public UsersManager getUsersManager() {
        return usersManager;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public TaskService getTaskService() {
        return taskService;
    }
}
