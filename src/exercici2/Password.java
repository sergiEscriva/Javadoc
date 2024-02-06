package exercici2;

/**
 * @author José Luis Rodríguez Zapatero
 * @version 1.2
 * Este progrma comprueba la seguridada de una contraseña
 */
public final class Password {
	private final static int LONG_DEF = 8;

	private int longitud;

	private final String contrasenya;

	/**
	 * @return Es el getter de longitud
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud Es el setter de longitud
	 */

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return Es el getter de contrasenya
	 */
	public String getcontrasenya() {
		return contrasenya;
	}

	/**
	 * Genera una contraseña aleatoria
	 *
	 * @return
	 * @see Math#random
	 * @see Math#floor(double)
	 */
	public String generaPassword() {
		String password = "";
		for (int i = 0; i < longitud; i++) {
			int eleccion = ((int) Math.floor(Math.random() * 3 + 1));

			if (eleccion == 1) {
				char minusculas = (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
				password += minusculas;
			} else {
				if (eleccion == 2) {
					char mayusculas = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
					password += mayusculas;
				} else {
					char numeros = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
					password += numeros;
				}
			}
		}
		return password;
	}

	/**
	 * @return un boolean
	 * El qe fa es comprobar su una contrasenya es segura o insegura
	 * @see String#charAt(int)
	 */
	public boolean esFuerte() {
		int cuentanumeros = 0;
		int cuentaminusculas = 0;
		int cuentamayusculas = 0;

		for (int i = 0; i < contrasenya.length(); i++) {
			if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
				cuentaminusculas += 1;
			} else {
				if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
					cuentamayusculas += 1;
				} else {
					cuentanumeros += 1;
				}
			}
		}
		return cuentanumeros >= 5 && cuentaminusculas >= 1 && cuentamayusculas >= 2;
	}

	/**
	 * @return un boolean
	 * El que fa es comprobar su una contrasenya es segura o insegura
	 * @deprecated a partir de la versio 1.2 usar el metode {@link #esFuerte()}
	 */
	public boolean esFort() {
		int cuentanumeros = 0;
		int cuentaminusculas = 0;
		int cuentamayusculas = 0;

		for (int i = 0; i < contrasenya.length(); i++) {
			if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
				cuentaminusculas += 1;
			} else {
				if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
					cuentamayusculas += 1;
				} else {
					cuentanumeros += 1;
				}
			}
		}
		return cuentanumeros >= 3 && cuentaminusculas >= 1 && cuentamayusculas >= 1;
	}

	public Password() {
		this(LONG_DEF);
	}

	public Password(int longitud) {
		this.longitud = longitud;
		contrasenya = generaPassword();
	}
}