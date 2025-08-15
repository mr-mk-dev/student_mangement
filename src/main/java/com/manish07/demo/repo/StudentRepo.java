package com.manish07.demo.repo;

import com.manish07.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Long> {

}
