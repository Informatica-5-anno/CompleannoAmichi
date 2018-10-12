package it.gov.itisfeltrinelli.amichi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Amico implements Comparable<Amico> {
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private Integer compleanno;
	
	public Amico(String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.compleanno=dataDiNascita.getMonthValue()*100+dataDiNascita.getDayOfMonth();
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

	public Integer getCompleanno() {
		return compleanno;
	}
    
	public int prossimaEta() {
		LocalDate oggi=LocalDate.now();
		int anni=oggi.getYear()-this.getDataDiNascita().getYear();
		if (this.getDataDiNascita().getMonthValue()<oggi.getMonthValue()) {
			anni++;
		}
		return anni;
	}
	@Override
	public int compareTo(Amico arg0) {
		// Per l'ordinamento confronta mese e giorno, non l'anno
		// due modi possibili
		/*
			LocalDate thisDate=LocalDate.of(arg0.getDataDiNascita().getYear(),
					                        this.dataDiNascita.getMonthValue(),
					                        this.dataDiNascita.getDayOfMonth());
			return thisDate.compareTo(arg0.getDataDiNascita());
		*/
	  //  Integer dt1=this.dataDiNascita.getMonthValue()*100+this.dataDiNascita.getDayOfMonth();
	  //  Integer dt2=arg0.getDataDiNascita().getMonthValue()*100+arg0.getDataDiNascita().getDayOfMonth();
	    return compleanno.compareTo(arg0.getCompleanno());
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return nome + " " + cognome + " data di nascita: " + dataDiNascita.format(formatter);
	}
	
	@Override
	public boolean equals(Object arg0) {
		return (this.cognome==((Amico)arg0).getCognome() && 
				this.nome==((Amico)arg0).getNome());
	}
}
