package pl.piecioshka.poj_lab_2;

import java.util.ArrayList;

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
            this.list.add("\t\t<h1>" + title + "</h1>\n");
            this.isSetTitle = true;
        }
        return this;
    }

    @Override
    public HTMLBuilder addAuthor(String author) {
        if (this.isSetTitle && !this.isSetAuthor && !this.isSetItem && !this.isStartList && this.isBuildable) {
            this.list.add("\t\t<h2>" + author + "</h2>\n");
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
                        this.list.add("\t\t</ul>\n");
                        this.isStartList = false;
                    }
                    this.list.add("\n\t\t<h" + level + ">" + chapter + "</h" + level + ">\n");
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
                this.list.add("\t\t</ul>\n");
                this.isStartList = false;
            }
            this.list.add("\t\t<p>" + body + "</p>\n");
            this.isSetItem = true;
        }
        return this;
    }

    @Override
    public HTMLBuilder addBulletListItem(String name) {
        if (this.isSetTitle && this.isSetAuthor && this.isBuildable) {
            if (!this.isStartList) {
                this.list.add("\t\t<ul>\n");
            }
            this.list.add("\t\t\t<li>" + name + "</li>\n");
            this.isStartList = true;
        }
        return this;
    }

    @Override
    public void finish() {
        if (this.isStartList) {
            this.list.add("\t\t</ul>\n");
            this.isStartList = false;
        }
        this.isBuildable = false;

        this.list.add(0, "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t<title>Wzorzec projektowy: Builder</title>\n" +
                "</head>\n" +
                "<body>\n\n" +
                "\t<article>\n");

        this.list.add("\t</article>\n\n</body>\n</html>\n");
    }
}
