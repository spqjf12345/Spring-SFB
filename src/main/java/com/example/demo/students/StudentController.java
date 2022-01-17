package com.example.demo.students;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
	public List<Student> getStudent(){
        return studentService.getStudents();
	}

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studnetId}")
    public void deleteStudent(@PathVariable("StudentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studnetId}")
    public void updateStudnet(
            @PathVariable("studentId") Long studnetId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studnetId, name, email);
    }
}
