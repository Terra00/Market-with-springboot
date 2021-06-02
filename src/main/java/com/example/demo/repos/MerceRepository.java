package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Merce;
import com.example.demo.entities.Pesata;

public interface MerceRepository extends JpaRepository<Merce, Integer> {

	// Named Query da Entity Merce
	List<Merce> findMerceByReparto(Integer id_reparto);
	
	// nostra query custom
	@Query("select f from Merce f where f.reparto.sigla in (:elencoSigle)")
	List<Merce> findMerceByRepartiInSigleList(String... elencoSigle);

	List<Merce> findMerceByRepartoId(Integer id_reparto);
	
	List<Merce> findMerceByRepartoSigla(String sigla);

	List<Merce> findMerceByRepartoSiglaOrderByDescrizione(String sigla);
	
	List<Merce> findMerceByPesaturaOrderByReparto(Pesata pesatura);
}
