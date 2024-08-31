package com.springjdbcproject.app.repos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springjdbcproject.app.models.StudentDto;

@Repository
public class StudentRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(StudentDto studentDto) {
		String query = "insert into student(roll_num,name,marks) values (?,?,?);";
		int rows = jdbcTemplate.update(query, studentDto.getRollNum(), studentDto.getName(), studentDto.getMarks());
		System.out.println("Rows affected: " + rows);
	}

	public List<StudentDto> findAll() {
		String query = "select * from student;";

		RowMapper<StudentDto> rowMapper = new RowMapper<StudentDto>() {

			@Override
			public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new StudentDto(rs.getInt("roll_num"), rs.getString("name"), rs.getInt("marks"));
			}
		};

		return jdbcTemplate.query(query, rowMapper);
	}

	public StudentDto findById(int rollNum) {
		String query = "select * from student where roll_num =?";

		RowMapper<StudentDto> rowMapper = (rs, rowNum) -> new StudentDto(rs.getInt("roll_num"), rs.getString("name"),
				rs.getInt("marks"));

		return jdbcTemplate.queryForObject(query, rowMapper, rollNum);
	}
	
	public void saveAll(List<StudentDto> studentDtos) {
		String query = "insert into student(roll_num,name,marks) values (?,?,?);";
		
		BatchPreparedStatementSetter batchPreparedStatementSetter = new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, studentDtos.get(i).getRollNum());
				ps.setString(2, studentDtos.get(i).getName());
				ps.setInt(3, studentDtos.get(i).getMarks());			
			}
			
			@Override
			public int getBatchSize() {
				return studentDtos.size();
			}
		};
		
		int rows[] = jdbcTemplate.batchUpdate(query, batchPreparedStatementSetter);
		for(int i : rows) {
			System.out.println("Rows Effected: "+i);
		}
	}

	public void delete(int rollNum) {
		String query = "delete from student where roll_num =?";
		int rows = jdbcTemplate.update(query, rollNum);
		System.out.println("Rows affected: " + rows);
	}
}
