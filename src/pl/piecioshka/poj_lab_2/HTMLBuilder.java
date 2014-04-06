package pl.piecioshka.poj_lab_2;

import java.util.ArrayList;
import pl.piecioshka.utils.StringUtils;

public class HTMLBuilder implements Builder {
    private final ArrayList<String> list;

    public HTMLBuilder() {
        this.list = new ArrayList<String>();
    }

    public String buildHTML() {
        String html = "";
        for (Object item : this.list) {
            html += (String) item;
        }
        return html;
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
    public HTMLBuilder addTitle(String title) {
        if (!this.isSetTitle && !this.isSetAuthor && !this.isSetItem && !this.isStartList && this.isBuildable) {
            this.list.add("<h1>" + title + "</h1>");
            this.isSetTitle = true;
        }
        return this;
    }

    @Override
    public HTMLBuilder addAuthor(String author) {
        if (this.isSetTitle && !this.isSetAuthor && !this.isSetItem && !this.isStartList && this.isBuildable) {
            this.list.add("<h2>" + author + "</h2>\n");
            this.isSetAuthor = true;
        }
        return this;
    }

    @Override
    public HTMLBuilder addChapter(String chapter, int level) {
        if (this.isSetTitle && this.isSetAuthor && this.isBuildable) {
            if (level >= 1 && level <= 4) {
                if (level > headerLevel && level == headerLevel + 1 || level < headerLevel) {
                    if (this.isStartList) {
                        this.list.add("</ul>");
                        this.isStartList = false;
                    }
                    this.list.add("\n<h" + level + ">" + chapter + "</h" + level + ">");
                    this.isSetItem = true;
                    this.headerLevel = level;
                }
            }
        }
        return this;
    }

    @Override
    public HTMLBuilder addParagraph(String body) {
        if (this.isSetTitle && this.isSetAuthor && this.isBuildable) {
            if (this.isStartList) {
                this.list.add("</ul>");
                this.isStartList = false;
            }
            this.list.add("<p>" + body + "</p>");
            this.isSetItem = true;
        }
        return this;
    }

    @Override
    public HTMLBuilder addBulletListItem(String name) {
        if (this.isSetTitle && this.isSetAuthor && this.isBuildable) {
            if (!this.isStartList) {
                this.list.add("<ul>");
            }
            this.list.add(StringUtils.repeat(" ", 4) + "<li>" + name + "</li>");
            this.isStartList = true;
        }
        return this;
    }

    @Override
    public HTMLBuilder finish() {
        if (this.isStartList) {
            this.list.add("</ul>");
            this.isStartList = false;
        }
        this.isBuildable = false;

        this.list.add(0, "<meta charset=\"utf-8\">");
        return this;
    }
}
