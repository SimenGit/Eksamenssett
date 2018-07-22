class Tillegg {

	private int nr;
	private String navn;
	private double pris;

	public Tillegg(int nr, String navn, double pris) {
		this.nr = nr;
		this.navn = navn;
		this.pris = pris;
	}

	public int getNr() {
		return nr;
	}
	public String getNavn() {
		return navn;
	}
	public double getPris() {
		return pris;
	}

	public String toString() {
		return "Tillegg: " + navn + ", nr: " + String.valueOf(nr) + " - " + String.valueOf(pris) + "kr.";
	}
}
