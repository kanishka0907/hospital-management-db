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

    public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "Total doctors present are : "+totalCount;
    }

    public String deleteDoctorById(int id){
        Doctor existingDoctor = findDoctorById(id);
        if(existingDoctor!=null) {
            doctorRepository.deleteById(id);
            return " Doctor with id : "+id+" got deleted successfully!";
        }else{
            return " Doctor with id : "+id+" not present,hence cannot delete!";
        }
    }

    //update using put operation - updates the complete object
    public String updateDoctorUsingPut(int doctorId, Doctor newDoctorRequest){
        Doctor existingDoctor = findDoctorById(doctorId);
        if(existingDoctor!=null){
            doctorRepository.save(newDoctorRequest);
            return "Doctor with id : "+doctorId+" updated successfully!";
        }else{
            return "Doctor with id : "+doctorId+" is not present,hence cannot be updated!";

        }
    }

    //update using patch operation - updates single specific fields

    public String updateDoctorUsingPatch(int doctorId,String newEmail,String newMobile){
        Doctor existingDoctor = findDoctorById(doctorId);
        if(existingDoctor!=null){
            existingDoctor.setEmail(newEmail);
            existingDoctor.setMobile(newMobile);
            doctorRepository.save(existingDoctor);
            return "Doctor with id : "+doctorId+" updated successfully!";
        }else{
            return "Doctor with id : "+doctorId+" is not present,hence cannot be updated!";

        }
    }

}
