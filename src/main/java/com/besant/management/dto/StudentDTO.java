package com.besant.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {

	//@NotNull(message ="id is requiredF")
		private Integer stdId;
		
		
		@NotBlank(message = "Name is required")
		private String stdName;
		@NotBlank
		private String course;
		@NotNull(message ="age is required")
		//@Min(value = 18,message="Minimum age is 18 is required")
		//@Max(value=60,message="maximum age is 60 required")
		private int age;

		public StudentDTO() {

		}

		public StudentDTO(int stdId, String stdName, String course, int age) {
			this.stdId = stdId;
			this.stdName = stdName;
			this.course = course;
			this.age = age;
		}

		public int getStdId() {
			return stdId;
		}

		public void setStdId(int stdId) {
			this.stdId = stdId;
		}

		public String getStdName() {
			return stdName;
		}

		public void setStdName(String stdName) {
			this.stdName = stdName;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [stdId=" + stdId + ", stdName=" + stdName + ", course=" + course + ", age=" + age + "]";
		}

	}
	