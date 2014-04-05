package pl.piecioshka.poj_lab_2;

import java.util.ArrayList;

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


    @Override
    public Builder addTitle(String title) {
        if (!this.isSetTitle && !this.isSetAuthor && !this.isSetItem) {
            this.list.add(title);
            this.isSetTitle = true;
        }
        return this;
    }

    @Override
    public Builder addAuthor(String author) {
        if (this.isSetTitle && !this.isSetAuthor && !this.isSetItem) {
            this.list.add(author + "\n");
            this.isSetAuthor = true;
        }
        return this;
    }

    @Override
    public Builder addChapter(String chapter, Integer level) {
        if (this.isSetTitle && this.isSetAuthor) {
            if (level > 1 && level < 6) {
                this.list.add("\n" + chapter + "\n");
                this.isSetItem = true;
            }
        }
        return this;
    }

    @Override
    public Builder addParagraph(String body) {
        if (this.isSetTitle && this.isSetAuthor) {
            this.list.add(body);
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
