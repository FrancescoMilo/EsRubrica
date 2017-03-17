 package it.polito.tdp.rubrica.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RubricaModel {

	// rappresenta l'insieme di tutte le voce della rubrica
	// ed i metodi per poter gestire tale insieme
	
	private List<VoceRubrica> rubrica; // solo lui sa che la rubirca è una lista
	
	public RubricaModel(){
		this.rubrica = new ArrayList<VoceRubrica>(); // solo il costruttore sa che la rubrica è una arraylist
		// cosi se capisco che devo usare una Linked anziche una Array basta solo cambiare il costruttore
		// perchè in tutto il modello io uso i metodi di list che valgono sia per Linked che Array
	}
	
	public boolean addVoce(VoceRubrica v){
		// aggiunge una nuova voce alla rubrica e restituisce true se aggiunta correttamente
		// se c'è gia do un errore, restituiendo false
		// v è la nuova voce da aggiungere
		if(rubrica.contains(v)==true) // contains controlla per ogni elemento della lista se questo è uguale a v. Uguale secondo il criterio di equals da noi ridefinito
			return false;
		else{
			rubrica.add(v);
			return true;
		}
	}
	
	public VoceRubrica finVoceByNome(String nome){
		// ricerca nella rubrica una voce che abbia il nome uguale a quello specificato
		// se esiste ritorna tale oggetto, altrimenti ritorna null
		for(VoceRubrica v : rubrica){
			if(v.getNome().equals(nome)==true)
				return v;
		} 
		
		return null;
	}
	
	public List<String> getNomi(){
		List<String> nomi = new LinkedList<String>();
		for(VoceRubrica v : rubrica)
			nomi.add(v.getNome());
		Collections.sort(nomi, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		return nomi;
	}
	
	// creo un piccolo main nel modello per testarlo.
	
	public static void main(String [] args){
		RubricaModel m = new RubricaModel();
		boolean r1 = m.addVoce(new VoceRubrica("Fulvio","fulvio.corno@polito.it","47271"));
		boolean r2 = m.addVoce(new VoceRubrica("Giovanni", "giovanni@polito.it", "573828"));
		boolean r3 = m.addVoce(new VoceRubrica("Fulvio", "fulvio.unito@polito.it", "685891"));
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		VoceRubrica v1 = m.finVoceByNome("Giovanni");
		VoceRubrica v2 = m.finVoceByNome("Piero");
		System.out.println(v1);
		System.out.println(v2);
	}
}
