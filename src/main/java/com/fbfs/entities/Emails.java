package com.fbfs.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="emails")
public class Emails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String verified;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    Customer customer;

    @Column(name = "created_on")
    @CreatedDate
    LocalDateTime createdOn;

    @Column(name = "updated_on")
    @LastModifiedDate
    LocalDateTime updatedOn;

}
