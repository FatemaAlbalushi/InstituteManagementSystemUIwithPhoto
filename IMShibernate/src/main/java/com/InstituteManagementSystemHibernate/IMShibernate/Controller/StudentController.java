package com.InstituteManagementSystemHibernate.IMShibernate.Controller;

import com.InstituteManagementSystemHibernate.IMShibernate.Model.Student;
import com.InstituteManagementSystemHibernate.IMShibernate.Service.StudentService;
import jakarta.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * The MainController class is a REST controller for managing student data in the Institute Management System.
 */
@RestController
@RequestMapping(path = "/api/student")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Retrieve a list of all students
     * @return a list of all students
     */
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudent();
    }

    /**
     * Retrieve a specific student by ID
     * @param id the ID of the student to retrieve
     * @return the student with the specified ID
     */
    @GetMapping(path = "/{id}")
    public Optional<Student> getStudent(@PathVariable(name="id") int id){
        return studentService.getSpecificStudentInfo(id);
    }

    /**
     * Create a new student
     * @param currStudent the student to create
     * @return the newly created student
     */
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student currStudent){
        studentService.createStudent(currStudent);
        return currStudent;
    }

    @PostMapping(path = "/withImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Student createStudentwithImage(@RequestParam String name,
                                          @RequestParam String email,
                                          @RequestParam(required = false) MultipartFile image) throws IOException {

        Student newStudent = new Student();
        newStudent.Studentname=name;
        newStudent.Studentemail=email;
        Student savedStudent = studentService.createStudent(newStudent);


        if (image!=null){
            savedStudent.imageName=Integer.toString(savedStudent.Stusentid)+"_"+savedStudent.Studentname +".jpg";
            FileUtils.writeByteArrayToFile(new File("./src/main/resources/static/student_images/"+savedStudent.imageName), image.getBytes());
            studentService.updateStudent(savedStudent.Stusentid,savedStudent);
        }

        return savedStudent;
    }

    /**
     * Update an existing student
     * @param id the ID of the student to update
     * @param currStudent the updated student data
     * @return the updated student
     */
    @PutMapping(path = "/{id}")
    public Optional<Student> updateStudent(@PathVariable(name="id") int id, @RequestBody Student currStudent){
        return studentService.updateStudent(id, currStudent);

    }

    /**
     * Delete a student
     * @param id the ID of the student to delete
     * @return the deleted student
     */
    @DeleteMapping(path = "/{id}")
    public Optional<Student> deleteStudent(@PathVariable(name="id") int id) {
        return studentService.deleatStudent(id);
    }
}
