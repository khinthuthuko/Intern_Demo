package com.intern.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.test.entity.Student;
import com.intern.test.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
  
	  @Autowired
	  StudentRepository studentRepository;
	  
	  public List<Student>  getStudent() {
		  return  studentRepository.findAll();
	  }
	  
	  public Student save(Student student) {
		  return studentRepository.save(student);
	  }
	  
	  public Student findById(Long id) {
		  return studentRepository.findById(id).orElse(null);
	  }
	  public void deleteStudent(Long id) {
		  studentRepository.deleteById(id);
	  }
}
