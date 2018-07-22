class Katt extends Dyr {

	private boolean maaBorstes;

	public Katt(int dyrID, String navn, boolean maaBorstes) {
		super(dyrID, navn);
		this.maaBorstes = maaBorstes;
	}

	@Override
	public double beregnNettoprisPrDøgn() {
		double pris = 170;
		if(maaBorstes) {
			pris += 20.0;
		}
		return pris;
	}
}
