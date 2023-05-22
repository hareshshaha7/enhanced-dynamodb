package com.haresh.spring.reactive.enhanceddynamodb.daoImpl;

import com.haresh.spring.reactive.enhanceddynamodb.dao.CustomerRepository;
import com.haresh.spring.reactive.enhanceddynamodb.model.Customer;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PagePublisher;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.concurrent.CompletableFuture;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final DynamoDbEnhancedAsyncClient enhancedAsyncClient;
    private final DynamoDbAsyncTable<Customer> asyncTable;

    public CustomerRepositoryImpl(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        this.enhancedAsyncClient = enhancedAsyncClient;
        this.asyncTable = enhancedAsyncClient.table(Customer.class.getSimpleName(), TableSchema.fromBean(Customer.class));
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Customer object.
     */
    @Override
    public CompletableFuture<Customer> getCustomerByID(String customerId) {
        return asyncTable.getItem(getKeyBuild(customerId));
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Customer address object.
     */
    @Override
    public PagePublisher<Customer> getCustomerAddress(String customerId) {
        return asyncTable.query(r -> r.queryConditional(QueryConditional.keyEqualTo(k -> k.partitionValue(customerId)))
                .addAttributeToProject("customerAddress"));
    }

    /**
     * @return All customer objects.
     */
    @Override
    public PagePublisher<Customer> getAllCustomer() {
        return asyncTable.scan();
    }

    /**
     * @param customer Customer object.
     * @return Void
     */
    @Override
    public CompletableFuture<Void> save(Customer customer) {
        return asyncTable.putItem(customer);
    }

    /**
     * @param customer Customer object.
     * @return Updated customer object.
     */
    @Override
    public CompletableFuture<Customer> updateCustomer(Customer customer) {
        return asyncTable.updateItem(customer);
    }

    /**
     * @param customerId Identifier for the customer.
     * @return Deleted customer object.
     */
    @Override
    public CompletableFuture<Customer> deleteCustomerById(String customerId) {
        return asyncTable.deleteItem(getKeyBuild(customerId));
    }

    private Key getKeyBuild(String customerId) {
        return Key.builder().partitionValue(customerId).build();
    }
}
