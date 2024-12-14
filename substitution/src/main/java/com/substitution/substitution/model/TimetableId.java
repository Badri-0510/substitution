package com.substitution.substitution.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class TimetableId implements Serializable {

    private String days_of_week;
    private Integer teacher_id;

    // Default constructor
    public TimetableId() {}

    // Constructor
    public TimetableId(String days_of_week, Integer teacher_id) {
        this.days_of_week = days_of_week;
        this.teacher_id = teacher_id;
    }

    // Getters and Setters
    public String getDays_of_week() {
        return days_of_week;
    }

    public void setDays_of_week(String days_of_week) {
        this.days_of_week = days_of_week;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    // equals() and hashCode() methods for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableId that = (TimetableId) o;
        return days_of_week.equals(that.days_of_week) && teacher_id.equals(that.teacher_id);
    }

    @Override
    public int hashCode() {
        return 31 * days_of_week.hashCode() + teacher_id.hashCode();
    }
}
