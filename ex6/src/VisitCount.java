public class VisitCount implements Visitor {
    int sum = 0;

    @Override
    public void visit(Lake lake) {
        sum++;
    }

    @Override
    public void visit(Island island) {
        sum++;
    }

    @Override
    public void visit(Kite kite) {
        sum++;
    }

    @Override
    public void visit(Flag flag) {
        sum++;
    }

    @Override
    public void visit(Boat boat) {
        sum++;
    }

    @Override
    public void visit(Tree tree) {
        sum++;
    }

    @Override
    public void visit(Kid kid) {
        sum++;
    }

    public int getSum() {
        return sum;
    }
}
