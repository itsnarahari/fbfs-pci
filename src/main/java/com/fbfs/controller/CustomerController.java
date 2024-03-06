package com.fbfs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fbfs.configs.CustomerException;
import com.fbfs.dto.CustomerDto;
import com.fbfs.dto.EmailsDto;
import com.fbfs.entities.Customer;
import com.fbfs.entities.Emails;
import com.fbfs.repositories.CustomerRepository;
import com.fbfs.repositories.EmailRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailRepositories emailRepositories;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        customer = customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCustomerById(@PathVariable(name = "id") Long id){
        Customer customer=customerRepository.findById(id)
                .orElseThrow(()->new CustomerException("Customer not found by Id: %d".formatted(id), HttpStatus.NOT_FOUND.value()));
        return ResponseEntity.ok(objectMapper.convertValue(customer, CustomerDto.class));
    }

    @GetMapping(value = "/customer/getEmailObjByEmailId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmailByEmailId(@PathVariable(name = "id") Long id){
        Emails emails=emailRepositories.findById(id)
                .orElseThrow(()->new CustomerException("Email not found with Id: %d".formatted(id), HttpStatus.NOT_FOUND.value()));
        return ResponseEntity.ok(objectMapper.convertValue(emails, EmailsDto.class));
    }
}
