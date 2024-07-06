import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "p: Papers");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }
    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();

        Files.lines(Paths.get(path))
            .map(ElementDetailsFactory::getPaintingElement)
            .forEach(painting::addElement);
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path=scanner.nextLine();
        Painting root= readElementDetails(path);
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    VisitCount visitCount = new VisitCount();
                    root.accept(visitCount);
                    System.out.println(visitCount.getSum());
                    break;
                case "sh":
                    VisitShortPrint visitShortPrint = new VisitShortPrint();
                    root.accept(visitShortPrint);
                    break;
                case "ta":
                    VisitTotalArea visitTotalArea = new VisitTotalArea();
                    root.accept(visitTotalArea);
                    System.out.println(visitTotalArea.getSum());
                    break;
                case "lp":
                    VisitLongPrint visitLongPrint = new VisitLongPrint();
                    root.accept(visitLongPrint);
                    System.out.println("");
                    break;
            }

        }
    }

    public static void paperMenu(Scanner scanner){
        System.out.println("Choose from the following paper:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "pr: journal article\n" +
                "bk: book");
        String p = scanner.nextLine();
        Paper paper = PaperFactory.createPaper(p);
        String choice="";
        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());

            }
        }


    }
   public static Paper paperElementMenu(Scanner scanner, Paper paper){
        System.out.println("Choose from the following elements:\n" +
                "tb: table\n" +
                "eq: equation\n" +
                "d: diagram\n" +
                "nt: note");
       String num = scanner.nextLine();
       return DecoratorFactory.createPaper(num, paper);
    }
}
