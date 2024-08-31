package com.springjdbcproject.app.services;

import java.util.List;

import com.springjdbcproject.app.models.StudentDto;

public interface StudentService {
	
	void addStudent(StudentDto studentDto);
	
	void addStudents(List<StudentDto> studentDtos);
	
	List<StudentDto> getStudents();
	
	StudentDto getStudentByRollNum(int rollNum);
	
	void deleteStudent(int rollNum);
}
