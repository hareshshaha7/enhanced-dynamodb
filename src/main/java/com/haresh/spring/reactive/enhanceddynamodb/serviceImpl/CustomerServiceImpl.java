package com.haresh.spring.reactive.enhanceddynamodb.serviceImpl;

import com.haresh.spring.reactive.enhanceddynamodb.Result;
import com.haresh.spring.reactive.enhanceddynamodb.dao.CustomerRepository;
import com.haresh.spring.reactive.enhanceddynamodb.model.Address;
import com.haresh.spring.reactive.enhanceddynamodb.model.Customer;
import com.haresh.spring.reactive.enhanceddynamodb.service.CustomerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Objects;
import java.util.function.LongSupplier;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final LongSupplier getEpocSecond = () -> Instant.now().getEpochSecond();

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Customer with requested id.
     */
    @Override
    public Mono<Customer> getCustomerFromCustomerId(String customerId) {
        return Mono.fromFuture(repository.getCustomerByID(customerId))
                .doOnSuccess(Objects::requireNonNull)
                .onErrorReturn(new Customer());
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Address of the customer.
     */
    @Override
    public Mono<Address> getCustomerAddress(String customerId) {
        return null;
//        return Mono.from(repository.getCustomerAddress(customerId))
//                .map(Customer::getAddress)
//                .doOnSuccess(Objects::requireNonNull)
//                .onErrorReturn(new Address());
    }

    /**
     * @return List of all the customers.
     */
    @Override
    public Flux<Customer> getCustomerList() {
        return Flux.from(repository.getAllCustomer().items())
                .onErrorReturn(new Customer());
    }

    /**
     * @param customer Customer object.
     * @return Result of the customer creation.
     */
    @Override
    public Mono<Result> createNewCustomer(Customer customer) {
        customer.setCreatedTimeStamp(String.valueOf(getEpocSecond.getAsLong()));
        return Mono.fromFuture(repository.save(customer))
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }

    /**
     * @param customer Customer object.
     * @return Result of the customer updation or creation.
     */
    @Override
    public Mono<Result> updateExistingOrCreateCustomer(Customer customer) {
        return Mono.fromFuture(repository.getCustomerByID(customer.getCustomerId()))
                .doOnSuccess(Objects::requireNonNull)
                .doOnNext(__ -> repository.updateCustomer(customer))
                .doOnNext(Objects::requireNonNull)
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }

    /**
     * @param customer Customer object.
     * @return Result of the customer updation.
     */
    @Override
    public Mono<Result> updateExistingCustomer(Customer customer) {
        return Mono.fromFuture(repository.updateCustomer(customer))
                .doOnSuccess(Objects::requireNonNull)
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Result of the customer deletion.
     */
    @Override
    public Mono<Result> deleteCustomerByCustomerId(String customerId) {
        return Mono.fromFuture(repository.deleteCustomerById(customerId))
                .doOnSuccess(Objects::requireNonNull)
                .thenReturn(Result.SUCCESS)
                .onErrorReturn(Result.FAIL);
    }
}
