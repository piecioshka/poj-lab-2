package app;

import java.util.ArrayList;
import java.util.Iterator;

public class TextBuilder implements Builder {
    private final ArrayList list;
    
    public TextBuilder() {
        this.list = new ArrayList();
    }

    public void buildText() {
        Iterator<Object> it = this.list.iterator();
        while(it.hasNext()) {
            Object item = it.next();
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
    public Builder addChapter(String chapter) {
        this.list.add("\n" + chapter + "\n");
        return this;
    }

    @Override
    public Builder addSubChapter(String chapter) {
        this.list.add(chapter);
        return this;
    }

    @Override
    public Builder addParagraph(String body) {
        this.list.add(body);
        return this;
    }

    @Override
    public Builder addBulletedListItem(String name) {
        this.list.add(" - " + name);
        return this;
    }
}
