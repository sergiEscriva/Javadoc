package exercici1;

/**
 * @author Pablo Motos
 * @version 1.332, 24/01/2024
 */
public class SocUtil{
    /**
     *
     * @param numero un numero entero
     * @return
     * @throws EsNegatiuEX
     * @deprecated este metodo esta obsoleto desde la version 1.2 usar el metodo {@link #esCapikua(int)} en su lugar
     *
     */
    public static boolean esCapicua(int numero) throws EsNegatiuEX {
    if (numero < 0) {
        throw new EsNegatiuEX();
    }
    int numAlReves = 0;
    int copia = numero;
    while (numero > 0) {
        numAlReves = numAlReves * 10 + numero % 10;
        numero /= 10;
    }
    return copia == numAlReves;
}

    /**
     *
     * @param numero un numero entero
     * @return
     * @throws EsNegatiuEX
     */
    public static boolean esCapikua(int numero) throws EsNegatiuEX {
    if (numero < 0) {
        throw new EsNegatiuEX();
    }
    String cadNum = numero + "";
    String numAlReves = (new StringBuilder(cadNum)).reverse().toString();
    return cadNum.equals(numAlReves);
}


    /**
     * @param numero
     * @return
     * @throws EsNegatiuEX
     */
    public static boolean esPrimer(int numero) throws EsNegatiuEX {
    if (numero < 0) {
        throw new EsNegatiuEX();
    }
    int limit = numero / 2 + 1;
    int div = 2;
    while (div < limit) {
        if (numero % div == 0){
            return false;
        }
        div++;
    }
    return true;
}

    /**
     *
     * @param numero
     * @return un long fact
     * @throws EsNegatiuEX
     * @see <a href="http://www.sangakoo.com/es/temas/el-factorial-de-un-numero">Sangaku Maths </a>
     */
    public static long getFactorial(int numero) throws EsNegatiuEX {
    if (numero < 0) {
        throw new EsNegatiuEX("no es pot calcular el factorial d'un número negatiu");
    }
    long fact = 1L;
    while (numero > 1) {
        fact *= numero;
        numero--;
    }
    return fact;
}
}