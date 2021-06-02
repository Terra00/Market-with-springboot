package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Pesata;

@Repository //("repository")
public interface EtichetteRepository extends JpaRepository<Pesata, Long> {
}
