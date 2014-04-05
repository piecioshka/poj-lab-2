package pl.piecioshka.utils;

public class StringUtils {
    /**
     * Blokujemy możliwość stworzenia instancji klasy StringUtils.
     */
    private StringUtils() {
        System.out.println("Private constructor of StringUtils");
    }

    /**
     * Metoda powtarza string dowolną ilość razy.
     *
     * @param str   Powtarzany string
     * @param times Krotność - ile razy zostanie powtórzony.
     * @return Łańcuch znaków z powtarzającą się frazą.
     */
    public static java.lang.String repeat(java.lang.String str, int times) {
        return new java.lang.String(new char[times]).replace("\0", str);
    }
}
