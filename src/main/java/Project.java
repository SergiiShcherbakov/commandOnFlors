import java.util.Objects;

public class Project {
    private final int MAX_PEOPLE_IN_COMMAND = 7;
    private int projectName;
    private int countCommand;

    @Override
    public String toString() {
        return "Project{" +
                "projectName=" + projectName +
                ", countCommand=" + countCommand +
                '}';
    }

    public int maxCountPeopleInProject(){
        return countCommand * MAX_PEOPLE_IN_COMMAND;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName == project.projectName &&
                countCommand == project.countCommand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }

    public int getProjectName() {
        return projectName;
    }


    public int getCountCommand() {
        return countCommand;
    }

    public Project(int projectName, int countCommand) {
        this.projectName = projectName;
        this.countCommand = countCommand;
    }
}