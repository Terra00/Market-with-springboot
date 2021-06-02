package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@NamedQueries({
	@NamedQuery(name = "Merce.findMerceByReparto",
			query = "select m from Merce m where m.reparto.id = ?1")
})
@Table(name="prodotti")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // è il default
@DiscriminatorColumn(name="type")
@DiscriminatorValue("merce")
public class Merce implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = null;

	@Column(name="description")
	@NonNull // spring
	private String descrizione;
	
	@Column(name="unit_price", precision = 6, scale = 2)
	@NonNull // spring
	private float prezzoUnitario;

	// soggetta a pesatura e impachettata
	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "smallint")
	private Pesatura pesatura;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reparto")
	private Reparto reparto;
	
	public Merce() {}

	public Merce(String descrizione, float prezzoUnitario, Pesatura pesatura2) {
		super();
		this.descrizione = descrizione;
		this.prezzoUnitario = prezzoUnitario;
		this.pesatura = pesatura2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Merce other = (Merce) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*********************** GETTER E SETTER ***************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public Pesatura getPesatura() {
		return pesatura;
	}

	public void setPesatura(Pesatura pesatura) {
		this.pesatura = pesatura;
	}
	
	public Reparto getReparto() {
		return reparto;
	}

	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

	@Override
	public String toString() {
		return "Merce [id=" + id + ", descrizione=" + descrizione + ", prezzoUnitario=" + prezzoUnitario + ", pesatura="
				+ pesatura + ", reparto=" + reparto + "]";
	}
	
	
}
