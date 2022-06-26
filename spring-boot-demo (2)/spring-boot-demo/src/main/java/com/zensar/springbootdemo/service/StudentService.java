package com.zensar.springbootdemo.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.springbootdemo.Dto.*;
import com.zensar.springbootdemo.entity.Student;

public interface StudentService {

	public Studentdto getStudent(int studentId);

	public List<Studentdto> getAllStudents(int pageNumber, int pageSize, String sortBy, Direction dir);

	public Studentdto insertStudent(Studentdto student);

	public void updateStudent(int studentId, Studentdto student);

	public void deleteStudent(int studentId);

	List<Studentdto> getByStudentName(String studentName);

	List<Studentdto> findByStudentNameAndStudentAge(String studentName, int age);

}
