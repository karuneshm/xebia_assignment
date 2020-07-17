package com.xebia.xebiacodingassigment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.xebiacodingassigment.model.Course;
import com.xebia.xebiacodingassigment.service.CourseService;

@RestController
public class CourseController {
	
	
	@Autowired
	private CourseService service;
	
	
	@PostMapping("/courses")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		course.setSlug(course.getTitle().replace(" ", "-"));
		Course retrivedCourse = service.saveCourse(course);
		return new ResponseEntity<Course>(retrivedCourse,HttpStatus.CREATED);
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> findCourseByID(@PathVariable(name = "id") int id) {
		Course retrivedCourse = service.findCourseById(id);
		if (null == retrivedCourse) {
			return new ResponseEntity<Course>(retrivedCourse,HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Course>(retrivedCourse,HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable(name = "id") int id, @RequestBody Course course) {
		Course retrivedCourse = service.saveCourse(course);
		retrivedCourse.setSlug(course.getTitle().replace(" ", "-"));
		return new ResponseEntity<Course>(retrivedCourse,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable(name = "id") int id) {
		Course retrivedCourse = service.findCourseById(id); 
		if (null == retrivedCourse) {
			String notFound = "Course with id "+id+ " not present";
			return new ResponseEntity<String>(notFound,HttpStatus.NOT_FOUND);
		} else {
			String found = service.deleteByID(id);
			return new ResponseEntity<String>(found,HttpStatus.NO_CONTENT);
		}
		
	}

}
