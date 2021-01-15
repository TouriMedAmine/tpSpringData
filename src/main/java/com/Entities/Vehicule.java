package com.Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String codeInterne;
	private String immatricule;
	
	public Vehicule() {
		super();
	}

	public Vehicule(String codeInterne, String immatricule) {
		super();
		this.codeInterne = codeInterne;
		this.immatricule = immatricule;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeInterne() {
		return codeInterne;
	}
	public void setCodeInterne(String codeInterne) {
		this.codeInterne = codeInterne;
	}

	public String getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}
}
