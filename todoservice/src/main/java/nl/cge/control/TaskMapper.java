package nl.cge.control;

import java.time.LocalDate;

import jakarta.enterprise.context.Dependent;
import nl.cge.entitiy.Task;
import nl.cge.model.CreateTaskCommand;
import nl.cge.model.TaskView;

@Dependent
public class TaskMapper {

    public Task map(CreateTaskCommand createTaskCommand) {
        Task task = new Task();
        task.setTaskName(createTaskCommand.getTaskName());
        task.setStartDate(createTaskCommand.getStartDate() == null ? LocalDate.now() : createTaskCommand.getStartDate());
        task.setDueDate(createTaskCommand.getDueDate());
        return task;
    }

    public TaskView map(Task task) {
        TaskView taskView = new TaskView();
        taskView.setId(task.getId().toString());
        taskView.setTaskName(task.getTaskName());
        taskView.setStartDate(task.getStartDate());
        taskView.setDueDate(task.getDueDate());
        taskView.setCompleted(task.getCompleted());
        return taskView;
    }

}
