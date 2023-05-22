package com.haresh.spring.reactive.enhanceddynamodb.dao;

import com.haresh.spring.reactive.enhanceddynamodb.model.Customer;
import software.amazon.awssdk.enhanced.dynamodb.model.PagePublisher;

import java.util.concurrent.CompletableFuture;

/**
 *
 */
public interface CustomerRepository {

    /**
     *
     * @param customerId Identifier for the customer.
     * @return Customer object.
     */
    CompletableFuture<Customer> getCustomerByID(String customerId);

    /**
     *
     * @param customerId Identifier for the customer.
     * @return Customer address object.
     */
    PagePublisher<Customer> getCustomerAddress(String customerId);

    /**
     *
     * @return All customer objects.
     */
    PagePublisher<Customer> getAllCustomer();

    /**
     *
     * @param customer Customer object.
     * @return Void
     */
    CompletableFuture<Void> save(Customer customer);

    /**
     *
     * @param customer Customer object.
     * @return Updated customer object.
     */
    CompletableFuture<Customer> updateCustomer(Customer customer);

    /**
     *
     * @param customerId Identifier for the customer.
     * @return Deleted customer object.
     */
    CompletableFuture<Customer> deleteCustomerById(String customerId);

}
