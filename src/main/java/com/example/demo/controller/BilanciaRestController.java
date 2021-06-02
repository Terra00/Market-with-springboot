package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.PesataRequest;
import com.example.demo.entities.Pesata;
import com.example.demo.service.PesaturaService;

@RestController
@RequestMapping("/bilancia")
public class BilanciaRestController {
	private static Logger log = LogManager.getLogger(BilanciaRestController.class);
	
	@Autowired PesaturaService service;
	
	@PostMapping("/pesare") /* http://localhost:8080/ortofrutta/list */
	public Pesata pesare(@RequestBody PesataRequest pesataRequest) {
		log.info("***** BilanciaRestController.pesare()");
		log.info("***** Pesata REQUEST => "+pesataRequest);
		Pesata pesata = service.pesare(pesataRequest);
		return pesata;
	}
	
	@PostMapping("/echo")
	public String echo(@RequestBody String json) {
		log.info("###### echo ricevuto => "+json);
		return json;
	}
}
