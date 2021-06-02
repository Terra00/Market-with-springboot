package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("asparagi")
public class Asparagi extends Verdura {

	private static final long serialVersionUID = 1L;

	public Asparagi() {
		super();
	}

	public Asparagi(String descrizione, float prezzoUnitario, String colore) {
		super(descrizione, prezzoUnitario, Pesatura.CONFEZIONATO, colore);
	}

	@Override
	public String toString() {
		return "Asparagi [getColore()=" + getColore() + ", toString()=" + super.toString() + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione()
				+ ", getPrezzoUnitario()=" + getPrezzoUnitario() + ", getPesatura()=" + getPesatura()
				+ ", getReparto()=" + getReparto() + ", getClass()=" + getClass() + "]";
	}




}
