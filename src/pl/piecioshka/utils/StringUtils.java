package pl.piecioshka.utils;

public class StringUtils {
    /**
     * Blokujemy możliwość stworzenia instancji klasy StringUtils.
     */
    private StringUtils() {
        // Private constructor of StringUtils
    }

    /**
     * Metoda powtarza string dowolną ilość razy.
     *
     * @param str   Powtarzany string
     * @param times Krotność - ile razy zostanie powtórzony.
     * @return Łańcuch znaków z powtarzającą się frazą.
     */
    public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
