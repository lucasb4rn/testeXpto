package br.com.xpto.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String microRegion;
	private String mesoRegion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMicroRegion() {
		return microRegion;
	}

	public void setMicroRegion(String microRegion) {
		this.microRegion = microRegion;
	}

	public String getMesoRegion() {
		return mesoRegion;
	}

	public void setMesoRegion(String mesoRegion) {
		this.mesoRegion = mesoRegion;
	}


}
