package com.intern.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.test.entity.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student ,Long>{
	

}
