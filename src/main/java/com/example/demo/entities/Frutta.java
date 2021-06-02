package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("frutta")
public class Frutta extends Alimentari {

	private static final long serialVersionUID = 1L;
	private String colore;
	
	public Frutta() {
		super();
	}

	public Frutta(String descrizione, float prezzoUnitario, Pesatura pesatura, String colore) {
		super(descrizione, prezzoUnitario, pesatura);
		this.colore = colore;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public String toString() {
		return "Frutta [colore=" + colore + ", getColore()=" + getColore() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione()
				+ ", getPrezzoUnitario()=" + getPrezzoUnitario() + ", getPesatura()=" + getPesatura()
				+ ", getReparto()=" + getReparto() + ", getClass()=" + getClass() + "]";
	}



	
}
