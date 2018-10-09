package it.gov.itisfeltrinelli.amichi;

import java.time.LocalDate;

public class TestaAmichi {

	public static void main(String[] args) {
		AmichiList aml=new AmichiList();
		
		aml.AddAmico("kim", "kardashian", LocalDate.of(1980,10,21));
		aml.AddAmico("sharon", "stone", LocalDate.of(1958,3,10));
		aml.AddAmico("belen", "rodriguez", LocalDate.of(1984,9,20));
		aml.AddAmico("rita", "ora", LocalDate.of(1990,11,26));
		
		aml.stampa();
		Amico a=aml.cercaProssimo(LocalDate.of(2018, 10, 19), 4);
		if (a!=null) { 
			System.out.println("Prossimo compleanno "+a.toString());
		}
		System.out.println("Cancello la Stone");
		aml.deleteAmico(new Amico("sharon", "stone", LocalDate.of(1965,3,27)));
		aml.stampa();
	}
}
