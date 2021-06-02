package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="etichette")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@DiscriminatorValue("OF")
public class Pesata implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long barcode;
	private Integer idArticolo;
	private Integer quantita;
	
	@Column(name="unit_price", precision = 6, scale = 2)
	private Float prezzoUnitario;
	
	@Column(name="weight", precision = 6, scale = 2)
	private Float peso;
	
	@Column(name="totale_price", precision = 8, scale = 2)
	private Float prezzoTotale;
	
	public Pesata() {}

	public Pesata(Integer idArticolo, Integer quantita, Float prezzoUnitario, Float peso,
			Float prezzoTotale) {
		super();
		
		this.idArticolo = idArticolo;
		this.quantita = quantita;
		setPrezzoUnitario(prezzoUnitario);
		setPeso(peso);
		setPrezzoTotale(prezzoTotale);
	}

	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public Integer getIdArticolo() {
		return idArticolo;
	}

	public void setIdArticolo(Integer idArticolo) {
		this.idArticolo = idArticolo;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(Float prezzoUnitario) {
		this.prezzoUnitario = Math.round(prezzoUnitario*100)/100f;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = Math.round(peso*100)/100f;
	}

	public Float getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(Float prezzoTotale) {
		this.prezzoTotale = Math.round(prezzoTotale*100)/100f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesata other = (Pesata) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pesata [barcode=" + barcode + ", idArticolo=" + idArticolo + ", quantita=" + quantita
				+ ", prezzoUnitario=" + prezzoUnitario + ", peso=" + peso + ", prezzoTotale=" + prezzoTotale + "]";
	}

	
}	

