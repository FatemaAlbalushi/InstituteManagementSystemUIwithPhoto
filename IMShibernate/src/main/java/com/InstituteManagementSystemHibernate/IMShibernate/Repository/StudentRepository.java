package com.InstituteManagementSystemHibernate.IMShibernate.Repository;


import com.InstituteManagementSystemHibernate.IMShibernate.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}