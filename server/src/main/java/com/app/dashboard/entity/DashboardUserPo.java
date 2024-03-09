package com.app.dashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DashboardUserPo {

    @MongoId
    private String userId;
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
}
