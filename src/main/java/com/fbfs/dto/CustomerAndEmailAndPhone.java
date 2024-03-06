package com.fbfs.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerAndEmailAndPhone {

    private Long customerId;
    private String customerName;
    private String email;
    private String phone;
}
