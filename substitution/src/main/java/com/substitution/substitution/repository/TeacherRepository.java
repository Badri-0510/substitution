package com.substitution.substitution.repository;

import com.substitution.substitution.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT te FROM Teacher te WHERE te.teacher_id IN :teacherIds")
    List<Teacher> findTeachersByIds(@Param("teacherIds") List<Integer> teacherIds);

}
