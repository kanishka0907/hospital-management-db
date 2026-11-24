package com.jpahibernate.example.hospital_management_db.repository;

import com.jpahibernate.example.hospital_management_db.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //optional- it is the data layer and performs database operations
public interface DoctorRepository extends JpaRepository <Doctor,Integer>{ // Integer-Wrapper class datatype of the model class primary key
}
