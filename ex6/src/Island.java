import java.util.ArrayList;
import java.util.List;

public class Island extends Element {

    // composite design pattern
    private List<Element> elements;
    private String name;
    public Island(String name, double diameter, String path) {
        super(diameter,diameter,path);
        this.name = name;
        elements = new ArrayList<Element>();
    }

    @Override
    public void addElement(Element e) {
        if (e.getHabitat() == Habitat.TERRESTRIAL || e.getHabitat() == Habitat.AMPHIBIAN) {
            elements.add(e);
        } else {
            System.out.println(getName() + " cannot contain " + e.getName());
        }
    }

    public void accept(Visitor visitor) {
        // visitor design pattern
        visitor.visit(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
