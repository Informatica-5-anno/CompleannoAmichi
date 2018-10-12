package it.gov.itisfeltrinelli.amichi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AmichiList {
	private List<Amico> amici;

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
	    	}
	    }
	}
	
	public void stampa( ) {
		Iterator<Amico> i=amici.iterator();
	    while (i.hasNext()) {
	    	System.out.println(i.next());
	    }
	}
	
}
