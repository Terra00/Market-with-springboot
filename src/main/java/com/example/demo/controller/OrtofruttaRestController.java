/*
 * 1) EsercizioCreare 
 * OrtofruttaRestController che emetta tutta la merce in vendita nel reparto Ortofrutta.
 */
package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Merce;

import com.example.demo.service.OrtofruttaService;


@RestController
@RequestMapping("/ortofruttarest")
public class OrtofruttaRestController {
	private static Logger log = LogManager.getLogger(OrtofruttaRestController.class);
	
	@Autowired OrtofruttaService service;
	
	@GetMapping("/list") /* http://localhost:8080/ortofrutta/list */
	public List<Merce> list() {
		log.info("***** OrtofruttaRestController.list()");
		List<Merce> merce = service.listByReparto("ORTO");
		return merce;
	}

}
