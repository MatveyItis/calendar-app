package ru.maletskov.calendar.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "user_data")
public class User {
    @DynamoDBHashKey
    private UUID id;

    @DynamoDBAttribute
    private String username;

    @DynamoDBAttribute
    private LocalDate birthday;

    @DynamoDBAttribute
    private String hashPassword;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private Boolean googleLogin;

    @DynamoDBAttribute
    private ZonedDateTime createdTime;

}
