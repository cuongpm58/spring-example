package com.example.studentapi.example.api;

import com.example.studentapi.example.model.Student;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private static List<Student> listStudent = new ArrayList<>();
    private static Gson gson = new Gson();

    @PostMapping("/add-student-param")
    public String addStudentRequestParam(
            @RequestParam String name,
            @RequestParam int age
    ) {
        listStudent.add(new Student(name, age));
        return getListStudent();
    }

    @PostMapping("/add-student-path-variable/{name}/{age}")
    public String addStudentPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") int age
    ) {
        listStudent.add(new Student(name, age));
        return getListStudent();
    }

    @PostMapping(value = "/add-student-request-body", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addStudentRequestBody(
            @RequestBody Student student
    ) {
        listStudent.add(student);
        return getListStudent();
    }

    private String getListStudent() {
        return gson.toJson(listStudent);
    }
}
