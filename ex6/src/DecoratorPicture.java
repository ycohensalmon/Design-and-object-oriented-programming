public class DecoratorPicture extends DecoratorPaper{

    public DecoratorPicture(Paper paper) {
        super(paper);
    }

    @Override
    public String write() {
        return super.write() + " Diagram";
    }
}
