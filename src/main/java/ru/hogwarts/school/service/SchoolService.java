package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;

@Service
public class SchoolService {
	
	private final StudentRepository studentRepository;
	
	public SchoolService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Integer getTotalStudents() {
		return studentRepository.getTotalStudents();
	}
	
	public Double getAverageAgeOfStudents() {
		Double averageAgeOfStudents = studentRepository.getAverageAgeOfStudents();
		return averageAgeOfStudents;
	}
	
	public List<Student> getLastStudents(int studentsNumber) {
		return studentRepository.getLastStudents(studentsNumber);
	}
	
}