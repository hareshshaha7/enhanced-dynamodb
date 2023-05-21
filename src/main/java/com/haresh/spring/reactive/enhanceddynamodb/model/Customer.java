package com.haresh.spring.reactive.enhanceddynamodb.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String ContactNumber;
    private Address address;
    private String createdTimeStamp;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("customerId")
    public String getCustomerId() {
        return customerId;
    }

    @DynamoDbAttribute("customerFirstName")
    public String getFirstName() {
        return firstName;
    }

    @DynamoDbAttribute("customerLastName")
    public String getLastName() {
        return lastName;
    }

    @DynamoDbAttribute("customerContactNumber")
    public String getContactNumber() {
        return ContactNumber;
    }

    @DynamoDbAttribute("customerAddress")
    public Address getAddress() {
        return address;
    }

    @DynamoDbAttribute("customerCreatedTime")
    public String getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCreatedTimeStamp(String createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
}
