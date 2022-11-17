package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(String name, int age) {
        Student student = new Student(name, age);
        return studentRepository.save(student);
    }

    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAge(int minAge, int maxAge) {
        if (minAge <= 0) {
            throw new RuntimeException("Возраст должен быть положительным");
        }
        if (maxAge == -1 || minAge == maxAge) {
            return studentRepository.findByAge(minAge);
        }
        if (minAge >= maxAge) {
            throw new RuntimeException("Диапазон возрастов задан неверно");
        }
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Faculty getFacultyByStudent(Long studentId) {
        return get(studentId).getFaculty();
    }
}
