import java.time.LocalDate;
import java.util.ArrayList;

abstract class Dyr {

	private ArrayList<Opphold> opphold = new ArrayList<Opphold>();
	private int dyrID;
	private String navn;

	public Dyr(int dyrID, String navn) {
		this.dyrID = dyrID;
		this.navn = navn;
	}

	public abstract double beregnNettoprisPrDøgn();

	public String getNavn() {
		return navn;
	}

	public boolean Overlapper(Opphold nyOpphold) {
		if(nyOpphold.overlapper(nyOpphold)) {
			return true;
		}
		return false;
	}

	public boolean registrerOppholdet(Opphold nyOpphold) {
		if(Overlapper(nyOpphold)) {
			return false;
		}else{
			opphold.add(nyOpphold);
			return true;
		}
	}

	public boolean deleteObjectOpphold(Opphold slettesOpphold) {
		opphold.remove(slettesOpphold);
		return true;
	}

	public boolean sjekkLedig(int nr) {
		for(int i = 0; i < opphold.size(); i++) {
			if(nr == opphold.get(i).getOppholdNr()) {
				return false;
			}
		}
		return true;
	}

	public Opphold getSpesifiktOpphold(LocalDate fra, LocalDate til) {
		for(Opphold o : opphold) {
			if(o.getFra().equals(fra) && o.getTil().equals(til)) {
				return o;
			}
		}
		return null;
	}

	public double getTillegg(Opphold nyttOpphold) {
		return nyttOpphold.beregnTillegg();
	}
}
