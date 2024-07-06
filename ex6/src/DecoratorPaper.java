public class DecoratorPaper implements Paper{
    private Paper paper;

    public DecoratorPaper(Paper paper) {
        this.paper = paper;
    }

    public String write() {
        return paper.write();
    }
}
