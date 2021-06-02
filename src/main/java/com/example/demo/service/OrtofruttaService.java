package com.example.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Merce;
import com.example.demo.repos.MerceRepository;

@Service
public class OrtofruttaService {
	private static Logger log = LogManager.getLogger(OrtofruttaService.class);
	@Autowired MerceRepository mrepo;
	public List<Merce> listByReparto(String reparto) {
		log.info("***** OrtofruttaService.listByReparto()");
		List<Merce> merce = mrepo.findMerceByRepartoSigla(reparto);
		return merce;
	}
}
