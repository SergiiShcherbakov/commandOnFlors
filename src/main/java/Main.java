import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Project> projectList = new LinkedList<>();
        int blocsOnFlore = 0;

        for(String arg: args){
            System.out.println(arg);
            if(arg.startsWith("-p")){
                projectList = selectCommands(arg);
            }
            if(arg.startsWith("–c")){
                blocsOnFlore = selectCommandsOnFloreArgument(arg);
            }
        }
        List<Floor> floors = new ArrayList<>();
        int florName = 1;
        while (projectList.size() > 0 ){
            Floor floor = new Floor(florName, blocsOnFlore );
            floor.selectProjects(projectList);
            florName ++;
            floors.add(floor);
        }
        for (Floor f: floors){
            System.out.println(f);
        }
    }

    private static int selectCommandsOnFloreArgument(String command) {
        String blocksOnFlore = command.replace("–c", "");
        blocksOnFlore = blocksOnFlore.replaceAll(" ", "");
        return Integer.parseInt(blocksOnFlore);
    }

    private static List<Project> selectCommands(String countCommandsInProject) {
        String commandsSting = countCommandsInProject.replace("-p", "");
        commandsSting = commandsSting.replaceAll(" ", "");
        String[] commandsInProject = commandsSting.split(",");
        List<Project> commandList = new ArrayList<>();
        for (int i = 0; i < commandsInProject.length; i++) {
            Project project = new Project(i ,Integer.parseInt(commandsInProject[i]));
            commandList.add(project);
        }
        commandList.sort(new Comparator<Project>() {
            public int compare(Project o1, Project o2) {
                return o2.getCountCommand()- o1.getCountCommand();
            }
        });
        return commandList;
    }
}
