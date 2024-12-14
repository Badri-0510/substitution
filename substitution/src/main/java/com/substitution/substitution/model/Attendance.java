package com.substitution.substitution.model;
import jakarta.persistence.*;
@Entity
@Table(name="attendance_table")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendance_id;
    @Column(nullable = false)
    private Integer teacher_id;

    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(Integer attendance_id) {
        this.attendance_id = attendance_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }



}
