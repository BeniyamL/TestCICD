package com.crudapi.rest_api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crudapi.rest_api.Models.Student;
import com.crudapi.rest_api.Repository.StudentRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class ApiController {
    
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello, Welcome to Rest Api, test";
    }

    
    @GetMapping(value =  "/getStudent")
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @PostMapping(value = "/student")
    public String insertStudent(@RequestBody Student std){
        studentRepo.save(std);
        return "Student Inserted Successfully";
    }

    @PutMapping(value = "/student/{id}")
    public String updateStudent(@PathVariable long id, @RequestBody Student std){
        Student sd = studentRepo.findById(id).get();
        sd.setFirstName(std.getFirstName());
        sd.setLastName(std.getLastName());
        sd.setAge(std.getAge());
        sd.setJob(std.getJob());
        studentRepo.save(sd);
        return "Student Updated Successfully";
    }

    @DeleteMapping(value = "/student/{id}")
    public String deleteStudent(@PathVariable long id){
        Student sd = studentRepo.findById(id).get();
        studentRepo.delete(sd);
        return "Student deleted successfully";
    }
}
