package com.app.dashboard.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
@Document
public class User {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String email;
    private String password;
    private String cityId;
    private Boolean state;
    private String countryId;
    private String occupation;
    private String phoneNumber;
    private ArrayList<String> transactions;
    private String role;

    public User(String id, String name, String email, String password, String cityId, Boolean state, String countryId,
                String occupation, String phoneNumber, ArrayList<String> transactions, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cityId = cityId;
        this.state = state;
        this.countryId = countryId;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.transactions = transactions;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCityId() {
        return cityId;
    }

    public Boolean getState() {
        return state;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public String getRole() {
        return role;
    }
}