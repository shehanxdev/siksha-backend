package com.HEC.siksha.repository;

import com.HEC.siksha.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    public Optional<Student> findById(String id);
}
