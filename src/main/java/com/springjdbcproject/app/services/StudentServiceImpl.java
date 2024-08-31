package com.springjdbcproject.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjdbcproject.app.models.StudentDto;
import com.springjdbcproject.app.repos.StudentRepo;

@Repository
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public void addStudent(StudentDto studentDto) {
		studentRepo.save(studentDto);
	}

	@Override
	public List<StudentDto> getStudents() {
		return studentRepo.findAll();
	}

	@Override
	public StudentDto getStudentByRollNum(int rollNum) {
		return studentRepo.findById(rollNum);
	}

	@Override
	public void addStudents(List<StudentDto> studentDtos) {
		studentRepo.saveAll(studentDtos);
	}

	@Override
	public void deleteStudent(int rollNum) {
		studentRepo.delete(rollNum);
	}

}
