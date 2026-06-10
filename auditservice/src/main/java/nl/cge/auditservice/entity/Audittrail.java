package nl.cge.auditservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Audittrail {

    @Id
    private UUID id =  UUID.randomUUID();

    private String applicatienaam;

    private String applicatiefunctie;

    private String username;

    public UUID getId() {
        return id;
    }

    public String getApplicatienaam() {
        return applicatienaam;
    }

    public void setApplicatienaam(String applicatienaam) {
        this.applicatienaam = applicatienaam;
    }

    public String getApplicatiefunctie() {
        return applicatiefunctie;
    }

    public void setApplicatiefunctie(String applicatiefunctie) {
        this.applicatiefunctie = applicatiefunctie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
