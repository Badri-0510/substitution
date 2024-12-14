package com.substitution.substitution.repository;

import com.substitution.substitution.model.Timetable;
import com.substitution.substitution.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
    @Query("SELECT t FROM Timetable t WHERE t.id.teacher_id = :teacherId AND t.id.days_of_week = :day")
    Timetable findByTeacherIdAndDaysOfWeek(@Param("teacherId") Integer teacherId, @Param("day") String day);

    // Query to fetch teacher IDs where day of the week is 'day' and p1 is null, excluding specific teacher IDs
    @Query("SELECT t.id.teacher_id FROM Timetable t " +
            "WHERE t.id.days_of_week = :day AND t.p1 IS NULL AND t.id.teacher_id NOT IN :excludedIds")
    List<Integer> findTeacherIdsByDayAndP1IsNull(@Param("day") String day, @Param("excludedIds") List<Integer> excludedIds);

    // Query to fetch teacher IDs where day of the week is 'day' and p2 is null, excluding specific teacher IDs
    @Query("SELECT t.id.teacher_id FROM Timetable t " +
            "WHERE t.id.days_of_week = :day AND t.p2 IS NULL AND t.id.teacher_id NOT IN :excludedIds")
    List<Integer> findTeacherIdsByDayAndP2IsNull(@Param("day") String day, @Param("excludedIds") List<Integer> excludedIds);

    // Query to fetch teacher IDs where day of the week is 'day' and p3 is null, excluding specific teacher IDs
    @Query("SELECT t.id.teacher_id FROM Timetable t " +
            "WHERE t.id.days_of_week = :day AND t.p3 IS NULL AND t.id.teacher_id NOT IN :excludedIds")
    List<Integer> findTeacherIdsByDayAndP3IsNull(@Param("day") String day, @Param("excludedIds") List<Integer> excludedIds);

    // Query to fetch teacher IDs where day of the week is 'day' and p4 is null, excluding specific teacher IDs
    @Query("SELECT t.id.teacher_id FROM Timetable t " +
            "WHERE t.id.days_of_week = :day AND t.p4 IS NULL AND t.id.teacher_id NOT IN :excludedIds")
    List<Integer> findTeacherIdsByDayAndP4IsNull(@Param("day") String day, @Param("excludedIds") List<Integer> excludedIds);

    // Query to fetch teacher IDs where day of the week is 'day' and p5 is null, excluding specific teacher IDs
    @Query("SELECT t.id.teacher_id FROM Timetable t " +
            "WHERE t.id.days_of_week = :day AND t.p5 IS NULL AND t.id.teacher_id NOT IN :excludedIds")
    List<Integer> findTeacherIdsByDayAndP5IsNull(@Param("day") String day, @Param("excludedIds") List<Integer> excludedIds);

}
