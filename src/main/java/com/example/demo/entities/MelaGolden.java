package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mela-golden")
public class MelaGolden extends Mela {

	private static final long serialVersionUID = 1L;

	public MelaGolden() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MelaGolden(float prezzoUnitario) {
		super("Mela Golden", prezzoUnitario, Pesatura.DA_PESARE, "giallo");
	}

	@Override
	public String toString() {
		return "MelaGolden [toString()=" + super.toString() + ", getColore()=" + getColore() + ", hashCode()="
				+ hashCode() + ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione()
				+ ", getPrezzoUnitario()=" + getPrezzoUnitario() + ", getPesatura()=" + getPesatura()
				+ ", getReparto()=" + getReparto() + ", getClass()=" + getClass() + "]";
	}




}
