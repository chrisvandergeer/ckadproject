package nl.cge.auditservice.boundary;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import nl.cge.api.AuditsApi;
import nl.cge.auditservice.control.AuditServiceController;
import nl.cge.model.AuditRecord;

@ApplicationScoped
public class AuditServiceBoundary implements AuditsApi {

    @Inject
    AuditServiceController auditServiceController;

    @Override
    public void createAudit(AuditRecord auditRecord) {
        Log.infof("Creating audit record %s", auditRecord);
        auditServiceController.verwerkAuditEvent(auditRecord);
    }
}


