package com.example.demo.beans;

import java.io.Serializable;

public class PesataRequest implements Serializable{
	
	private Integer idProdotto;
	private Integer quantita;
	private Float prezzo;
	public PesataRequest() {
	}
	public Integer getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(Integer idArticolo) {
		this.idProdotto = idArticolo;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public Float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Float prezzoUnitario) {
		this.prezzo = prezzoUnitario;
	}
	@Override
	public String toString() {
		return "PesataRequest [idArticolo=" + idProdotto + ", quantita=" + quantita + ", prezzoUnitario="
				+ prezzo + "]";
	}
}
