package com.substitution.substitution.repository;

import com.substitution.substitution.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    // Custom query to fetch teacher IDs based on the day
    @Query("SELECT a.teacher_id FROM Attendance a WHERE a.day = :day")
    List<Integer> findTeacherIdsByDay(@Param("day") String day);  // Use @Param to bind the method parameter to the query
}
