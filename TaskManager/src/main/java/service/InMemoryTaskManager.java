package service;


import entity.EpicTask;
import entity.Subtask;
import entity.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager{

    private Map<Long, Task> tasks = new HashMap<>();
    private Map<Long, Subtask> subTasks = new HashMap<>();
    private Map<Long, EpicTask> epicTasks = new HashMap<>();
@Override
    public EpicTask createEpicTask(String name, String description){
        EpicTask epicTask = new EpicTask(name, description);
        epicTasks.put(epicTask.getId(), epicTask);
        return  epicTask;



    }
    @Override
    public Subtask createSubtask(String name, String description, Long epicId) {
        EpicTask epicTask = epicTasks.get(epicId);
        if (epicTask == null) {
            return null;
        }

        Subtask subtask = new Subtask(name, description, epicId);
        subTasks.put(subtask.getId(), subtask);
        epicTask.add(subtask.getId());
        return subtask;

    }
@Override
    public void deleteSubtask(long id) {

        Subtask subtask = subTasks.remove(id);
        if (subtask == null) {
            return;
        }
        EpicTask epicTask = epicTasks.get(subtask.getParentId());
        epicTask.removeSubtask(id);
        epicTask.updateEpicStatus(subTasks);
    }
@Override
    public void deleteEpic(long id) {

        EpicTask epicTask = epicTasks.remove(id);
        if (epicTask == null) {
            return;
        }
        List<Long> subtaskIds = epicTask.getSubtasks();
        for (long subtaskId : subtaskIds) {
            subTasks.remove(subtaskId);
        }
    }
@Override
    public void updateEpic(EpicTask epicTask) {
        EpicTask savedEpic = epicTasks.get(epicTask.getId());
        if (savedEpic == null) {
            return;
        }
        savedEpic.setName(epicTask.getName());
        savedEpic.setDescription(epicTask.getDescription());


    }
@Override
    public void updateSubtask(Subtask subtask) {
        Subtask savedSubtask = subTasks.get(subtask.getId());
        if (savedSubtask == null || savedSubtask.getParentId() != subtask.getParentId()) {
            return;
        }
        savedSubtask.setName(subtask.getName());
        savedSubtask.setDescription(subtask.getDescription());
        savedSubtask.setStatus(subtask.getStatus());
        epicTasks.get(savedSubtask.getParentId()).updateEpicStatus(subTasks);
    }
@Override
    public void deleteAllSubtasks() {
        subTasks.clear();
        for (EpicTask epicTask : epicTasks.values()) {
            epicTask.removeAllSubtasks();
            epicTask.updateEpicStatus(subTasks);
        }


    }
@Override
    public void deleteAllEpicTasks() {
        epicTasks.clear();
        subTasks.clear();


    }




}
