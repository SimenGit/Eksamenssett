class Hund extends Dyr {

	private int str;

	public Hund(int dyrID, String navn, int str) {
		super(dyrID, navn);
		this.str = str;
	}

	@Override
	public double beregnNettoprisPrDøgn() {
		double pris = 360.0;
		if(str == 2) {
			pris += 30.0;
		}else if(str == 3) {
			pris += 50.0;
		}
		return pris;
	}
}
