package com.cadastroestudantes.repository;

import com.cadastroestudantes.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
