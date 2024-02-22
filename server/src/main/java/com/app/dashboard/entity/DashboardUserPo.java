package com.app.dashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DashboardUserPo {

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
}
