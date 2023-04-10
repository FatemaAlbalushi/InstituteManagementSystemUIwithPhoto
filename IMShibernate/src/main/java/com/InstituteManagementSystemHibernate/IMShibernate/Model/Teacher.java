package com.InstituteManagementSystemHibernate.IMShibernate.Model;


import jakarta.persistence.*;

/**
 * The Teacher class represents a student in the Institute Management System.
 */
@Entity
@Table(name = "pre_teacher")
public class Teacher {

    /**
     * The ID of the Teacher.
     */
    @Id
    @GeneratedValue
    public int TeacherId;

    /**
     * The name of the Teacher.
     */
    @Column
    public String TeacherName;

    /**
     * The email address of the Teacher.
     */
    @Column
    public String TeacherEmail;

    /**
     * The salary of the Teacher.
     */
    @Column
    public double salary;

    @OneToOne(mappedBy = "CourseMentor")
    public Course course;

}
