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

    @Override
    public Builder addTitle(String title) {
        this.list.add("<h1>" + title + "</h1>");
        return this;
    }

    @Override
    public Builder addAuthor(String author) {
        this.list.add("<h2>" + author + "</h2>");
        return this;
    }

    @Override
    public Builder addChapter(String chapter, Integer level) {
        this.list.add("<h" + level + ">" + chapter + "</h" + level + ">");
        return this;
    }

    @Override
    public Builder addParagraph(String body) {
        this.list.add("<p>" + body + "</p>");
        return this;
    }

    @Override
    public Builder addBulletListItem(String name) {
        this.list.add("<li>" + name + "</li>");
        return this;
    }
}
