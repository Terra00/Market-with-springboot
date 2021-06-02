package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mela-annurca")
public class MelaAnnurca extends Mela {

	private static final long serialVersionUID = 1L;

	public MelaAnnurca() {
		super();
	}

	public MelaAnnurca(String descrizione, float prezzoUnitario, String colore) {
		super(descrizione, prezzoUnitario, Pesatura.DA_PESARE, "Rossa e Gialla");
	}

	@Override
	public String toString() {
		return "MelaAnnurca [toString()=" + super.toString() + ", getColore()=" + getColore() + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione()
				+ ", getPrezzoUnitario()=" + getPrezzoUnitario() + ", getPesatura()=" + getPesatura()
				+ ", getReparto()=" + getReparto() + ", getClass()=" + getClass() + "]";
	}



}
