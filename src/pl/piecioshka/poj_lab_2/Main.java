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

                .addChapter("Czarna magia", 2)
                .addParagraph("Paragraf...3")

                .addChapter("Czarna magia", 3)
                .addParagraph("Paragraf...4")

                .addChapter("Czarna magia", 2)
                .addParagraph("Paragraf...5")

                .addChapter("Czarna magia", 3)
                .addParagraph("Paragraf...6")

                .addChapter("Czarna magia", 4)
                .addParagraph("Paragraf...7")
                .addParagraph("Paragraf...8")

                .addChapter("Czarna magia", 5)

                .addChapter("Czarna magia", 6)
                .addParagraph("Paragraf...9")

                .addBulletListItem("Piekło")
                .addBulletListItem("Niebo")
        ;
    }
}
