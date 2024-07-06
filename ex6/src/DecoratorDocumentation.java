public class DecoratorDocumentation extends DecoratorPaper {

    public DecoratorDocumentation(Paper paper) {
        super(paper);
    }

    @Override
    public String write() {
        return super.write() + " Note";
    }
}
