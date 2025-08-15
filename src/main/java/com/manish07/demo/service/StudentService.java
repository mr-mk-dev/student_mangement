package com.manish07.demo.service;

import com.manish07.demo.model.Student;
import com.manish07.demo.repo.StudentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    private StudentRepo studentRepo ;

    public boolean saveData(Student student){
        studentRepo.save(student);
        return true;
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    public Student findById(Long id ){
        return studentRepo.findById(id).orElse(null);
    }

    public void removeEntry(Student student){
        studentRepo.delete(student);
    }

    public boolean updateEntry(Long id, Student student){
        Student studentDB = studentRepo.findById(id).orElse(null) ;
        if(studentDB != null){
            studentDB.setName(student.getName() == null && student.getName().equals("") ? studentDB.getName() : student.getName());
            studentDB.setAge(student.getAge());
            studentDB.setCourse(student.getCourse());
            studentRepo.save(studentDB);
            return true;
        }
        return false;
    }
}
