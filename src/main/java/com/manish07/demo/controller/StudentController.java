package com.manish07.demo.controller;

import com.manish07.demo.model.Student;
import com.manish07.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getData(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> saveData(@RequestBody Student student){
        service.saveData(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateData(@PathVariable Long id ,
                                              @RequestBody Student student){
        service.updateEntry(id,student);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Student> deleteData(@PathVariable Long id){
        Student student = service.findById(id);
        if(student!=null) {
            service.removeEntry(student);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
