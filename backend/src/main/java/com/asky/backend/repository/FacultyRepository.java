package com.asky.backend.repository;

import com.asky.backend.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("facultyRepository")
public interface FacultyRepository extends JpaRepository<Faculty,Integer> {
}
