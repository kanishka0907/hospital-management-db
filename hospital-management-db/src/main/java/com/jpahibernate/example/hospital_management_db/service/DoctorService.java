package com.jpahibernate.example.hospital_management_db.service;


import com.jpahibernate.example.hospital_management_db.model.Doctor;
import com.jpahibernate.example.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains the business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!";
    }

    public List<Doctor> findAllDoctors(){
       List<Doctor> doctorList = doctorRepository.findAll();
       return doctorList;
    }

    public Doctor findDoctorById(int id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        }else{
            return null;
        }

    }
}
