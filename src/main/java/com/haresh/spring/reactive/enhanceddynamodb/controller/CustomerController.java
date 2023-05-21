package com.haresh.spring.reactive.enhanceddynamodb.controller;

import com.haresh.spring.reactive.enhanceddynamodb.Result;
import com.haresh.spring.reactive.enhanceddynamodb.model.Address;
import com.haresh.spring.reactive.enhanceddynamodb.model.Customer;
import com.haresh.spring.reactive.enhanceddynamodb.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CutomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Mono<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        return customerService.getCustomerFromCustomerId(customerId);
    }

    @GetMapping("address/{customerId}")
    public Mono<Address> getCustomerAddress(@PathVariable("customerId") String customerId) {
        return customerService.getCustomerAddress(customerId);
    }

    @GetMapping("all")
    public Flux<Customer> getAllCustomers() {
        return customerService.getCustomerList();
    }

    @PostMapping("/save")
    public Mono<Result> saveCustomer(@RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @PutMapping("/updateOrCreate")
    public Mono<Result> updateOrCretaeCustomer(@RequestBody Customer customer) {
        return customerService.updateExistingOrCreateCustomer(customer);
    }

    @PutMapping("/update")
    public Mono<Result> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateExistingCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public Mono<Result> deleteCustomer(@PathVariable("customerId") String customerId) {
        return customerService.deleteCustomerByCustomerId(customerId);
    }

}
