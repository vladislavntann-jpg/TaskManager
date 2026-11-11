package entity;

public class Subtask extends Task {

    private final Long parentId;


    public Subtask(String name, String description, Long parentId) {
        super(name, description);
        this.parentId = parentId;
    }
    public Subtask(Long id, String name, String description, Long parentId) {
        super(id, name, description);
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
