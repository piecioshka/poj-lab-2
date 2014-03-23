package app;

public interface Builder {
    /**
     * Dodajemy tytuł do dokumentu.
     * Jak wiadomo każdy dokument ma tylko jeden tytuł, 
     * tak więc uruchomienie tej metody:
     *  - więcej niż jeden raz zakończy się wyjątkiem Exception
     *  - nie uruchomienie jej na początku budowania zakończy się wyjątkiem Exception
     * @param title
     * @return Builder
     */
    public Builder addTitle(String title);
    
    /**
     * Ustawiamy tytuł dokumentu.
     * Metoda musi zostać uruchomiona tylko jeden raz zaraz po definicji tytułu 
     * dokumentu, w przeciwnym prypadku rzuci wyjątkiem Exception
     * @param author
     * @return 
     */
    public Builder addAuthor(String author);
    
    /**
     * Dodajemy
     * @param chapter
     * @return 
     */
    public Builder addChapter(String chapter);
    public Builder addSubChapter(String chapter);
    public Builder addParagraph(String body);
    public Builder addBulletedListItem(String name);
}
