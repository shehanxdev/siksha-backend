package com.HEC.siksha.controller;

import com.HEC.siksha.model.StudentInquiry;
import com.HEC.siksha.service.StudentInquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/student-inquiries")
public class AdminInquiryController {
    private StudentInquiryService studentInquiryService;
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
}
