package com.HEC.siksha.repository;


import com.HEC.siksha.model.StudentInquiry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentInquiryRepository extends MongoRepository<StudentInquiry, String> {

}
