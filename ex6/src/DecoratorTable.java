public class DecoratorTable extends DecoratorPaper{
    public DecoratorTable(Paper paper) {
        super(paper);
    }

    @Override
    public String write() {
        return super.write() + " Table";
    }
}
