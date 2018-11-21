package io.javabrains.springbootstarter.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllcourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	@RequestMapping("/topics/{topicId}/courses/{id}")  //We are telling spring that {id} its a variable portion

	/*@RequestMapping("/topics/{foo}")  //We are telling spring that {foo} its a variable portion its not manadatory to keep varaible name same
	public Topic getTopic(@PathVariable("foo") String id) { */

	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourseDetails(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourseToList(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String id) {
		
		courseService.deleteCourse(id);
	}
}
