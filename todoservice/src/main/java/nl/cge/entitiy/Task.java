package nl.cge.entitiy;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {

    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    private String taskName;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate dueDate;
    private LocalDate completed;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDate getCompleted() {
        return completed;
    }
    public void setCompleted(LocalDate completed) {
        this.completed = completed;
    }

}
