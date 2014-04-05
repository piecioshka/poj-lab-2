package pl.piecioshka.poj_lab_2;

public class Main {
    public static void main(String[] args) {
        Main.runTextBuilder();
        // Main.runHTMLBuilder();
    }

    private static void runTextBuilder() {
        TextBuilder textBuilder = new TextBuilder();
        Main.director(textBuilder);
        textBuilder.buildText();
    }

    private static void runHTMLBuilder() {
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Main.director(htmlBuilder);
        htmlBuilder.buildHTML();
    }

    private static void director(Builder builder) {
        builder
                .addTitle("Księga czarów")
                .addAuthor("Piotr Kowalski")

                .addChapter("Biała magia", 1)
                .addParagraph("Paragraf...1")
                .addParagraph("Paragraf...2")

                .addChapter("Czarna magia", 1)
                .addParagraph("Paragraf...3")
                .addParagraph("Paragraf...4")

                .addBulletListItem("Piekło")
                .addBulletListItem("Niebo")
        ;
    }
}
