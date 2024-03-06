package com.fbfs.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="NOTIFICATION_LOGS")
public class NotificationLogs {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "batch_id")
    private Long batchId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "delivery_method")
    private String deliveryMethod;

    @Column(name = "contact")
    private String contact;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

}
