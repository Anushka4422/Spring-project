package com.zensar.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootdemo.Dto.Studentdto;
//import com.zensar.springbootdemo.Dto.*;
//import com.zensar.springbootdemo.entity.*;
import com.zensar.springbootdemo.service.StudentService;

@RestController
@RequestMapping(value = "/student-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {

	@Autowired
	private StudentService studentService;

	// @RequestMapping(value = "/students/{studentId}",method=RequestMethod.GET)
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<Studentdto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<Studentdto>(studentService.getStudent(studentId), HttpStatus.OK);
	}

	// @RequestMapping(value = { "/students", "/listOfStudents"
	// },method=RequestMethod.GET)

	// http://localhost:4747/student-api/students?pageNumber=0&pageSize=5&sortBy=studentName&dir=DESC
	@GetMapping(value = { "/students", "/listOfStudents" })
	public ResponseEntity<List<Studentdto>> getAllStudents(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "studentName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "ASC") Direction dir) {

		return new ResponseEntity<List<Studentdto>>(studentService.getAllStudents(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/students",method=RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<Studentdto> insertStudent(@RequestBody Studentdto studentDto) {

		return new ResponseEntity<Studentdto>(studentService.insertStudent(studentDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody Studentdto studentDto) {
		studentService.updateStudent(studentId, studentDto);
		return new ResponseEntity<String>("Student Updated Successfully..", HttpStatus.OK);

	}

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student Deleted Successfully..", HttpStatus.OK);
	}

	@GetMapping("/students/studentName/{studentName}")
	public ResponseEntity<List<Studentdto>> getByStudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<Studentdto>>(studentService.getByStudentName(studentName), HttpStatus.OK);

	}

	@GetMapping("/students/{studentName}/{studentAge}")
	public ResponseEntity<List<Studentdto>> findByStudentNameAndStudentAge(
			@PathVariable("studentName") String studentName, @PathVariable("studentAge") int age) {

		return new ResponseEntity<List<Studentdto>>(studentService.findByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}

}