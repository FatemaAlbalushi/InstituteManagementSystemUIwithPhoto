package com.InstituteManagementSystemHibernate.IMShibernate.Repository;

import com.InstituteManagementSystemHibernate.IMShibernate.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
