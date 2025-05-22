package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class AmichiList {
	private List<Amico> amici;
//	private int nAmici=0;
	private IntegerProperty nAmici=new SimpleIntegerProperty();

	public AmichiList() {
		super();
		amici=new ArrayList<Amico>();
	}
	public void AddAmico(String nome, String cognome, LocalDate dataDiNascita) {
		Amico a=searchAmico(nome,cognome);
		
		if (null == a) {  // aggiunge un nuovo amico
			amici.add(new Amico(nome, cognome, dataDiNascita));
		} else {       // amico esistente, modifica
			a.setCognome(cognome);
			a.setNome(nome);
			a.setDataDiNascita(dataDiNascita);
		}
		Collections.sort(amici);
		nAmici.set(nAmici.get()+1);
	}

	
	public List<Amico> getAmici() {
		return amici;
	}
	
	public Amico searchAmico(String nome, String cognome) {
		Iterator<Amico> i=amici.iterator();
		
	    while (i.hasNext()) {
	    	Amico a=i.next();
	    	if (a.getNome().equals(nome) && a.getCognome().equals(cognome)) {
	    		return a;
	    	}
	    }
	    return null;
	}
	
	public Amico cercaProssimo(LocalDate oggi, int giorni) {
		Iterator<Amico> i=amici.iterator();
		
	    while (i.hasNext()) {
	    	Amico a=i.next();
	        LocalDate ld=LocalDate.ofYearDay(((oggi.getMonthValue()>a.getDataDiNascita().getMonthValue()) ? oggi.getYear()+1 : oggi.getYear()),a.getDataDiNascita().getDayOfYear());
	        
	    	if ((oggi.isBefore(ld) || oggi.isEqual(ld)) && !oggi.isBefore(ld.minusDays(giorni))) {
	    		return a;
	    	}
	    }
	    return null;
	}

	public void deleteAmico(Amico da) {
		Iterator<Amico> i=amici.iterator();
		
	    while (i.hasNext()) {
	    	if (da.equals(i.next())) {
	    		i.remove();
	    		nAmici.set(nAmici.get()-1);
	    	}
	    }
	}
		
	public IntegerProperty nAmiciProperty() {
		return nAmici;
	}
	
	public int getnAmici() {
		return nAmici.get();
	}
	
	
	public void stampa( ) {
		Iterator<Amico> i=amici.iterator();
	    while (i.hasNext()) {
	    	System.out.println(i.next());
	    }
	}
	
}
