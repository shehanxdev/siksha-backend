package com.HEC.siksha.controller;

import com.HEC.siksha.model.Student;
import com.HEC.siksha.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    //fake comment
    private Student student;
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/login")
    public Student studentLogin(@RequestBody Map<String,String> requestBody){
       Optional<Student> optionalStudent=studentRepository.findById(requestBody.get("email"));
       if(optionalStudent.isPresent()){
           return optionalStudent.get();
       }
       else{
           return new Student("","","","","","","","","");

       }
    }

    @GetMapping("/health")
    public String healthCheck(){
        return "Health Check Complete";
    }
}
