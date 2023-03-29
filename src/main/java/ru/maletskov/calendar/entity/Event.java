package ru.maletskov.calendar.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "calendar_event")
public class Event {


    @DynamoDBRangeKey
    private UUID id;

    @DynamoDBHashKey
    private UUID userId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private ZonedDateTime startDateTime;

    @DynamoDBAttribute
    private ZonedDateTime endDateTime;

    @DynamoDBAttribute
    private Boolean allDayEvent;

    @DynamoDBAttribute
    private String description;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private EventType type;

    @DynamoDBAttribute
    private UUID organizer;
}
