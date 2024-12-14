package com.substitution.substitution.model;

import jakarta.persistence.*;

@Entity
@Table(name="timetable_table")
public class Timetable {

    @EmbeddedId
    private TimetableId id;

    private Integer p1;
    private Integer p2;
    private Integer p3;
    private Integer p4;
    private Integer p5;

    // Getters and Setters
    public TimetableId getId() {
        return id;
    }

    public void setId(TimetableId id) {
        this.id = id;
    }

    public String getDays_of_week() {
        return id != null ? id.getDays_of_week() : null;
    }

    public void setDays_of_week(String days_of_week) {
        if (id == null) {
            id = new TimetableId();
        }
        id.setDays_of_week(days_of_week);
    }

    public Integer getTeacher_id() {
        return id != null ? id.getTeacher_id() : null;
    }

    public void setTeacher_id(Integer teacher_id) {
        if (id == null) {
            id = new TimetableId();
        }
        id.setTeacher_id(teacher_id);
    }

    public Integer getP1() {
        return p1;
    }

    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    public Integer getP2() {
        return p2;
    }

    public void setP2(Integer p2) {
        this.p2 = p2;
    }

    public Integer getP3() {
        return p3;
    }

    public void setP3(Integer p3) {
        this.p3 = p3;
    }

    public Integer getP4() {
        return p4;
    }

    public void setP4(Integer p4) {
        this.p4 = p4;
    }

    public Integer getP5() {
        return p5;
    }

    public void setP5(Integer p5) {
        this.p5 = p5;
    }
}
