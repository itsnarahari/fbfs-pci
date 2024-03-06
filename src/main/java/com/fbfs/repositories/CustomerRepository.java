package com.fbfs.repositories;

import com.fbfs.dto.CustomerAndEmailAndPhone;
import com.fbfs.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select new com.fbfs.dto.CustomerAndEmailAndPhone(c.id, c.name, e.email, p.phone) from Customer c " +
            "join Emails e on e.id=c.id JOIN Phones p on p.id=c.id where c.id=:customerId")
    public List<CustomerAndEmailAndPhone> getCustomerByJpaQuery(@Param("customerId") Long id);
 }
