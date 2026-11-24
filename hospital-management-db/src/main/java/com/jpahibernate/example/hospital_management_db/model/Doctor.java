package com.jpahibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // it represents that this class is entity  or a model class which is directly creating database table or schema
@Table(name = "doctor") // it will create a table inside database with name given
@Data // add getter and setter
@AllArgsConstructor // parameterized constructor
@NoArgsConstructor // default constructor
public class Doctor {

    @Id // it is the primary key of the table - it will be unique and not null
    @Column(name = "id") // it will create column in the database table
    private int id; //primary key cannot be null,unique key can be null

    @Column(name = "doctor_name",nullable = false) // nullable=false it cannot contain null value
    private String name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "specialization",nullable = false) // unique=true cannot contain duplicate value.
    private String specialization;

    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name = "mobile_no",nullable = false,unique = true)
    private String mobile;
}

