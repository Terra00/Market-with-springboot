package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("verdura")
public class Verdura extends Alimentari {

	private static final long serialVersionUID = 1L;
	
	private String colore;

	public Verdura() {
		super();
	}

	public Verdura(String descrizione, float prezzoUnitario, Pesatura confezionato, String colore) {
		super(descrizione, prezzoUnitario, confezionato);
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
		return "Verdura [colore=" + colore + ", getColore()=" + getColore() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione()
				+ ", getPrezzoUnitario()=" + getPrezzoUnitario() + ", getPesatura()=" + getPesatura()
				+ ", getReparto()=" + getReparto() + ", getClass()=" + getClass() + "]";
	}


}
