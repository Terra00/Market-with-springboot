package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.JsonRequestObject;
import com.example.demo.beans.JsonResponseObject;

@RestController
@RequestMapping("/json")
public class JsonRestController {
	private static Logger log = LogManager.getLogger(JsonRestController.class);
	private Integer count = 0;
	
	@PostMapping("/echo")
	public String echo(@RequestBody String json) {
		log.info("###### echo ricevuto => "+json);
		return json;
	}
	
	@PostMapping("/plain")
	public JsonResponseObject echoplain(@RequestParam Integer quantita, Integer prezzo) {
		log.info("###### echoplain ricevuto => quantita="+quantita+" prezzo="+prezzo);
		return new JsonResponseObject(quantita, prezzo, ++count);
	}
	
	@PostMapping("/echoobj")
	public JsonResponseObject echoobj(@RequestBody JsonRequestObject jro) {
		log.info("###### echoobj ricevuto => "+jro);
		return new JsonResponseObject(jro.getQuantita(), jro.getPrezzo(), ++count);
	}
}
