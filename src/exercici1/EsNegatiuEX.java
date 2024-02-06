package exercici1;

public class EsNegatiuEX extends Exception {

	public EsNegatiuEX() {
		super("el valor no pot ser negatiu");
	}

	public EsNegatiuEX(String msg) {
		super(msg);
	}
}
