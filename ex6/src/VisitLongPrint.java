public class VisitLongPrint implements Visitor {
    @Override
    public void visit(Kite kite) {
        System.out.print("A kite of color: " + kite.getColor() + ". ");
    }

    @Override
    public void visit(Flag flag) {
        System.out.print("A flag with color: " + flag.getColor() + " of height " + flag.getCarrierHeight() + ". ");
    }

    @Override
    public void visit(Boat boat) {
        System.out.print("A boat made of " + boat.getMaterial() + " material. ");
    }

    @Override
    public void visit(Tree tree) {
        System.out.print("A tree with an amount of " + tree.getLeavesAmount() + " leaves. ");
    }

    @Override
    public void visit(Lake lake) {
        System.out.print(lake.isEmpty() ? "An empty lake named " + lake.getName() + ". " : "A lake named " + lake.getName() + " containing: ");
    }

    @Override
    public void visit(Island island) {
        System.out.print(island.isEmpty() ? "An empty island named " + island.getName() + ". " : "An island named " + island.getName() + " containing: ");
    }

    @Override
    public void visit(Kid kid) {
        int age = 2024 - kid.getBirthYear();
        System.out.print("A " + age + " year old kid with " + kid.getHairColor() + " hair. ");
    }
}
