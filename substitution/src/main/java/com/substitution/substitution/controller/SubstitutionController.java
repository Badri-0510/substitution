package com.substitution.substitution.controller;

import com.substitution.substitution.model.Substitution;
import com.substitution.substitution.repository.SubstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
public class SubstitutionController {

    @Autowired
    private SubstitutionRepository substitutionRepository;

    // Endpoint to fetch all substitution records
    @GetMapping("/substitutions")
    public List<Substitution> getAllSubstitutions() {
        return substitutionRepository.findAll();
    }
}
