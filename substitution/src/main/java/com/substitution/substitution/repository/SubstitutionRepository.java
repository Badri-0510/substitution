package com.substitution.substitution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.substitution.substitution.model.Substitution;

@Repository
public interface SubstitutionRepository extends JpaRepository<Substitution, Integer> {
    // Additional query methods (if needed) can be defined here
}
