package com.besant.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.besant.management.entity.Student;

// Repository layer responsible for database operations
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Custom query method generated automatically by Spring Data JPA
    Student findByStdNameAndCourse(String stdName, String course);
    Student findByStdNameAndAge(String name, int age);
}