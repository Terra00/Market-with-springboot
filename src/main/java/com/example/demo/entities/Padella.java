package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("padella")
public class Padella extends Casalinghi {

	private static final long serialVersionUID = 1L;
	private Integer diametro;
	private Integer altezza;
	
	public Padella() {}
	
	public Padella(String descrizione, float prezzoUnitario, Integer diametro, Integer altezza) {
		super(descrizione, prezzoUnitario, Pesatura.CONFEZIONATO);
		this.diametro = diametro;
		this.altezza = altezza;
	}

	public Integer getDiametro() {
		return diametro;
	}

	public void setDiametro(Integer diametro) {
		this.diametro = diametro;
	}

	public Integer getAltezza() {
		return altezza;
	}

	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}

	@Override
	public String toString() {
		return "Padella [diametro=" + diametro + ", altezza=" + altezza + ", getDiametro()=" + getDiametro()
				+ ", getAltezza()=" + getAltezza() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getDescrizione()=" + getDescrizione() + ", getPrezzoUnitario()="
				+ getPrezzoUnitario() + ", getPesatura()=" + getPesatura() + ", getReparto()=" + getReparto()
				+ ", getClass()=" + getClass() + "]";
	}




}
