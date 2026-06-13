package nl.cge.boundary;

import java.util.List;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import nl.cge.api.TasksApi;
import nl.cge.control.CompleteTaskController;
import nl.cge.control.CreateTaskController;
import nl.cge.control.DeleteCompletedTasksController;
import nl.cge.control.FindTasksController;
import nl.cge.model.CreateTaskCommand;
import nl.cge.model.TaskView;

@ApplicationScoped
public class TaskResource implements TasksApi {

    @Inject
    CreateTaskController taskController;

    @Inject
    CompleteTaskController completeTaskController;

    @Inject
    FindTasksController findTasksController;

    @Inject
    DeleteCompletedTasksController deleteCompletedTasksController;

    @Override
    public TaskView createTask(CreateTaskCommand createTaskCommand) {
        Log.infov("Creating task: {0}", createTaskCommand);
        return taskController.createTask(createTaskCommand);
    }

    @Override
    public void completeTask(String taskId) {
        Log.infov("Completing task: {0}", taskId);
        completeTaskController.completeTask(taskId);
    }

    @Override
    public List<TaskView> getCompletedTasks() {
        Log.info("Get all completed tasks");
        return findTasksController.getCompletedTasks();
    }

    @Override
    public List<TaskView> getTasks() {
        Log.info("Get all tasks");
        return findTasksController.getTasks();
    }

    @Override
    public void deleteCompletedTasks() {
        Log.info("Deleting completed tasks");
        deleteCompletedTasksController.deleteCompletedTasks();
    }

}