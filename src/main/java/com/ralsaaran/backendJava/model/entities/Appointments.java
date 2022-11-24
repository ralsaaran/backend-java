package com.ralsaaran.backendJava.model.entities;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "APPOINTMENTS")
@Where(clause = "ACTIVITY = 1")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idNumber;
    private String name;
    private Date appointmentDate;
    private String cancelReason;
    private Date createdAt;
    private String createdBy;
    private Date modifiedAt;
    private String modifiedBy;
    private boolean activity;

}
