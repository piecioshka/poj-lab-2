package pl.piecioshka.poj_lab_2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        runTextBuilder();
        runHTMLBuilder();
    }

    private static void runTextBuilder() throws FileNotFoundException {
        TextBuilder textBuilder = new TextBuilder();
        director(textBuilder);
        saveToFile(textBuilder.buildText(), "data/document.txt");
    }

    private static void runHTMLBuilder() throws FileNotFoundException {
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        director(htmlBuilder);
        saveToFile(htmlBuilder.buildHTML(), "data/document.html");
    }

    private static void saveToFile(String text, String filename) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(text);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.toString());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("ERROR: " + e.toString());
            }
        }
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
                .addBulletListItem("Komputer")

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
                .finish()
        ;
    }
}
