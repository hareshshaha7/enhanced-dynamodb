package com.haresh.spring.reactive.enhanceddynamodb.service;

import com.haresh.spring.reactive.enhanceddynamodb.Result;
import com.haresh.spring.reactive.enhanceddynamodb.model.Address;
import com.haresh.spring.reactive.enhanceddynamodb.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Customer Service Interface
 */
public interface CustomerService {

    /**
     * @param customerId Identifier for the customer.
     * @return Customer with requested id.
     */
    Mono<Customer> getCustomerFromCustomerId(String customerId);

    /**
     * @param customerId Identifier for the customer.
     * @return Address of the customer.
     */
    Mono<Address> getCustomerAddress(String customerId);

    /**
     * @return List of all the customers.
     */
    Flux<Customer> getCustomerList();

    /**
     * @param customer Customer object.
     * @return Result of the customer creation.
     */
    Mono<Result> createNewCustomer(Customer customer);

    /**
     * @param customer Customer object.
     * @return Result of the customer updation or creation.
     */
    Mono<Result> updateExistingOrCreateCustomer(Customer customer);

    /**
     * @param customer Customer object.
     * @return Result of the customer updation.
     */
    Mono<Result> updateExistingCustomer(Customer customer);

    /**
     * @param customerId Identifier for the customer.
     * @return Result of the customer deletion.
     */
    Mono<Result> deleteCustomerByCustomerId(String customerId);
}
