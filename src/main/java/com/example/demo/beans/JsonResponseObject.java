package com.example.demo.beans;

import java.io.Serializable;

public class JsonResponseObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer quantita;
	private Integer prezzo;
	private Integer count;
	public JsonResponseObject() {}
	public JsonResponseObject(Integer quantita, Integer prezzo, Integer count) {
		super();
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.count = count;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "JsonResponseObject [descrizione=" + quantita + ", codice=" + prezzo + ", count=" + count + "]";
	}
	
	
}
