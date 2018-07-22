import java.util.ArrayList;
import java.time.LocalDate;

class Opphold {

	private int oppholdNr;
	private LocalDate datoFra;
	private LocalDate datoTil;
	private ArrayList<Tillegg> tillegg = new ArrayList<Tillegg>();

	public Opphold(LocalDate datoFra, LocalDate datoTil, ArrayList<Tillegg> tillegg, int oppholdNr) {
		this.datoFra = datoFra;
		this.datoTil = datoTil;
		this.tillegg = tillegg;
		this.oppholdNr = oppholdNr;
	}

	public LocalDate getFra() {
		return datoFra;
	}
	public LocalDate getTil() {
		return datoTil;
	}
	public int getOppholdNr() {
		return oppholdNr;
	}

	public boolean overlapper(Opphold opphold) {
		if(opphold.datoFra.plusDays(1).isBefore(datoFra) || opphold.datoTil.plusDays(1).isAfter(datoFra)) {
			return true;
		}
		return false;
	}

	public double beregnTillegg() {
		double pris = 0.0;
		for(Tillegg t : tillegg) {
			pris += t.getPris();
		}
		return pris;
	}
}
