package com.InstituteManagementSystemHibernate.IMShibernate.Controller;

import com.InstituteManagementSystemHibernate.IMShibernate.Model.Course;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.Student;
import com.InstituteManagementSystemHibernate.IMShibernate.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable int id) {
        return courseService.getSpecificCourseInfo(id);
    }


    @PostMapping("")
    public Course createCourse(@RequestBody Course course) {
        return courseService.registerCourse(course);
    }

    @PutMapping("/{id}")
    public Optional<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public Optional<Course> deleteCourse(@PathVariable int id) {
        return courseService.dropCourse(id);
    }


}
