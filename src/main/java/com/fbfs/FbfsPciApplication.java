package com.fbfs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fbfs.dto.CustomerAndEmailAndPhone;
import com.fbfs.dto.CustomerDto;
import com.fbfs.entities.Customer;
import com.fbfs.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class FbfsPciApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FbfsPciApplication.class, args);
	}

	@Autowired
	EntityManager entityManager;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public void run(String... args) throws Exception {

		// Criteria builder
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<Customer> users = query.from(Customer.class);
		query.select(users.get("name"));
		List<String> resultList = entityManager.createQuery(query).getResultList();
		System.out.println("CriteriaBuilder");
		System.out.println(resultList);

		// JPQL query by Id and Joins
		Query query2 = entityManager.createQuery("select " +
						"c.id as customerId, c.name as customerName, e.email as email, p.phone as phone " +
						"from Customer c join Emails e on e.id=c.id JOIN Phones p on p.id=c.id where " +
						"c.id=:customerId", CustomerAndEmailAndPhone.class)
				.setParameter("customerId",101L);

		resultList = query2.getResultList();
		System.out.println("--------------------------------");
		System.out.println("Simple JPA Query with HQL");
		System.out.println(resultList);


		System.out.println("--------------------------------");
		// createNativeQuery
		Query query3 = entityManager.createNativeQuery("select c.id,c.name, c.default_delivery_method as " +
				"defaultDeliveryMethod from customer c", CustomerDto.class);
        resultList = query3.getResultList();
		System.out.println("Native Query example");
        System.out.println(resultList);


		System.out.println("--------------------------------");
		System.out.println("Customer JPA Query with HQL By ID and custom DTO");
		System.out.println(customerRepository.getCustomerByJpaQuery(100L));



		System.out.println("--------------------------------");
		// JpaRepository query
		Customer customer = customerRepository.findById(102L).get();
		System.out.println("Get Customer and associated entities object By customer Id ");
		System.out.println(customer);

		System.out.println("--------------------------------");
		System.out.println("Get Customer and associated entities object by Id with EntityManager");

		Query query5 = entityManager.createQuery("FROM Customer c WHERE c.id =:customerId")
				.setParameter("customerId",101L);
		resultList = query5.getResultList();
		List list = objectMapper.convertValue(resultList, List.class);
		System.out.println(list);

	}
}
