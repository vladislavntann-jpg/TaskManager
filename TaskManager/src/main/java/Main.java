import entity.EpicTask;
import entity.Subtask;
import entity.TaskStatus;
import service.Managers;
import service.TaskManager;

public class Main {



    public static void main(String[] args){

        TaskManager manager = Managers.getDefault();
        EpicTask epicTask = manager.createEpicTask("Name ", "Description");
        Subtask subtask = manager.createSubtask("NewTask", "sadasd", epicTask.getId());
        Subtask updateSubtask = new Subtask(subtask.getId(),"DiffName", "DiffDescription", epicTask.getId());
        updateSubtask.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateSubtask(updateSubtask);
        System.out.println(epicTask);
        manager.deleteSubtask(subtask.getId());
        System.out.println(epicTask);


        //epicTask.updateEpicStatus();

    }
}
