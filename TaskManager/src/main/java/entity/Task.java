package entity;


import util.Counter;

public class Task {
    protected String name;
    protected String description;

    protected final Long id;
    protected TaskStatus status;


    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = Counter.generateId();
        this.status = TaskStatus.NEW;

    }
    public Task(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NEW;

    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
