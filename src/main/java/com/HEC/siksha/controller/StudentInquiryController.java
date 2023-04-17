package com.HEC.siksha.controller;

import com.HEC.siksha.model.StudentInquiry;
import com.HEC.siksha.service.StudentInquiryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student/student-inquiries")
public class StudentInquiryController {

    @Autowired
    private StudentInquiryService studentInquiryService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/health")
    public String healthCheck(){
        return "Health Check Complete";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<?> createStudentInquiry(@RequestBody StudentInquiry studentInquiry) {
        studentInquiryService.createStudentInquiry(studentInquiry);
        return ResponseEntity.ok("Inquiry Added");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllStudentInquiries() {
        List<StudentInquiry> inquiries = studentInquiryService.getAllStudentInquiries();
        List<Map<String, Object>> response = inquiries.stream().map(inquiry -> {
            Map<String, Object> inquiryMap = new HashMap<>();
            inquiryMap.put("id", inquiry.getId().toString());
            inquiryMap.put("name", inquiry.getName());
            inquiryMap.put("studentId", inquiry.getStudentId());
            inquiryMap.put("inquiryType", inquiry.getInquiryType());
            inquiryMap.put("subject", inquiry.getSubject());
            inquiryMap.put("email", inquiry.getEmail());
            inquiryMap.put("contactNo", inquiry.getContactNo());
            inquiryMap.put("message", inquiry.getMessage());
            return inquiryMap;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<StudentInquiry> getStudentInquiryById(@PathVariable String id) {
        StudentInquiry studentInquiry = studentInquiryService.getStudentInquiryById(id);
        if (studentInquiry != null) {
            return ResponseEntity.ok(studentInquiry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentInquiry(@PathVariable String id, @RequestBody StudentInquiry studentInquiry) {
System.out.println(studentInquiry.getName());
   studentInquiry.setId(new ObjectId(id));
   studentInquiryService.updateStudentInquiry(studentInquiry);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentInquiry(@PathVariable(value = "id") String inquiryId) {
        try {
            studentInquiryService.deleteStudentInquiry(inquiryId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
