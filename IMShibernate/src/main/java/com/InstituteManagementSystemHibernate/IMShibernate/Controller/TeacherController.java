package com.InstituteManagementSystemHibernate.IMShibernate.Controller;

import com.InstituteManagementSystemHibernate.IMShibernate.Model.Teacher;
import com.InstituteManagementSystemHibernate.IMShibernate.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The TeacherController class is a REST controller for managing Teacher data in the Institute Management System.
 */
@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService TeacherService;

    /**
     * Retrieve a list of all Teacher
     * @return a list of all Teacher
     */
    @GetMapping
    public List<Teacher> getAllTeacherInfo(){
        return TeacherService.getAllTeacherInfo();
    }

    /**
     * Retrieve a specific Teacher by ID
     * @param id the ID of the Teacher to retrieve
     * @return the Teacher with the specified ID
     */
    @GetMapping(path = "/{id}")
    public Optional<Teacher> getSpecificTeacher(@PathVariable(name="id") int id){
        return TeacherService.getSpecificTeacherInfo(id);
    }

    /**
     * Create a new Teacher
     * @param currTeacher Teacher to create
     * @return the newly created Teacher
     */
    @PostMapping
    public Teacher hireTeacher(@RequestBody Teacher currTeacher){
        TeacherService.hireTeacher(currTeacher);
        return currTeacher;
    }

    /**
     * Update an existing Teacher
     * @param id the ID of the Teacher to update
     * @param currTeacher the updated Teacher data
     * @return the updated Teacher
     */
    @PutMapping(path = "/{id}")
    public Optional<Teacher> updateTeacher(@PathVariable(name="id") int id, @RequestBody Teacher currTeacher){
        return TeacherService.updateTeacher(id, currTeacher);

    }

    /**
     * Delete a Teacher
     * @param id the ID of the Teacher to delete
     * @return the deleted Teacher
     */
    @DeleteMapping(path = "/{id}")
    public Optional<Teacher> fireTeacher(@PathVariable(name="id") int id) {
        return TeacherService.fireTeacher(id);
    }
}
