package com.springjdbcproject.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springjdbcproject.app.models.StudentDto;
import com.springjdbcproject.app.services.StudentService;

@Component
public class ProjectExecution {

	private final StudentService studentService;
	
	@Autowired
	public ProjectExecution(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public void init() {
		/*
		 * CRUD| addStudent
		 */
		System.out.println("CRUD| addStudent");
		List<StudentDto> studentDtos = new ArrayList<StudentDto>(
				List.of(new StudentDto(4, "D", 40), new StudentDto(5, "E", 50)));
		for (StudentDto student : studentDtos) {
			studentService.addStudent(student);
		}

		/*
		 * CRUD| getStudents
		 */
		System.out.println();
		System.out.println("CRUD| getStudents");
		studentService.getStudents().stream().map(StudentDto::toString).forEach(System.out::println);

		/*
		 * CRUD| getStudentByRollNum
		 */
		System.out.println();
		System.out.println("CRUD| getStudentByRollNum");
		System.out.println(studentService.getStudentByRollNum(4).toString());

		/*
		 * CRUD| addStudents
		 */
		System.out.println();
		System.out.println("CRUD| addStudents");
		List<StudentDto> studentDtos1 = new ArrayList<StudentDto>(
				List.of(new StudentDto(6, "F", 60), new StudentDto(7, "G", 70)));

		studentService.addStudents(studentDtos1);

		/*
		 * CRUD| deleteStudent
		 */
		System.out.println();
		System.out.println("CRUD| deleteStudent");
		studentService.deleteStudent(8);
	}
}
