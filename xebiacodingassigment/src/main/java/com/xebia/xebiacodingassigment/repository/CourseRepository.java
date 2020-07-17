package com.xebia.xebiacodingassigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.xebiacodingassigment.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
