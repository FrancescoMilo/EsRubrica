package it.polito.tdp.rubrica.model;

public class VoceRubrica {
	
	// rappresenta un singolo elemento della rubrica
	// questo tipo di oggetto si chiama Java BEAN ( POJO Plain Old Java Object)
	private String nome;
	private String mail;
	private String telefono; // perchè se ci sono zeri davanti ed è integer allora non andrebbe bene
	
	// regola generale: se non ha senso sommarli, non sono numeri ma stringhe.
	
	public VoceRubrica(String nome, String mail, String telefono) {
		this.nome = nome;
		this.mail = mail;
		this.telefono = telefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	// ridefinisco io il metodo equals e lo faccio con tasto dx..source..generate hashcode e equals
	// devo solo specificare i campi con cui fare equals e in questo caso noi sappiamo che nella rubrica
	// non possono esserci due persone con lo stesso nome. per questo spunto solo nome
	// NOTA : se non ridefinisco equals il metodo contains non funziona
	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoceRubrica other = (VoceRubrica) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VoceRubrica [nome=" + nome + ", mail=" + mail + ", telefono=" + telefono + "]";
	}
	
	

}
