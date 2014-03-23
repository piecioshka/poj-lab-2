package app;

import java.util.ArrayList;
import java.util.Iterator;

public class HTMLBuilder implements Builder {
    private final ArrayList list;
    
    public HTMLBuilder() {
        this.list = new ArrayList();
    }
    
    public void buildHTML() {
        Iterator<Object> it = this.list.iterator();
        while(it.hasNext()) {
            Object item = it.next();
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
    public Builder addChapter(String chapter) {
        this.list.add("<p>" + chapter + "</p>");
        return this;
    }

    @Override
    public Builder addSubChapter(String chapter) {
        this.list.add(chapter);
        return this;
    }

    @Override
    public Builder addParagraph(String body) {
        this.list.add("<p>" + body + "</p>");
        return this;
    }

    @Override
    public Builder addBulletedListItem(String name) {
        this.list.add("<li>" + name + "</li>");
        return this;
    }
}
