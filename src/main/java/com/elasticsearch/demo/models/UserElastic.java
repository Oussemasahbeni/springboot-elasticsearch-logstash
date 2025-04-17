package com.elasticsearch.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "users")
public class UserElastic {

    @Id
    @Field(type = FieldType.Text, name = "name")
    private String userId;

    @Field(type = FieldType.Text, name = "username")
    private String username;

    @Field(type = FieldType.Text, name = "user_email")
    private String userEmail;

    @Field(type = FieldType.Text, name = "user_first_name")
    private String userFirstName;

    @Field(type = FieldType.Text, name = "user_last_name")
    private String userLastName;

    @Field(type = FieldType.Date, name = "user_birthdate")
    private Date userBirthdate;
}
