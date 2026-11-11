package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EpicTask extends Task {


    private List<Long> subtasks;

    public EpicTask(String name, String description) {
        super(name, description);
        this.subtasks = new ArrayList<>();
    }

    public List<Long> getSubtasks() {
        return subtasks;
    }

    public void add(Long subtaskId) {
        subtasks.add(subtaskId);


    }

    public void removeSubtask(long id) {
        subtasks.remove(id);


    }

    public void removeAllSubtasks() {
        subtasks.clear();

    }

    public void updateEpicStatus(Map<Long, Subtask> subtasksInMemory) {
        boolean allNew = true;
        boolean allDone = true;
        List<Subtask> subtasks = new ArrayList<>();
        for (long subtaskId : getSubtasks()) {
            subtasks.add(subtasksInMemory.get(subtaskId));
        }
        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() != TaskStatus.NEW) {
                allNew = false;
            }
            if (subtask.getStatus() != TaskStatus.DONE) {
                allDone = false;
            }

        }
        if (allNew) {
            setStatus(TaskStatus.NEW);
        } else if (allDone) {
            setStatus(TaskStatus.DONE);
        } else {
            setStatus(TaskStatus.IN_PROGRESS);
        }

    }

    @Override
    public String toString() {
        return "EpicTask{" +
                "subtasks=" + subtasks +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
