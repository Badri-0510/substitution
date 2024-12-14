package com.substitution.substitution.model;

import jakarta.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    private Integer teacher_id;
    private String name;
    private String primary_subject;
    private int total_sub_attended;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimary_subject() {
        return primary_subject;
    }

    public void setPrimary_subject(String primary_subject) {
        this.primary_subject = primary_subject;
    }

    public int getTotal_sub_attended() {
        return total_sub_attended;
    }

    public void setTotal_sub_attended(int total_sub_attended) {
        this.total_sub_attended = total_sub_attended;
    }


}
