 

public class Boat extends Element{
    Material material;
    public Boat(double width, double length, Material m, String path) {
        super(width, length, path);
        this.material=m;
    }

    public Material getMaterial() {
        return material;
    }

    public void accept(Visitor visitor) {
        // visitor design pattern
        visitor.visit(this);
    }

    @Override
    public void addElement(Element e) {}

    public String getName() {
        return "boat";
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }
}
