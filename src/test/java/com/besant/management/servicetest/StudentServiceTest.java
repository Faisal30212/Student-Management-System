package com.besant.management.servicetest;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;

import com.besant.management.dto.StudentDTO;
import com.besant.management.entity.Student;
import com.besant.management.exceptionHandling.InvalidAgeException;
import com.besant.management.repository.StudentRepository;
import com.besant.management.service.StudentService;

@ExtendWith(MockitoExtension.class) // Enables Mockito framework
public class StudentServiceTest {

    @InjectMocks // Creates StudentService object and injects mock objects
    StudentService service;

    @Mock // Creates fake Repository object for testing
    StudentRepository repo;

    @Test // Test case for valid student creation
    public void createStudentTest() {

        StudentDTO dto = new StudentDTO();

        dto.setStdId(1);
        dto.setStdName("Faisal");
        dto.setAge(23);
        dto.setCourse("cs");
        
        Student entity = new Student();
        entity.setStdName("Faisal");
        entity.setAge(23);
        entity.setCourse("cs");
        Mockito.when(repo.save(Mockito.any(Student.class))).thenReturn(entity);

        // Calling service method
        StudentDTO resdto = service.createStudent(dto);
        Assertions.assertThat(resdto).isNotNull();
        Assertions.assertThat(resdto.getStdName()).isEqualTo("Faisal");
        Assertions.assertThat(resdto.getAge()).isEqualTo(23);
        Assertions.assertThat(resdto.getCourse()).isEqualTo("cs");
        // Usually we verify returned object or repository call
    }

    @Test // Test case for age less than 18
    public void createStudentLessThanAgeTest() {

        StudentDTO dto = new StudentDTO();

        dto.setStdId(1);
        dto.setStdName("Faisal");
        dto.setAge(17); // Invalid age
        dto.setCourse("cs");

        try {

            // This should throw invalidAgeException
            StudentDTO resdto = service.createStudent(dto);

        } catch (InvalidAgeException e) {

            // Verify exception message
            assertEquals(
                    e.getMessage(),
                    "user should give age greater than 18");

        }
    }
}