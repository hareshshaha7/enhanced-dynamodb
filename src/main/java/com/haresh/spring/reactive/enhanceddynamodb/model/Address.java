package com.haresh.spring.reactive.enhanceddynamodb.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Address {
    private String city;

    private String state;

    private String country;

    @DynamoDbAttribute("city")
    public String getCity() {
        return city;
    }

    @DynamoDbAttribute("state")
    public String getState() {
        return state;
    }

    @DynamoDbAttribute("country")
    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
