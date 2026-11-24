package com.jpahibernate.example.hospital_management_db.controller;


import com.jpahibernate.example.hospital_management_db.model.Doctor;
import com.jpahibernate.example.hospital_management_db.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){ // Req body - it is used to take input from UI or postman for only complete class input
        String response = doctorService.saveDoctor(doctor);
        return response;
    }

    @GetMapping("/findAll")
    public List<Doctor> findAllDoctors(){
        List<Doctor> doctorList = doctorService.findAllDoctors();
        return doctorList;
    }

    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor = doctorService.findDoctorById(id);
         return doctor;
    }

}
