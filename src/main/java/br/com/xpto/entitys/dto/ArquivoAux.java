package br.com.xpto.entitys.dto;

public class ArquivoAux {

	private String idIbge;
	private String estado;
	private String name;
	private String capital;
	private String longitude;
	private String latitude;
	private String noAccents;
	private String alternativeNames;
	private String microRegion;
	private String mesoRegion;

	public ArquivoAux(

			String idIbge, String estado, String name, String capital, String longitude, String latitude,
			String noAccents, String alternativeNames, String microRegion, String mesoRegion) {
		this.idIbge = idIbge;
		this.estado = estado;
		this.name = name;
		this.capital = capital;
		this.longitude = longitude;
		this.latitude = latitude;
		this.noAccents = noAccents;
		this.alternativeNames = alternativeNames;
		this.microRegion = microRegion;
		this.mesoRegion = mesoRegion;
	}

	public String getIdIbge() {
		return idIbge;
	}

	public void setIdIbge(String idIbge) {
		this.idIbge = idIbge;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
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

	@Override
	public String toString() {
		return "ArquivoAux [idIbge=" + idIbge + ", estado=" + estado + ", name=" + name + ", capital=" + capital
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", noAccents=" + noAccents
				+ ", alternativeNames=" + alternativeNames + ", microRegion=" + microRegion + ", mesoRegion="
				+ mesoRegion + "]";
	}


}
