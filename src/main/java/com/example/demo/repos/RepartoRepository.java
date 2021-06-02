package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Reparto;


@Repository //("repository")
public interface RepartoRepository extends JpaRepository<Reparto, Integer> {
	Reparto findRepartoBySigla(String string);
}
