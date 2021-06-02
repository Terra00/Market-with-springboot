package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Reparto;
import com.example.demo.repos.RepartoRepository;

@Controller
@RequestMapping("/demo")
public class MarketTestController {
	private static Logger log = LogManager.getLogger(MarketTestController.class);
	@Autowired RepartoRepository rrepo;
	
	@GetMapping("/test")
	public String test01() {
		log.info("********.MarketTestController.test01");
		return "markettest";
	}
	@GetMapping("/dbtest") /* http://localhost:8080/demo/dbtest */
	public String dataBaseTest(Model model) {
		Reparto reparto = rrepo.findRepartoBySigla("ORTO");
		log.info("***** Test Reparto: "+reparto);
		model.addAttribute("reparto", reparto);
		return "databasetest";
	}
}

