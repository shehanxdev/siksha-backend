package com.HEC.siksha.controller;

import com.HEC.siksha.model.StudentInquiry;
import com.HEC.siksha.service.StudentInquiryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/student-inquiries")
public class StudentInquiryController {

    @Autowired
    private StudentInquiryService studentInquiryService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Health Check Complete";
    }
    @PostMapping
    public ResponseEntity<?> createStudentInquiry(@RequestBody StudentInquiry studentInquiry) {
        studentInquiryService.createStudentInquiry(studentInquiry);
        return ResponseEntity.ok("Inquiry Added");
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<StudentInquiry>> getAllStudentInquiries() {
        List<StudentInquiry> inquiries = studentInquiryService.getAllStudentInquiries();
        return ResponseEntity.ok(inquiries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentInquiry> getStudentInquiryById(@PathVariable String id) {
        StudentInquiry studentInquiry = studentInquiryService.getStudentInquiryById(id);
        if (studentInquiry != null) {
            return ResponseEntity.ok(studentInquiry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentInquiry(@PathVariable String id, @RequestBody StudentInquiry studentInquiry) {
        studentInquiry.setId(new ObjectId(id));
        studentInquiryService.updateStudentInquiry(studentInquiry);
        return ResponseEntity.ok().build();
    }

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
