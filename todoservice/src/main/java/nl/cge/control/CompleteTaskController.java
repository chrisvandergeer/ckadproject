package nl.cge.control;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import nl.cge.entitiy.Task;

@Dependent
public class CompleteTaskController {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void completeTask(String taskId) {
        Task task = em.find(Task.class, UUID.fromString(taskId));
        if (task != null) {
            task.setCompleted(LocalDate.now());
            em.merge(task);
        }
    }

}
