public class VisitTotalArea implements Visitor {
    double sum = 0;

    @Override
    public void visit(Lake lake) {
        sum += lake.getLength() * lake.getLength() * Math.PI / 4;
    }

    @Override
    public void visit(Island island) {
        sum += island.getLength() * island.getLength() * Math.PI / 4;
    }
    @Override
    public void visit(Kite kite) {
        sum += kite.getLength() * kite.getWidth() / 2;
    }

    @Override
    public void visit(Flag flag) {
        sum += flag.getLength() * flag.getWidth();

    }

    @Override
    public void visit(Boat boat) {
        double half_circle = (boat.getWidth() / 2) * (boat.getWidth() / 2) * Math.PI / 2;
        double rectangle = boat.getWidth() * (boat.getLength() - (boat.getWidth() / 2));
        sum += half_circle + rectangle;
    }

    @Override
    public void visit(Tree tree) {
        sum += tree.getLength() * tree.getWidth() / 2;
    }

    @Override
    public void visit(Kid kid) {
        double half_circle = (kid.getWidth() / 2) * (kid.getWidth() / 2) * Math.PI;
        double rectangle = kid.getWidth() * (kid.getLength() - kid.getWidth());
        sum += half_circle + rectangle;
    }

    public int getSum() {
        return (int) Math.round(sum);
    }
}
