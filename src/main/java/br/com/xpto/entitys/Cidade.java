package br.com.xpto.entitys;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cidade {

	@Id
	private Integer idIbge;

	@ManyToOne
	@NotNull
	private Estado estado;

	private String name;

	@Enumerated(EnumType.STRING)
	private Capital capital;

	private double longitude;
	private double latitude;
	private String nomeSecundario;

	@ManyToOne
	private Regiao regiao;

	public Cidade() {}
	
	public Cidade(

			Integer idIbge, @NotNull Estado estado, String name, Capital capital, double longitude, double latitude,
			String nomeSecundario, Regiao regiao) {
		this.idIbge = idIbge;
		this.estado = estado;
		this.name = name;
		this.capital = capital;
		this.longitude = longitude;
		this.latitude = latitude;
		this.nomeSecundario = nomeSecundario;
		this.regiao = regiao;
	}

	public Integer getIdIbge() {
		return idIbge;
	}

	public void setIdIbge(Integer idIbge) {
		this.idIbge = idIbge;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getNomeSecundario() {
		return nomeSecundario;
	}

	public void setNomeSecundario(String nomeSecundario) {
		this.nomeSecundario = nomeSecundario;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

}
