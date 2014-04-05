package pl.piecioshka.poj_lab_2;

public class Main {
    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        Main.director(textBuilder);
        textBuilder.buildText();

        System.out.println("----------------------------");

        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Main.director(htmlBuilder);
        htmlBuilder.buildHTML();
    }

    public static void director(Builder builder) {
        builder.addTitle("Księga czarów")
                .addAuthor("Piotr Kowalski")
                .addChapter("Biała magia", 1)
                .addParagraph("Lorem ipsum...1")
                .addParagraph("Lorem ipsum...2")
                .addChapter("Czarna magia", 1)
                .addParagraph("Lorem ipsum...3")
                .addParagraph("Lorem ipsum...4")
                .addBulletListItem("Piekło")
                .addBulletListItem("Niebo")
        ;
    }
}
