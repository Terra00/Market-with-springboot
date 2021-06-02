package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("casalinghi")
public class Casalinghi extends Merce {

	private static final long serialVersionUID = 1L;

	public Casalinghi() {
		super();
	}

	public Casalinghi(String descrizione, float prezzoUnitario, Pesatura pesatura) {
		super(descrizione, prezzoUnitario, pesatura);
	}

	@Override
	public String toString() {
		return "Casalinghi [hashCode()=" + hashCode() + ", getId()=" + getId() + ", getDescrizione()="
				+ getDescrizione() + ", getPrezzoUnitario()=" + getPrezzoUnitario() + ", getPesatura()=" + getPesatura()
				+ ", getReparto()=" + getReparto() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ "]";
	}


}
