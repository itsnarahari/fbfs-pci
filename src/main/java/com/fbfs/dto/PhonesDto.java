package com.fbfs.dto;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class PhonesDto {

    Long id;
    String phone;
    String countryCode;
    String verified;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
}
