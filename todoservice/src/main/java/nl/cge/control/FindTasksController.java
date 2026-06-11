package nl.cge.control;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nl.cge.entitiy.Task;
import nl.cge.model.TaskView;

@Dependent
public class FindTasksController {

    @PersistenceContext
    EntityManager em;

    @Inject
    TaskMapper taskMapper;

    public List<TaskView> getTasks() {
        List<Task> tasks = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        return tasks.stream().map(task -> taskMapper.map(task)).toList();
    }

     public List<TaskView> getCompletedTasks() {
        List<Task> tasks = em.createQuery("SELECT t FROM Task t WHERE t.completed IS NOT NULL", Task.class).getResultList();
        return tasks.stream().map(task -> taskMapper.map(task)).toList();
    }

}
