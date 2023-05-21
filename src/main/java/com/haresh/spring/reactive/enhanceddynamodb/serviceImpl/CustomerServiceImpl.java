package com.haresh.spring.reactive.enhanceddynamodb.serviceImpl;

import com.haresh.spring.reactive.enhanceddynamodb.Result;
import com.haresh.spring.reactive.enhanceddynamodb.model.Address;
import com.haresh.spring.reactive.enhanceddynamodb.model.Customer;
import com.haresh.spring.reactive.enhanceddynamodb.service.CustomerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl() {
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Customer with requested id.
     */
    @Override
    public Mono<Customer> getCustomerFromCustomerId(String customerId) {
        return null;
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Address of the customer.
     */
    @Override
    public Mono<Address> getCustomerAddress(String customerId) {
        return null;
    }

    /**
     * @return List of all the customers.
     */
    @Override
    public Flux<Customer> getCustomerList() {
        return null;
    }

    /**
     * @param customer Customer object.
     * @return Result of the customer creation.
     */
    @Override
    public Mono<Result> createNewCustomer(Customer customer) {
        return null;
    }

    /**
     * @param customer Customer object.
     * @return Result of the customer updation or creation.
     */
    @Override
    public Mono<Result> updateExistingOrCreateCustomer(Customer customer) {
        return null;
    }

    /**
     * @param customer Customer object.
     * @return Result of the customer updation.
     */
    @Override
    public Mono<Result> updateExistingCustomer(Customer customer) {
        return null;
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Result of the customer deletion.
     */
    @Override
    public Mono<Result> deleteCustomerByCustomerId(String customerId) {
        return null;
    }
}
