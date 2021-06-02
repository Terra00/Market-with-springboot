package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mela")
public class Mela extends Frutta {

	private static final long serialVersionUID = 1L;

	public Mela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mela(String descrizione, float prezzoUnitario, Pesatura pesatura, String colore) {
		super(descrizione, prezzoUnitario, pesatura, colore);
	}

	@Override
	public String toString() {
		return "Mela [getColore()=" + getColore() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione() + ", getPrezzoUnitario()="
				+ getPrezzoUnitario() + ", getPesatura()=" + getPesatura() + ", getReparto()=" + getReparto()
				+ ", getClass()=" + getClass() + "]";
	}



}
