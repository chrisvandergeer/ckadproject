package nl.cge.boundary;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import nl.cge.api.TasksApi;
import nl.cge.model.CreateTask;

@ApplicationScoped
public class TaskResource implements TasksApi {

    @Override
    public void createTask(CreateTask createTask) {
        Log.info("Creating task: " + createTask);
    }
}
