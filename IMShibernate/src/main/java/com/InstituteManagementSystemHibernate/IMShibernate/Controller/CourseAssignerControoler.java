package com.InstituteManagementSystemHibernate.IMShibernate.Controller;


import com.InstituteManagementSystemHibernate.IMShibernate.Model.Course;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.CourseAssigner;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.Teacher;
import com.InstituteManagementSystemHibernate.IMShibernate.Service.CourseService;
import com.InstituteManagementSystemHibernate.IMShibernate.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/assigner")
public class CourseAssignerControoler {
    @Autowired
    CourseService courseService;

@Autowired
    TeacherService teacherService;
    @PostMapping
    public CourseAssigner assignMentorToTeacher(@RequestBody CourseAssigner assigner){
        Optional<Course> optionalCourse =courseService.getSpecificCourseInfo(assigner.course_id);
        Optional<Teacher> optionalTeacher =teacherService.getSpecificTeacherInfo(assigner.teacher_id);

        optionalCourse.ifPresent((course)->{
            optionalTeacher.ifPresent((teacher)->{
                course.CourseMentor= teacher;
                courseService.registerCourse(course);
            });
        });
        return assigner;
    }
}
