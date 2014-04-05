package pl.piecioshka.poj_lab_2;

import java.util.ArrayList;

public class HTMLBuilder implements Builder {
    private final ArrayList<String> list;

    public HTMLBuilder() {
        this.list = new ArrayList<String>();
    }

    public void buildHTML() {
        for (Object item : this.list) {
            System.out.println((String) item);
        }
    }

    /**
     * Flaga mówiąca czy autor został ustawiony
     */
    private boolean isSetAuthor = false;

    /**
     * Flaga mówiąca czy tytuł został ustawiony
     */
    private boolean isSetTitle = false;

    /**
     * Flaga mówiąca czy dowolny element dokumentu (rozdział, paragraf, element listy) został ustawiony.
     */
    private boolean isSetItem = false;

    /**
     * Aktualny poziom zagnieżdżenia nagłówka.
     */
    private Integer headerLevel = 0;


    @Override
    public Builder addTitle(String title) {
        if (!this.isSetTitle && !this.isSetAuthor && !this.isSetItem) {
            this.list.add("<h1>" + title + "</h1>");
            this.isSetTitle = true;
        }
        return this;
    }

    @Override
    public Builder addAuthor(String author) {
        if (this.isSetTitle && !this.isSetAuthor && !this.isSetItem) {
            this.list.add("<h2>" + author + "</h2>");
            this.isSetAuthor = true;
        }
        return this;
    }

    @Override
    public Builder addChapter(String chapter, Integer level) {
        if (this.isSetTitle && this.isSetAuthor) {
            if (level >= 1 && level <= 6) {
                if (level > headerLevel && level == headerLevel + 1 || level < headerLevel) {
                    this.list.add("<h" + level + ">" + chapter + "</h" + level + ">");
                    this.isSetItem = true;
                    this.headerLevel = level;
                }
            }
        }
        return this;
    }

    @Override
    public Builder addParagraph(String body) {
        if (this.isSetTitle && this.isSetAuthor) {
            this.list.add("<p>" + body + "</p>");
            this.isSetItem = true;
        }
        return this;
    }

    @Override
    public Builder addBulletListItem(String name) {
        if (this.isSetTitle && this.isSetAuthor) {
            this.list.add("<li>" + name + "</li>");
            this.isSetItem = true;
        }
        return this;
    }
}
