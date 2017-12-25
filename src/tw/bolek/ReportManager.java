package tw.bolek;

import JavaMasters.IO.UsersManager;
import Project_package.ProjectManager;
import ch.makery.shop.TaskService;

import java.util.List;

public class ReportManager {

    //singleton
    private static ReportManager instance = new ReportManager();

    private static String filename = "ReportsList.txt";

    private List<Report> reports;

    public static ReportManager getInstance() {
        return instance;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public ReportManager(){

    }
}
