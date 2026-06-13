package nl.cge.control;

import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Dependent
public class DeleteCompletedTasksController {

    @PersistenceContext
    EntityManager em;
    
    @Transactional
    public void deleteCompletedTasks() {
        em.createQuery("DELETE FROM Task t WHERE t.completed IS NOT NULL").executeUpdate();
    }


}
