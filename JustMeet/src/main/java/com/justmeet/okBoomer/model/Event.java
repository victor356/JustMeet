/**
 * 
 */
package com.justmeet.okBoomer.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;




import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author Cippitelli, Rinaldi
 *
 */
 

@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name="id") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


	@Column(name="titolo") 
	private String titolo;
	@Enumerated(EnumType.ORDINAL)
    @Column(name="categoria") 
	private Category categoria;
    @Column(name="descrizione") 
	private String descrizione;
    @Column(name="dataEvento") 
	private Date dataEvento;
    @Column(name="prezzo") 
	private float prezzo;
    @Column(name="cauzione") 
	private boolean cauzione;
    
    @Column(name="qtaCauzione")
	private float qtaCauzione;
    @Column(name="scadenzaPagamento") 
	private Date scadenzaPagamento;
    @Column(name="citta")
    private String citta;
    
    @Column(name="userOwner")
    private String owner;


	@Enumerated(EnumType.ORDINAL)
	@Transient
	private Status stato;

	
	@OneToMany(mappedBy="event")
	private List<EventUser> eventsPartecipated;



    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Category getCategoria() {
		return categoria;
	}

	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isCauzione() {
		return cauzione;
	}

	public void setCauzione(boolean cauzione) {
		this.cauzione = cauzione;
	}

	public float getQtaCauzione() {
		return qtaCauzione;
	}

	public void setQtaCauzione(float cauzione) {
		this.qtaCauzione = cauzione;
	}

	public Date getScadenzaPagamento() {
		return scadenzaPagamento;
	}

	public void setScadenzaPagamento(Date scadenzaPagamento) {
		this.scadenzaPagamento = scadenzaPagamento;
	}
	
	/**
	 * @return the stato
	 */
	public Status getStato() {
		return stato;
	}


	/**
	 * @param stato the stato to set
	 */
	public void setStato(Status stato) {
		this.stato = stato;
	}



    public List<EventUser> getEventsPartecipated() {
		return eventsPartecipated;
	}


	public void setEventsPartecipated(List<EventUser> eventsPartecipated) {
		this.eventsPartecipated = eventsPartecipated;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}



	
	



}
