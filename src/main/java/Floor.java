import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int COUNT_PEOPLE_IN_BLOCKS = 4;
    private final int name;
    private int freeBlocks;
    private List<Project> projects;

    public Floor(int name, int blocksOnFlore) {
        this.name = name;
        projects = new ArrayList<>();
        freeBlocks = blocksOnFlore ;
    }

    public void selectProjects(List<Project> projectsOnCompany) {
        while(isEnoughSpaceForTheSmallerProject(projectsOnCompany)) {
            for (Project p : projectsOnCompany) {
                if (isEnoughSpaceForProject(p)) {
                    projects.add(p);
                    projectsOnCompany.remove(p);
                    countFreeBlocks();
                    break;
                }
            }
        }
    }

    private boolean isEnoughSpaceForTheSmallerProject(List<Project> projectsOnCompany) {
        return projectsOnCompany.size() > 0
                && isEnoughSpaceForProject(projectsOnCompany.get(projectsOnCompany.size()-1));
    }

    private boolean isEnoughSpaceForProject(Project project) {
        return freeBlocks * COUNT_PEOPLE_IN_BLOCKS > project.maxCountPeopleInProject();
    }


    private void countFreeBlocks(){
        if(projects.isEmpty()){
            return;
        } else {
            int freeBlocks =   this.freeBlocks;
            for (Project p : projects){
                freeBlocks -= p.maxCountPeopleInProject() / COUNT_PEOPLE_IN_BLOCKS;
            }
            this.freeBlocks = freeBlocks;
        }
    }

    @Override
    public String toString() {
        String projectMessages = "";
        for(Project p:projects){
            projectMessages += "проект #" + p.getProjectName() + " ("+ p.getCountCommand()+ " команд);";
        }
        return "Этаж " + name + " - " + projectMessages;
    }
}
