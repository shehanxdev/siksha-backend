package com.HEC.siksha.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "studentInquiries")
public class StudentInquiry {

    @Id
    private ObjectId id;

    private String name;
    private String studentId;
    private String inquiryType;
    private String subject;
    private String email;
    private String contactNo;
    private String message;

    public StudentInquiry() {}

    public StudentInquiry(String name, String studentId, String inquiryType, String subject, String email, String contactNo, String message) {
        this.name = name;
        this.studentId = studentId;
        this.inquiryType = inquiryType;
        this.subject = subject;
        this.email = email;
        this.contactNo = contactNo;
        this.message = message;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
