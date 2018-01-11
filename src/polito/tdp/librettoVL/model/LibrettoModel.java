package polito.tdp.librettoVL.model;

import java.util.ArrayList;
import java.util.List;

public class LibrettoModel {
	
	private List<Esame> esami;

	public LibrettoModel() {
		super();
		this.esami = new ArrayList<Esame>();
	}
	
	/** 
	 * Aggiunge un nuovo esame all'elenco degli esami presenti
	 * Verificando che non ci sia già
	 * @param e
	 * @return true se l'ha inserito, false se esisteva già e quindi non l'ha inserito
	 */
	public boolean addEsame(Esame e) {
		if(!esami.contains(e)) {
		    esami.add(e);
		    return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste, lo restituisce, altrimenti restituisce null.
	 * @param codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non l'ha trovato
	 */
	public Esame trovaEsame(String codice) {
		int pos = this.esami.indexOf(new Esame(codice, null, null));
		if(pos == -1) {
			return null;
		} else {
			return esami.get(pos);
		}
	}
	
	
	

}
