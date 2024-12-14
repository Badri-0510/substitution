package com.substitution.substitution.service;


import com.substitution.substitution.model.Teacher;
import com.substitution.substitution.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findById(id).orElse(null);
    }

}
