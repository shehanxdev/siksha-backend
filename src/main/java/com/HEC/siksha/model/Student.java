package com.HEC.siksha.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentRegistration")
public class Student {

    @Id
    private String id;

    private String studentname;

    private String school;

    private String stream;

    private String nic;

    private String dob;

    private String gender;

    private String phone;

    private String address;

    private String email;

    // Constructors

    public Student() {
    }

    public Student(String studentname, String school, String stream, String nic, String dob, String gender, String phone, String address, String email) {
        this.studentname = studentname;
        this.school = school;
        this.stream = stream;
        this.nic = nic;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentname;
    }

    public void setStudentame(String studentname) {
        this.studentname = studentname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
