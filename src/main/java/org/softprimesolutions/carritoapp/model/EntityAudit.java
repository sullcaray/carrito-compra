package org.softprimesolutions.carritoapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.softprimesolutions.carritoapp.enums.Status;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EqualsAndHashCode
public abstract class EntityAudit {

    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @Column(name = "created_by", nullable = false, length = 12, updatable = false)
    private String createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 12)
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }

        if (this.updatedAt == null) {
            this.updatedAt = LocalDateTime.now();
        }

        if (this.status == null) {
            this.status = Status.ACTIVE.getCode();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
