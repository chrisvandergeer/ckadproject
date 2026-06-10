package nl.cge.auditservice.control;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import nl.cge.auditservice.entity.Audittrail;
import nl.cge.model.AuditRecord;

@Dependent
public class AuditServiceController {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    AudittrailMapper audittrailMapper;

    @Transactional
    public void verwerkAuditEvent(AuditRecord auditRecord) {
        Audittrail audittrail = audittrailMapper.map(auditRecord);
        entityManager.persist(audittrail);
    }
}
