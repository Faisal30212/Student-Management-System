package com.besant.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besant.management.dto.StudentDTO;
import com.besant.management.entity.Student;
import com.besant.management.exceptionHandling.IdNotFound;
import com.besant.management.exceptionHandling.InvalidAgeException;
import com.besant.management.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;

	public StudentDTO createStudent(StudentDTO stObj) {
		// TODO Auto-generated method stub
		System.out.println("calling Repository");
		if (stObj.getAge() < 18) {
			throw new InvalidAgeException("user should give age greater than 18");
		}
		Student st = convertDtoToEntity(stObj);

		repo.save(st);

		return stObj;
	}

	private Student convertDtoToEntity(StudentDTO stObj) {
		Student st = new Student();
		// st.setStdId(stObj.getStdId());
		st.setCourse(stObj.getCourse());
		st.setStdName(stObj.getStdName());
		st.setAge(stObj.getAge());
		return st;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	/*public Optional<Student> getStdById(int id) {
	    try {
	        Optional<Student> entity = repo.findById(id);
	        if (entity.isEmpty()) {
	            throw new IdNotFound("Student Not Found with Id: " + id);
	        }
	        return entity;
	    } catch (IdNotFound e) {
	        // Handle it here instead of throwing
	        System.out.println(e.getMessage());
	        return Optional.empty(); 
	    }
	}*/


	public Optional<Student> getStdById(int id) throws IdNotFound {
		// TODO Auto-generated method stub

		Optional<Student> entity = repo.findById(id);
		if (entity.isEmpty()) {
			throw new IdNotFound("Student Not Found with Id");
		}
		return repo.findById(id);

	}

	public String deleteStdById(int id) {
		System.out.println(" service DeleteById layered called");
		// TODO Auto-generated method stub
		Optional<Student> Obj = repo.findById(id);

		if (Obj.isPresent()) {
			System.out.println(Obj.get());
			repo.deleteById(id);
			return "deleted successfully";

		} else {
			return "Id not found in the database";
		}

	}

	public String updateStudent(int id, StudentDTO obj) {
		// TODO Auto-generated method stub
		Optional<Student> existingStudentOpt = repo.findById(id);
		if (existingStudentOpt.isPresent()) {
			Student student = existingStudentOpt.get();
			student.setStdName(obj.getStdName());
			student.setCourse(obj.getCourse());
			student.setAge(obj.getAge());

			repo.save(student);
			return "Updated successfully";

		} else {

			return "id not found in the database";
		}
	}

	public StudentDTO getByNameCourse(String name, String course) {
		// TODO Auto-generated method stub
		Student obj = repo.findByStdNameAndCourse(name, course);
		StudentDTO dto = convertEntityToDto(obj);

		return dto;
	}

	private StudentDTO convertEntityToDto(Student obj) {
		// TODO Auto-generated method stub
		StudentDTO dto = new StudentDTO();
		dto.setStdId(obj.getStdId());
		dto.setAge(obj.getAge());
		dto.setStdName(obj.getStdName());
		dto.setCourse(obj.getCourse());

		return dto;
	}

	public StudentDTO getByNameAge(String name, int age) {
		// TODO Auto-generated method stub
		Student obj = repo.findByStdNameAndAge(name, age);

		StudentDTO dto = new StudentDTO();
		dto.setStdId(obj.getStdId());
		dto.setStdName(obj.getStdName());
		dto.setCourse(obj.getCourse());
		dto.setAge(obj.getAge());
		return dto;
	}

	public StudentDTO createNewStudent(StudentDTO stdObj) {
		// TODO Auto-generated method stub
		Student st = convertDtoToEntity(stdObj);
		repo.save(st);
		return stdObj;
	}

}
