package com.intern.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intern.test.constant.GlobalConstant;
import com.intern.test.entity.Student;
import com.intern.test.pojo.StudentPojo;
import com.intern.test.response.BaseResponse;
import com.intern.test.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(value = "/students")
	public BaseResponse getStudent() {
		List<Student> students = studentService.getStudent();
		return new BaseResponse(GlobalConstant.SUCCESS, students, GlobalConstant.Message.SUCCESS_MESSAGE);
	}

	@PostMapping(value = "/student")
	public BaseResponse addStudent(@RequestBody Student student) {

		try {
			student = studentService.save(student);
		} catch (Exception e) {
			System.out.println("Error occur " + e.getMessage());

			return new BaseResponse(GlobalConstant.FAIL, null, GlobalConstant.Message.FAIL_MESSAGE);
		}
		return new BaseResponse(GlobalConstant.SUCCESS, student, GlobalConstant.Message.SUCCESS_MESSAGE);
	}

	@GetMapping(value = "/students/ {id}")
	public Student getById(@PathVariable Long id) {
		return studentService.findById(id);
	}

	@DeleteMapping(value = "/students/{id}")
	public void deleteById(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

	@PutMapping(value = "/student")
	public Student updateStudent(@RequestBody StudentPojo studentPojo) {

		Student student = studentService.findById(studentPojo.getId());
		if (student == null) {
			return null;
		}
		student.setPhone(studentPojo.getPhone());
		student.setRollNo(studentPojo.getRollNo());
		return studentService.save(student);

	}

}
