package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
