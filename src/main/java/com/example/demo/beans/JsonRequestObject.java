package com.example.demo.beans;

import java.io.Serializable;

public class JsonRequestObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer quantita;
	private Integer prezzo;
	
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer descrizione) {
		this.quantita = descrizione;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer codice) {
		this.prezzo = codice;
	}
	@Override
	public String toString() {
		return "JsonInputObject [quantita=" + quantita + ", prezzo=" + prezzo + "]";
	}
	
}
