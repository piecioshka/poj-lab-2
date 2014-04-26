package pl.piecioshka.poj_lab_2;

import pl.piecioshka.utils.StringUtils;

import java.util.ArrayList;

public class TextBuilder implements Builder {
    private final ArrayList<String> list;

    public TextBuilder() {
        this.list = new ArrayList<String>();
    }

    public String buildText() {
        String result = "";
        for (Object item : this.list) {
            result += (String) item;
        }
        return result;
    }

    // Flaga mówiąca czy autor został ustawiony
    private boolean isSetAuthor = false;

    // Flaga mówiąca czy tytuł został ustawiony
    private boolean isSetTitle = false;

    // Flaga mówiąca czy dowolny element dokumentu (rozdział, paragraf, element listy) został ustawiony.
    private boolean isSetItem = false;

    // Flaga mówi, czy chcemy tworzyć listę
    private boolean isStartList = false;

    // Flaga mówi, czy dokument jest buildable
    private boolean isBuildable = true;

    // Aktualny poziom zagnieżdżenia nagłówka.
    private int headerLevel = 0;


    @Override
    public TextBuilder addTitle(String title) {
        assert this.isSetTitle : "Tytuł musi zostać uruchomiony tylko jeden raz";
        assert this.isSetAuthor : "Ustawienie tytułu może być uruchomione tylko jeden raz";
        assert this.isBuildable : "Dokument musi być w trybie budowy";
        assert !this.isSetItem : "";
        assert this.isStartList: "";

        this.list.add("Tytuł: " + title);
        this.isSetTitle = true;

        return this;
    }

    @Override
    public TextBuilder addAuthor(String author) {
        assert this.isSetAuthor : "Tytuł musi zostać uruchomiony tylko jeden raz";
        assert this.isSetTitle || this.isSetItem || this.isStartList : "Ustawienie autora może być uruchomione tylko jeden raz";
        assert this.isBuildable  : "Dokument musi być w trybie budowy";

        this.list.add("Autor: " + author + "\n");
        this.isSetAuthor = true;

        return this;
    }

    @Override
    public TextBuilder addChapter(String chapter, int level) {
        assert this.isSetTitle : "Dodać rozdział można tylko gdy ustawimy autora";
        assert this.isSetAuthor : "Dodać rozdział można tylko gdy ustawimy autora";
        assert this.isBuildable  : "Dokument musi być w trybie budowy";
        assert level >= 1 && level <= 4 : "Nie obsługujemy nagłówków typu " + level;
        assert level > headerLevel && level == headerLevel + 1 || level < headerLevel : "Poziom nagłówków nie można ";

        if (this.isStartList) {
            this.list.add("\n");
            this.isStartList = false;
        }

        this.list.add("\n" + StringUtils.repeat(" ", level - 1) + "Rozdział: " + chapter + "\n");
        this.isSetItem = true;
        this.headerLevel = level;

        return this;
    }

    @Override
    public TextBuilder addParagraph(String body) {
        assert this.isSetTitle : "Brak ustawienia tytułu dokumentu";
        assert this.isSetAuthor : "Brak ustawienie autora dokumentu";
        assert this.isBuildable : "Dokument musi być w trybie budowy";

        if (this.isStartList) {
            this.list.add("\n");
            this.isStartList = false;
        }

        this.list.add("Paragraf: " + body + "\n");
        this.isSetItem = true;

        return this;
    }

    @Override
    public TextBuilder addBulletListItem(String name) {
        assert this.isSetTitle : "Brak ustawienia tytułu dokumentu";
        assert this.isSetAuthor : "Brak ustawienie autora dokumentu";
        assert this.isBuildable : "Dokument musi być w trybie budowy";

        if (!this.isStartList) {
            this.list.add("\n");
        }

        this.list.add(" - " + name);
        this.isStartList = true;

        return this;
    }

    @Override
    public void finish() {
        if (this.isStartList) {
            this.list.add("\n");
            this.isStartList = false;
        }

        this.isBuildable = false;
    }
}
