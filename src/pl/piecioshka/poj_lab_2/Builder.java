package pl.piecioshka.poj_lab_2;

public interface Builder {
    /**
     * Dodajemy tytuł do dokumentu.
     * Jak wiadomo każdy dokument ma tylko jeden tytuł, 
     * tak więc uruchomienie tej metody:
     *  - więcej niż jeden raz zakończy się wyjątkiem Exception
     *  - nie uruchomienie jej na początku budowania zakończy się wyjątkiem Exception
     * @param title Nazwa tytułu
     * @return Builder
     */
    public Builder addTitle(String title);

    /**
     * Ustawiamy tytuł dokumentu.
     * Metoda musi zostać uruchomiona tylko jeden raz zaraz po definicji tytułu 
     * dokumentu, w przeciwnym przypadku rzuci wyjątkiem Exception
     * @param author Nazwa autora, np. Imię i nazwisko
     * @return Builder
     */
    public Builder addAuthor(String author);

    /**
     * Dodajemy rozdział.
     * @param chapter Nazwa rozdziału.
     * @param level Poziom zagłębienia rozdziału
     * @return Builder
     */
    public Builder addChapter(String chapter, Integer level);

    /**
     * Dodajemy paragraf.
     * @param body Treść paragrafu.
     * @return Builder
     */
    public Builder addParagraph(String body);

    /**
     * Dodajemy element listy numerowanej.
     * @param name Treść elementu
     * @return Builder
     */
    public Builder addBulletListItem(String name);
}
