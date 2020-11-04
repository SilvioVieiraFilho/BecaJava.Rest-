package br.app.model;

public class Voto {

	private Long Id;

	private Candidato Candidato; // ASSOCIA TIPO DA CLASSE CANDIDATO E ID

	private Eleitor Eleitor; // ASSOCIA TIPO DA CLASSE

	private Zona zona;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Candidato getCandidato() {
		return Candidato;
	}

	public void setCandidato(Candidato candidato) {
		Candidato = candidato;
	}

	public Eleitor getEleitor() {
		return Eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		Eleitor = eleitor;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}
