package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("alimentari")
public class Alimentari extends Merce {

	private static final long serialVersionUID = 1L;

	public Alimentari() {
		super();
	}

	public Alimentari(String descrizione, float prezzoUnitario, Pesatura pesatura) {
		super(descrizione, prezzoUnitario, pesatura);
	}

	@Override
	public String toString() {
		return "Alimentari [getId()=" + getId() + ", getDescrizione()=" + getDescrizione() + ", getPrezzoUnitario()="
				+ getPrezzoUnitario() + ", getPesatura()=" + getPesatura() + ", getReparto()=" + getReparto() + "]";
	}


}
