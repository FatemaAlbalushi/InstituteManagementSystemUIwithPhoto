package com.InstituteManagementSystemHibernate.IMShibernate.Service;

import com.InstituteManagementSystemHibernate.IMShibernate.Model.Course;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.Student;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.Teacher;
import com.InstituteManagementSystemHibernate.IMShibernate.Repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CourseService {

    @Autowired
    public CourseRepository courseRepository;


    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    public List<Course> getAllCourses() {
        logger.info("Getting all courses");
        return courseRepository.findAll();
    }

    public Optional<Course> getSpecificCourseInfo(int id) {
        logger.info("Getting course with id: " + id);
        return courseRepository.findById(id);
    }

    public Course registerCourse(Course course) {
        logger.info("Created course with id: " + course.Courseid);
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(int id, Course updatedCourse) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        foundCourse.ifPresent(
                (currCourse)->{
//                    currCourse.Courseid = updatedCourse.Courseid;
                    currCourse.CourseName= updatedCourse.CourseName;
//                    currCourse.CourseDescription= updatedCourse.CourseDescription;

                    courseRepository.save(currCourse);
                }
        );

        logger.info("Updated course with id: " + id);
        return foundCourse;
    }

    public Optional<Course> dropCourse(int id) {
        Optional<Course>  foundCourse = getSpecificCourseInfo(id);
        courseRepository.deleteById(id);

        logger.info("Deleted course with id: " + id);
        return foundCourse;
    }

//    public List<Student> getAppliedStudentsByCourseId(int courseId) {
//         Optional<Course> course = getSpecificCourseInfo(courseId);
//        return course.getStudents();
//    }
//
//    public void addAppliedStudentToCourse(int courseId, Student student) {
//        Optional<Course> course = getSpecificCourseInfo(courseId);
//        course.addStudent(student);
//    }
}

