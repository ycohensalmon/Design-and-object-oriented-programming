public class DecoratorEquation extends DecoratorPaper{
    public DecoratorEquation(Paper paper) {
        super(paper);
    }

    @Override
    public String write() {
        return super.write() + " Equation";
    }
}
