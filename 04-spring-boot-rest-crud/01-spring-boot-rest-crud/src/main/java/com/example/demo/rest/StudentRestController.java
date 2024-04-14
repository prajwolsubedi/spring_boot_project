package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data --- called only once when it's given bean is constructed
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Prajwol", "subedi"));
        theStudents.add(new Student("Sahin", "rai"));
        theStudents.add(new Student("Pranim", "thakuri"));
    }

    //define endpoint for /students - return all of the students we have

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //endpoint for /students/{studentId}

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check the student id against the list size
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

}
