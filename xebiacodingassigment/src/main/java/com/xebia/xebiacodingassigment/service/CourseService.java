package com.xebia.xebiacodingassigment.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.xebiacodingassigment.model.Course;
import com.xebia.xebiacodingassigment.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public Course saveCourse(Course course) {
		return repository.save(course);	
	}
	
	
	
	public Course findCourseById(int id) {
		Optional<Course> courseOptional = repository.findById(id);
		
		if(courseOptional.isPresent()) {
			return courseOptional.get();
		}
		
		return null;
	}
	
	public String deleteByID(int id) {
		repository.deleteById(id);
		return "The deleted Course Id "+id;
 	}
	
	
	

}
