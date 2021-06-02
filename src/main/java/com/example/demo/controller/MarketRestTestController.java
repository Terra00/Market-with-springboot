package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Merce;
import com.example.demo.repos.MerceRepository;

@RestController
@RequestMapping("/demorest")
public class MarketRestTestController {
	private static Logger log = LogManager.getLogger(MarketTestController.class);
	
	@Autowired MerceRepository mrepo;

	@GetMapping("/resttest") /* http://localhost:8080/demorest/resttest */
	public List<Merce> test01() {
		log.info("***** MarketRestTestController.test01()");
		return mrepo.findAll();
	}

}
