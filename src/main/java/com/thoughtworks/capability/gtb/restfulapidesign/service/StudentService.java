package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    public List<Student> getStudentList(String gender) {
        if (gender == null) {
            return studentRepository.getStudentList();
        } else {
            return studentRepository.getStudentListByGender(gender);
        }
    }

    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }
}
