package com.fbfs.dto;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class EmailsDto {

    Long id;
    String email;
    String verified;
    CustomerDto customer;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
