package pl.piecioshka.poj_lab_2;

public interface Builder {
    /**
     * Dodajemy tytuł do dokumentu.
     * Warunki:
     * - metoda musi być uruchomiona tylko raz, wpp. ustawiony zostanie tytuł w przekazany w pierwszej metodzie
     * - metoda musi uruchomić się na początku procesu budowania dokumentu, wpp. dokument zostanie pusty
     *
     * @param title Nazwa tytułu
     * @return Builder
     */
    public Builder addTitle(String title);

    /**
     * Ustawiamy tytuł dokumentu.
     * Warunki:
     * - metoda musi uruchomić się po ustawianiu tytułu w procesie budowania dokumentu, wpp. dokument będzie pusty
     *
     * @param author Nazwa autora, np. Imię i nazwisko
     * @return Builder
     */
    public Builder addAuthor(String author);

    /**
     * Dodajemy rozdział.
     * Warunki:
     * - metoda zadziała gdy dokument będzie miał ustawionego autora i tytuł, wpp. nic się nie stanie
     *
     * @param chapter Nazwa rozdziału.
     * @param level   Poziom zagłębienia rozdziału. Możliwe od 1 do 6 poziomów zagłębień.
     *                Nie można dodać podrozdziału gdy jest on o więcej niż 1 poziom pod poprzednim.
     * @return Builder
     */
    public Builder addChapter(String chapter, int level);

    /**
     * Dodajemy paragraf.
     * Warunki:
     * - metoda zadziała gdy dokument będzie miał ustawionego autora i tytuł, wpp. nic się nie stanie
     *
     * @param body Treść paragrafu.
     * @return Builder
     */
    public Builder addParagraph(String body);

    /**
     * Dodajemy element listy numerowanej.
     * Warunki:
     * - metoda zadziała gdy dokument będzie miał ustawionego autora i tytuł, wpp. nic się nie stanie
     *
     * @param name Treść elementu
     * @return Builder
     */
    public Builder addBulletListItem(String name);

    /**
     * Finalizacja budowania dokumentu:
     * Warunki:
     * - metoda musi być uruchomiona jako ostatnia, wpp. dalsze budowanie zostanie zignorowane
     */
    public void finish();
}
