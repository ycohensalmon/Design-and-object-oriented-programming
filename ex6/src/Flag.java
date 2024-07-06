 

public class Flag extends Element {

    Color color;
    int carrierHeight;

    public Flag(double width, double length, Color color, int carrierHeight, String path) {
        super(width, length, path);
        this.color = color;
        this.carrierHeight = carrierHeight;
    }

 
    public Color getColor() {
        return color;
    }

    public int getCarrierHeight() {
        return carrierHeight;
    }

    public void accept(Visitor visitor) {
        // visitor design pattern
        visitor.visit(this);
    }

    @Override
    public void addElement(Element e) {}

    @Override
    public String getName() {
        return Flag.class.getSimpleName().toLowerCase();
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }
}
