
public class PaperFactory {
    public static Paper createPaper(String code) {

        switch (code) {
            case "ac": {
                return new AcademicPaper();
            }
            case "cn": {
                return new Contract();
            }
            case "jr": {
                return new JournalArticle();
            }
            case "bk": {
                return new Book();
            }
        }
        throw new RuntimeException("wrong PaperType");
    }
}