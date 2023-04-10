package com.InstituteManagementSystemHibernate.IMShibernate.Service;

import com.InstituteManagementSystemHibernate.IMShibernate.Model.Teacher;
import com.InstituteManagementSystemHibernate.IMShibernate.Repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TeacherService {
    /**
     * Retrieve a list of all Teacher.
     * @return a list of all Teacher
     */
    public final List<Teacher> listofTeacher = new CopyOnWriteArrayList<>();

    @Autowired
    private TeacherRepository teacherRepository;


    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    /**
     * Retrieve a list of all Teacher.
     * @return a list of all Teacher
     */
    public List<Teacher>getAllTeacherInfo(){
        logger.info("Getting all Teacher");
        return teacherRepository.findAll();
    }

    /**
     * Retrieve a specific Teacher by ID.
     * @param id the ID of the Teacher to retrieve
     * @return the Teacher with the specified ID
     */
    public Optional<Teacher> getSpecificTeacherInfo(int id) {
         return  teacherRepository.findById(id);
    }

    /**
     * Hire a new Teacher.
     * @param currTeacher the Teacher to create
     * @return the newly created Teacher
     */
    public  Teacher hireTeacher(Teacher currTeacher){
        teacherRepository.save(currTeacher);
        logger.info("Created Teacher with id: " + currTeacher.TeacherId);

        return currTeacher;
    }

    /**
     * Update an existing Teacher.
     * @param id the ID of the Teacher to update
     * @param updatedTeacher the updated Teacher data
     * @return the updated Teacher
     */
    public Optional<Teacher> updateTeacher(int id, Teacher updatedTeacher){
        Optional<Teacher> foundTeacher = teacherRepository.findById(id);
        foundTeacher.ifPresent(
                (currTeacher)->{
                    currTeacher.TeacherName = updatedTeacher.TeacherName;
                    currTeacher.TeacherEmail= updatedTeacher.TeacherEmail;
                    currTeacher.salary= updatedTeacher.salary;

                    teacherRepository.save(currTeacher);
                }

        );
        logger.info("updated Teacher with id: " + id);
        return foundTeacher;
    }

    /**
     * Delete a Teacher.
     * @param id the ID of the Teacher to delete
     * @return the deleted Teacher
     */
    public Optional<Teacher> fireTeacher(int id){
        Optional<Teacher> foundTeacher = getSpecificTeacherInfo(id);
        teacherRepository.deleteById(id);
        logger.info("delete Teacher with id: " + id);
        return foundTeacher;


    }
}
