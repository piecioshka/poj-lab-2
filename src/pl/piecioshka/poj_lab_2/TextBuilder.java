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

    @Override
    public Builder addTitle(String title) {
        this.list.add(title);
        return this;
    }

    @Override
    public Builder addAuthor(String author) {
        this.list.add(author + "\n");
        return this;
    }

    @Override
    public Builder addChapter(String chapter, Integer level) {
        if (level > 1 && level < 6) {
            this.list.add("\n" + chapter + "\n");
        }
        return this;
    }

    @Override
    public Builder addParagraph(String body) {
        this.list.add(body);
        return this;
    }

    @Override
    public Builder addBulletListItem(String name) {
        this.list.add(" - " + name);
        return this;
    }
}
