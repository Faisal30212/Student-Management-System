package com.besant.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.besant.management.dto.StudentDTO;
import com.besant.management.entity.Student;
import com.besant.management.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/createStudents")
	public StudentDTO createStudent(@RequestBody  @Valid StudentDTO stObj) {
		System.out.println(stObj);
		return service.createStudent(stObj);
	}

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {

		return service.getAllStudents();
	}

	@GetMapping("/getById")
	public Optional<Student> getStdId(@RequestParam int id) {
		return service.getStdById(id);
	}

	@DeleteMapping("/deleteStudentsById")
	public String getStdById(@RequestParam int id) {
		System.out.println("delete API calling...");
		System.out.println("the requested id is:" + id);

		return service.deleteStdById(id);
	}

	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody StudentDTO Obj) {
		return service.updateStudent(id, Obj);
	}

	@GetMapping("/getByNameCourse/{name}/{course}")
	public StudentDTO fetchStudent(@PathVariable String name, @PathVariable String course) {
		return service.getByNameCourse(name, course);

	}

	@GetMapping("/getByNameAge/{name}/{age}")
	public StudentDTO fetchStudent(@PathVariable String name, @PathVariable int age) {
		return service.getByNameAge(name, age);
	}

	@PostMapping("/createNewStudent")
	public StudentDTO createNewStudent(@RequestBody StudentDTO stdObj) {
		return service.createNewStudent(stdObj);

	}
	
}
