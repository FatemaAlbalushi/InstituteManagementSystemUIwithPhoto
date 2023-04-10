package com.InstituteManagementSystemHibernate.IMShibernate.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

/**
 * The Student class represents a student in the Institute Management System.
 */
@Entity
@Table(name = "pre_student")
public class Student {

    /**
     * The ID of the student.
     */
    @Id
    @GeneratedValue
    public int Stusentid;

    /**
     * The name of the student.
     */
    @Column
    public String Studentname;

    /**
     * The email address of the student.
     */
    @Column
    @Pattern(regexp = "^[a-z|A-Z|.]+@[a-z|A-Z]+\\.[a-z|A-Z]{2,}$")
    public String Studentemail;

    @Column
    public String imageName;
}
