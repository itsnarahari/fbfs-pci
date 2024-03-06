package com.fbfs.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "default_delivery_method")
    Long defaultDeliveryMethod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Emails> emails;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Phones> phones;

    @Column(name = "created_on")
    @CreatedDate
    LocalDateTime createdOn;

    @Column(name = "updated_on")
    @LastModifiedDate
    LocalDateTime updatedOn;

}
