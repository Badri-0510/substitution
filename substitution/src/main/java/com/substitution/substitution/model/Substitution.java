package com.substitution.substitution.model;

import jakarta.persistence.*;
@Entity
@Table(name="substitution_record")
public class Substitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer substitution_id;

    private Integer absent_t_id;
    private Integer subs_t_id;
    private Integer class_id;
    private String prd_number;
    private String date;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





    public Integer getSubstitution_id() {
        return substitution_id;
    }

    public void setSubstitution_id(Integer substitution_id) {
        this.substitution_id = substitution_id;
    }

    public Integer getAbsent_t_id() {
        return absent_t_id;
    }

    public void setAbsent_t_id(Integer absent_t_id) {
        this.absent_t_id = absent_t_id;
    }

    public Integer getSubs_t_id() {
        return subs_t_id;
    }

    public void setSubs_t_id(Integer subs_t_id) {
        this.subs_t_id = subs_t_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getPrd_number() {
        return prd_number;
    }

    public void setPrd_number(String prd_number) {
        this.prd_number = prd_number;
    }
}
