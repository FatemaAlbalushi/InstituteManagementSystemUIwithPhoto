package com.InstituteManagementSystemHibernate.IMShibernate.Service;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.Student;
import com.InstituteManagementSystemHibernate.IMShibernate.Model.Teacher;
import com.InstituteManagementSystemHibernate.IMShibernate.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The StudentService class provides services for managing student data in the Institute Management System.
 */
@Service
public class StudentService {

    /**
     * Retrieve a list of all students.
     * @return a list of all students
     */
    public List<Student> listofStudent = new CopyOnWriteArrayList<>();
    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    /**
     * Retrieve a list of all students.
     * @return a list of all students
     */
    public List<Student>getAllStudent(){
        logger.info("Getting all student");
        return studentRepository.findAll();
    }

    /**
     * Retrieve a specific student by ID.
     * @param id the ID of the student to retrieve
     * @return the student with the specified ID
     */
    public Optional<Student> getSpecificStudentInfo(int id) {
        logger.info("get student with id: " + id);
        return studentRepository.findById(id);

    }

    /**
     * Create a new student.
     * @param currStudent the student to create
     * @return the newly created student
     */
    public Student createStudent(Student currStudent){
        studentRepository.save(currStudent);
        logger.info("Created student with id: " + currStudent.Stusentid);
        return currStudent;
    }

    /**
     * Update an existing student.
     * @param id the ID of the student to update
     * @param updatedStudent the updated student data
     * @return the updated student
     */
    public Optional<Student> updateStudent(int id,Student updatedStudent){
        Optional<Student> foundStudent = studentRepository.findById(id);
        foundStudent.ifPresent(
                (currStudent)->{
                    currStudent.Studentname = updatedStudent.Studentname;
                    currStudent.Studentemail= updatedStudent.Studentemail;
                    studentRepository.save(currStudent);
                }
        );
        logger.info("updated student with id: " + id);
        return foundStudent;
    }

    /**
     * Delete a student.
     * @param id the ID of the student to delete
     * @return the deleted student
     */
    public Optional<Student> deleatStudent(int id){
        Optional<Student> foundStudent = getSpecificStudentInfo(id);
        studentRepository.deleteById(id);
        logger.info("delete student with id: " + id);
        return foundStudent;
    }
}

