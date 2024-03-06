package com.fbfs.dto;

import com.fbfs.entities.Emails;
import com.fbfs.entities.Phones;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    Long id;
    String name;
    Long defaultDeliveryMethod;

    public CustomerDto(Long id, String name, Long defaultDeliveryMethod) {
        this.id = id;
        this.name = name;
        this.defaultDeliveryMethod = defaultDeliveryMethod;
    }

    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    List<Emails> emails;
    List<Phones> phones;



}
