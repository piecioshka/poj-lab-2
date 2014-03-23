package app;

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextBuilder b = new TextBuilder();
        App.director(b);
        b.buildText();
    }
    
    public static void director(Builder builder) {
        builder.addTitle("Księga czarów")
                .addAuthor("Piotr Kowalski")
                .addChapter("Biała magia")
                .addParagraph("Lorem ipsum...1")
                .addParagraph("Lorem ipsum...2")
                .addChapter("Czarna magia")
                .addParagraph("Lorem ipsum...3")
                .addParagraph("Lorem ipsum...4")
                .addBulletedListItem("Piekło")
                .addBulletedListItem("Niebo")
        ;
    }
}
