package com.InstituteManagementSystemHibernate.IMShibernate.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pre_course")
public class Course {
    @Id
    @GeneratedValue
    public int Courseid;
    @Column
    public String CourseName;


    @OneToOne(optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id", referencedColumnName = "TeacherId")
    @JsonIgnore
    public Teacher CourseMentor;


    @JsonProperty("teacher_id")
    public Integer getMentorId(){
        return CourseMentor != null ? CourseMentor.TeacherId:null;
    }
}
