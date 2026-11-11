package service;

import entity.EpicTask;
import entity.Subtask;

public interface TaskManager {

    EpicTask createEpicTask(String name, String description);
    Subtask createSubtask(String name, String description, Long epicId);
    void deleteSubtask(long id);
    void deleteEpic(long id);
    void updateEpic(EpicTask epicTask);
    void updateSubtask(Subtask subtask);
    void deleteAllSubtasks();
    void deleteAllEpicTasks();

}
