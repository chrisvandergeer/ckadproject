package nl.cge.control;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import nl.cge.entitiy.Task;
import nl.cge.model.CreateTaskCommand;
import nl.cge.model.TaskView;

@Dependent
public class CreateTaskController {

    @PersistenceContext
    EntityManager em;

    @Inject
    TaskMapper taskMapper;

    @Transactional
    public TaskView createTask(CreateTaskCommand createTaskCommand) {
        Task task = taskMapper.map(createTaskCommand);
        em.persist(task);
        return taskMapper.map(task);
    }

}
