package it.gov.itisfeltrinelli.amichi;
import java.time.LocalDate;


public class Amico implements Comparable<Amico> {
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	
	public Amico(String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	@Override
	public int compareTo(Amico arg0) {
		return this.getDataDiNascita().compareTo(arg0.getDataDiNascita());
	}

	@Override
	public String toString() {
		return "Amico [nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita + "]";
	}
	
	@Override
	public boolean equals(Object arg0) {
		return (this.cognome==((Amico)arg0).getCognome() && 
				this.nome==((Amico)arg0).getNome());
	}
	
}
