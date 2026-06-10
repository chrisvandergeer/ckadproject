package nl.cge.auditservice.control;

import jakarta.enterprise.context.Dependent;
import nl.cge.auditservice.entity.Audittrail;
import nl.cge.model.AuditRecord;

@Dependent
public class AudittrailMapper {

    public Audittrail map(AuditRecord auditRecord) {
        Audittrail audittrail = new Audittrail();
        audittrail.setApplicatienaam(auditRecord.getApplicationname());
        audittrail.setApplicatiefunctie(auditRecord.getApplicationfunction());
        audittrail.setUsername(auditRecord.getUsername());
        return audittrail;
    }
}
