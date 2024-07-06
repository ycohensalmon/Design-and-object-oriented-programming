 
public class Tree extends Element {

    int leavesAmount;

    public int getLeavesAmount() {
        return leavesAmount;
    }

    public Tree(double width, double height, int leavesAmount, String path) {
        super(width, height, path);
        this.leavesAmount = leavesAmount;
    }

    public void accept(Visitor visitor) {
        // visitor design pattern
        visitor.visit(this);
    }

    @Override
    public void addElement(Element e) {}

    @Override
     public String getName() {
        return "tree";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
}
