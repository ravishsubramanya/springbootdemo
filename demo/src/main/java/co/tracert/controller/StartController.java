package co.tracert.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.tracert.model.Course;

@RestController
public class StartController {

	@GetMapping("/status")
	public String getStatus() {
		return "<h1>demo for REST is working</h1>";
	}

	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {

		Course c = new Course("id", "name", "description");
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(c);
		return courses;
	}

}
