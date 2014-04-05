package pl.piecioshka.poj_lab_2;

import java.util.ArrayList;
import pl.piecioshka.utils.StringUtils;

public class TextBuilder implements Builder {
    private final ArrayList<String> list;

    public TextBuilder() {
        this.list = new ArrayList<String>();
    }

    public void buildText() {
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
            this.list.add("Tytuł: " + title);
            this.isSetTitle = true;
        }
        return this;
    }

    @Override
    public Builder addAuthor(String author) {
        if (this.isSetTitle && !this.isSetAuthor && !this.isSetItem) {
            this.list.add("Autor: " + author + "\n");
            this.isSetAuthor = true;
        }
        return this;
    }

    @Override
    public Builder addChapter(String chapter, Integer level) {
        if (this.isSetTitle && this.isSetAuthor) {
            if (level >= 1 && level <= 6) {
                if (level > headerLevel && level == headerLevel + 1 || level < headerLevel) {
                    this.list.add("\n" + StringUtils.repeat(" ", level - 1) + "Rozdział: " + chapter + "\n");
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
            this.list.add("Paragraf: " + body);
            this.isSetItem = true;
        }
        return this;
    }

    @Override
    public Builder addBulletListItem(String name) {
        if (this.isSetTitle && this.isSetAuthor) {
            this.list.add(" - " + name);
            this.isSetItem = true;
        }
        return this;
    }
}
