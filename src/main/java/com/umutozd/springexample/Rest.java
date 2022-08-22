package com.umutozd.springexample;

import com.umutozd.springexample.jpa.Student;
import com.umutozd.springexample.jpa.StudentRepository;
import com.umutozd.springexample.types.InvalidArgumentException;
import com.umutozd.springexample.types.NotFoundException;
import com.umutozd.springexample.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
public class Rest {
    @Autowired  // Autowired annotation lets Spring runtime to assign the singleton instance of StudentRepository here
    private StudentRepository studentRepository;
    private final Random rand = new Random();


    @GetMapping("/api/student/get/{id}")
    public Student getStudent(@PathVariable("id") Integer userId) {
        return this.studentRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format("user by id=%d not found", userId)));
    }

    @GetMapping("/api/student/list")
    public List<Student> getStudent() {
        return this.studentRepository.findAll();
    }

    @PostMapping("api/student/create")
    public Student createStudent(@RequestBody Student student) {
        if (Objects.equals(student.getEmail(), "")) {
            throw new InvalidArgumentException(String.format("invalid email: '%s'", student.getEmail()));
        }
        if (Objects.equals(student.getFirstName(), "")) {
            throw new InvalidArgumentException(String.format("invalid first name: '%s'", student.getFirstName()));
        }
        if (Objects.equals(student.getLastName(), "")) {
            throw new InvalidArgumentException(String.format("invalid last name: '%s'", student.getLastName()));
        }
        return this.studentRepository.save(student);
    }
}
