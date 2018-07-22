import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class Kunde {
 private final int kundeID;
 private final String navn;
 private ArrayList<Dyr> dyrene = new ArrayList<Dyr>();

 	public Kunde(int kundeID, String navn) {
		this.kundeID = kundeID;
		this.navn = navn;
	}

	private boolean erRegistrert(Dyr dyr) {
			for(int i = 0; i < dyrene.size(); i++) {
				if(dyrene.get(i).getNavn() == dyr.getNavn()) {
					return true;
				}
			}
			return false;
	}

	private int generateOppholdNr() {
		boolean ledig = true;
		Random random = new Random();
		int tall;
		do {
			tall = random.nextInt(5000) + 5000;
			for(int i = 0; i < dyrene.size(); i++) {
				if(!dyrene.get(i).sjekkLedig(tall)) {
					ledig = false;
					break;
				}
			}
		}while(!ledig);
		return tall;
	}

	public boolean registrerOpphold(LocalDate datoFra, LocalDate datoTil, ArrayList<Tillegg> tillegg, Dyr dyr) {
		if(!erRegistrert(dyr)) {
			dyrene.add(dyr);
		}
		Opphold nyttOpphold = new Opphold(datoFra, datoTil, tillegg, generateOppholdNr());
		if(dyr.Overlapper(nyttOpphold)) {
			return false;
		}else{
			dyr.registrerOppholdet(nyttOpphold);
			return true;
		}
	}

	public double beregnPris(LocalDate fra, LocalDate til) {
		double pris = 0.0;
		boolean doggyDoggRabatt = false;
		boolean pusenRabatt = false;
		int antallDager =  (int) fra.until(til, java.time.temporal.ChronoUnit.DAYS);
		for(int i = 0; i < dyrene.size(); i++) {
			Opphold o = dyrene.get(i).getSpesifiktOpphold(fra, til);
			if(o != null) {
				double nettoPris = dyrene.get(i).beregnNettoprisPrDøgn() * antallDager;
				if(dyrene.get(i) instanceof Hund) {
					double tilleggDogg = dyrene.get(i).getTillegg(o);
					if(!doggyDoggRabatt) {
						pris += nettoPris;
						doggyDoggRabatt = true;
					}else{
						pris += nettoPris * 0.75;
					}
				}else if(dyrene.get(i) instanceof Katt) {
					double tilleggPus = dyrene.get(i).getTillegg(o);
					if(!pusenRabatt) {
						pris += nettoPris;
						pusenRabatt = true;
					}else{
						pris += nettoPris * 0.75;
					}
				}
			}
		}
		return pris;
	}
}
