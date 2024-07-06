public class DecoratorFactory {
    public static Paper createPaper(String num, Paper paper) {
        switch (num) {
            case "tb": {
                return new DecoratorTable(paper);
            }
            case "eq": {
                return new DecoratorEquation(paper);
            }
            case "nt": {
                return new DecoratorDocumentation(paper);
            }
            case "d": {
                return new DecoratorPicture(paper);
            }
        }
        throw new RuntimeException("wrong DecoratorType");
    }
}
