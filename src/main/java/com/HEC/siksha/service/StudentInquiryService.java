package com.HEC.siksha.service;


import com.HEC.siksha.model.StudentInquiry;
import com.HEC.siksha.repository.StudentInquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInquiryService {
    @Autowired
    private StudentInquiryRepository studentInquiryRepository;

    public List<StudentInquiry> getAllStudentInquiries() {
        return studentInquiryRepository.findAll();
    }

    public StudentInquiry getStudentInquiryById(String id) {
        return studentInquiryRepository.findById(id).orElse(null);
    }

    public StudentInquiry createStudentInquiry(StudentInquiry studentInquiry) {
        return studentInquiryRepository.save(studentInquiry);
    }

    public StudentInquiry updateStudentInquiry( StudentInquiry studentInquiry) {
        StudentInquiry existingStudentInquiry = studentInquiryRepository.findById(studentInquiry.getId().toString()).orElse(null);
        System.out.println(studentInquiry.getName());
        if (existingStudentInquiry != null) {
            existingStudentInquiry.setName(studentInquiry.getName());
            existingStudentInquiry.setStudentId(studentInquiry.getStudentId());
            existingStudentInquiry.setInquiryType(studentInquiry.getInquiryType());
            existingStudentInquiry.setSubject(studentInquiry.getSubject());
            existingStudentInquiry.setEmail(studentInquiry.getEmail());
            existingStudentInquiry.setContactNo(studentInquiry.getContactNo());
            existingStudentInquiry.setMessage(studentInquiry.getMessage());
            return studentInquiryRepository.save(existingStudentInquiry);
        }
        return null;
    }

    public void deleteStudentInquiry(String id) {
        studentInquiryRepository.deleteById(id);
    }
}
