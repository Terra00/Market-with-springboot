package com.example.demo.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.PesataRequest;
import com.example.demo.entities.Pesata;
import com.example.demo.repos.EtichetteRepository;

@Service
public class PesaturaService {
	private static Logger log = LogManager.getLogger(PesaturaService.class);
	
	@Autowired EtichetteRepository repo;
	
	@Transactional
	public Pesata pesare(PesataRequest pesataRequest) {
		log.info("PesaturaService.pesare() req="+pesataRequest);
		int articolo = pesataRequest.getIdProdotto();
		int quantita = pesataRequest.getQuantita();
		float prezzoUnitario = pesataRequest.getPrezzo();
		float peso = quantita * 0.50f;
		float prezzoTotale = prezzoUnitario * peso;
		Pesata pesata = new Pesata(articolo, quantita, prezzoUnitario, peso, prezzoTotale);
		repo.save(pesata);
		log.info("***** Pesata => "+pesata);
		return pesata;
	}

}
